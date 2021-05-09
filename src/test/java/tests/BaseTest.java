package tests;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import com.google.gson.Gson;
import lombok.val;
import mocks.Codes.CountryCode;
import mocks.ForSignUpTest.SignUpForm.SignupForm;
import mocks.TC2.*;
import mocks.TC2.country.Country;
import mocks.ForSignUpTest.Countries;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.okJson;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static java.lang.String.format;
import static mocks.Codes.CountryCode.getByCode;
import static mocks.TC2.country.Country.getCorridorForCountry;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_MOVED_TEMPORARILY;

public abstract class BaseTest {

    static Gson gson = new Gson();
    private static WireMockServer wireMockServer;

    @BeforeAll
    public static void beforeAll(){
        wireMockServer = new WireMockServer(wireMockConfig()
                .port(1665)
                .httpsPort(1666)
                .keystorePath(FirstTest.class.getResource("/mocks/wiremock.jks").getPath())
                .extensions(new ResponseTemplateTransformer(true)));
        WireMock.configureFor(1665);
        wireMockServer.start();
    }

    @BeforeEach
    public void beforeEach(){
        wireMockServer.resetMappings();
    }

    void setStubsForSignUpTest() {
        stubFor(get(urlEqualTo("/legacy-api/countries")).willReturn(okJson(gson.toJson(Countries.getDefaultCountries()))));
        stubFor(get(urlEqualTo("/legacy-api/my-country")).willReturn(okJson(gson.toJson(Countries.get(CountryCode.GB)))));
        stubFor(get(urlEqualTo("/mercury/signup")).willReturn(okJson(gson.toJson(SignupForm.getDefaultSignupFormResponseBuilder()))));
    }


    public void setStubForCountry(Country country) {
        val countryCode = country.info.code;
        stubFor(get(urlPathMatching(String.format("/legacy-api/country/GB/%s", countryCode)))
                .willReturn(okJson(gson.toJson(getCorridorForCountry(getByCode(countryCode)).toBuilder()
                        .currencies(country.currencies).build()))));
        stubFor(get(urlEqualTo(String.format("/legacy-api/country/%s", country.info.code)))
                .willReturn(okJson(gson.toJson(country))));
        stubFor(get(urlEqualTo(String.format("/legacy-api/country/send/%s", country.info.code))).willReturn(okJson(gson.toJson(country))));
    }

    public void setStubForTransactions(List<Transaction> transactions) {
        var transactionsCybPayment = new TransactionsCybPayment();

        stubFor(get(urlEqualTo("/legacy-api/transactions")).willReturn(okJson(gson.toJson(transactions))));
        stubFor(get(urlEqualTo("/mercury/transactions-statuses")).willReturn(okJson(gson.toJson(transactions))));
        for (Transaction transaction : transactions) {
            stubFor(post(urlEqualTo("/legacy-api/transactions"))
                    .withRequestBody(matchingJsonPath("$[?(@.payment_method != "
                            + "'20')]"))
                    .willReturn(aResponse().withStatus(SC_CREATED)
                            .withHeader(
                                    "Id",
                                    transaction.getId())
                            .withHeader("Location", "https://api.staging.worldremit.com/api/Transactions/" + transaction.getId())
                    ));
            stubFor(post(urlEqualTo("/legacy-api/transactions")).withRequestBody(matchingJsonPath("$[?(@.payment_method == '20')]"))
                    .willReturn(okJson(
                            gson.toJson(transactionsCybPayment.getCybPaymentResponse(transaction.getId()))).withStatus(SC_MOVED_TEMPORARILY)));
            stubFor(get(urlEqualTo(format("/legacy-api/transactions/pending/%s", transaction.getId()))).willReturn(okJson(
                    gson.toJson(transaction.toBuilder().status(0).build()))));

            stubFor(get(urlEqualTo(format("/mercury/transactions/%s/actions", transaction.getId())))
                    .willReturn(okJson(gson.toJson(Actions.getManualActions()))));
        }
        stubFor(get(urlEqualTo("/legacy-api/transactions/byrecipient/mostrecent")).willReturn(okJson(gson.toJson(transactions))));
    }


}
