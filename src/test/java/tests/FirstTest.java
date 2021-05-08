package tests;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import com.google.gson.Gson;
import lombok.val;
import mocks.Codes.CountryCode;
import mocks.ForSignUpTest.SignUpForm.SignupForm;
import mocks.TC3.*;
import mocks.TC3.account.DetailsResponse;
import mocks.TC3.account.preferences.NotificationsResponse;
import mocks.TC3.country.Country;
import mocks.TC3.onboarding.OnBoardingStep;
import mocks.TC3.onboarding.OnboardingResponse;
import mocks.legacyapi.countries.Countries;
import models.Sender;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import screens.GettingStarted;
import screens.Login;
import screens.Pin;
import screens.SignUp;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static java.util.Collections.singletonList;
import static mocks.Codes.CountryCode.GB;
import static mocks.Codes.CountryCode.getByCode;
import static mocks.TC3.AccountResponse.getActivatedAccountResponse;
import static mocks.TC3.ConfigurationResponse.getDefaultConfigurationResponseWithCountryParam;
import static mocks.TC3.ConfigurationResponse.getInitialConfigurationResponse;
import static mocks.TC3.DeliveryMethod.BANK_DEPOSIT_DEFAULT;
import static mocks.TC3.country.Country.getCorridorForCountry;
import static mocks.TC3.country.Country.getGb;
import static mocks.TC3.recipients.RecipientResponse.getGenericRecipient;

public class FirstTest {

    private static WireMockServer wireMockServer;
    private static Gson gson = new Gson();
    private GettingStarted gettingStarted;
    private Login login;
    private Pin pin;

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

    @Test
    public void singUpTest(){
        stubFor(get(urlEqualTo("/legacy-api/countries")).willReturn(okJson(gson.toJson(Countries.getDefaultCountries()))));
        stubFor(get(urlEqualTo("/legacy-api/my-country")).willReturn(okJson(gson.toJson(Countries.get(CountryCode.GB)))));
        stubFor(get(urlEqualTo("/mercury/signup")).willReturn(okJson(gson.toJson(SignupForm.getDefaultSignupFormResponseBuilder()))));

        gettingStarted = new GettingStarted();
        gettingStarted.clickGetStarted();
        SignUp signUp = new SignUp();
        signUp.fillForm(Sender.builder().build());
        signUp.clickSignUpButton();
    }

    @Test
    public void TC2(){
        stubFor(get(urlEqualTo("/legacy-api/countries")).willReturn(okJson(gson.toJson(Countries.getDefaultCountries()))));
        stubFor(get(urlEqualTo("/legacy-api/my-country")).willReturn(okJson(gson.toJson(Countries.get(CountryCode.GB)))));
        gettingStarted = new GettingStarted();
        login = new Login();
        gettingStarted.clickSignIn();
        login.login("asd@asd.aa","asdasd");
    }

    @Test
    public void TC3(){
        var sender = Sender.builder().build();

        stubFor(get(urlEqualTo("/mercury/signup")).willReturn(okJson(gson.toJson(SignupForm.getDefaultSignupFormResponseBuilder()))));
        setStubsForSender(sender);
        setStubForCountry(getGb());
        stubFor(get(urlEqualTo("/legacy-api/countries")).willReturn(okJson(gson.toJson(Countries.getDefaultCountries()))));
        stubFor(get(urlEqualTo("/legacy-api/my-country")).willReturn(okJson(gson.toJson(Countries.get(CountryCode.GB)))));
        stubFor(get(urlEqualTo("/mercury/account/preferences/notifications")).willReturn(okJson(gson.toJson(NotificationsResponse.builder().build()))));
        stubFor(get(urlEqualTo("/mercury/account")).willReturn(okJson(gson.toJson(getActivatedAccountResponse(sender, CountryCode.GB)))));
        stubFor(get(urlEqualTo("/legacy-api/transactions")).willReturn(okJson(gson.toJson(List.of(Transaction.getBankTransaction(Recipient.builder().build(),BANK_DEPOSIT_DEFAULT))))));
        stubFor(get(urlEqualTo("/legacy-api/recipients")).willReturn(okJson(gson.toJson(singletonList(getGenericRecipient(Recipient.builder().build()))))));
        stubFor(get(urlEqualTo("/mercury/onboarding")).willReturn(okJson(gson.toJson(OnboardingResponse.getResponseForStep(OnBoardingStep.ACTIVATION)))));
        stubFor(get(urlEqualTo("/mercury/configuration")).willReturn(okJson(gson.toJson(getDefaultConfigurationResponseWithCountryParam()))));
        stubFor(get(urlPathMatching("/mercury/configuration")).withQueryParam("sendCountryCode", equalTo(GB.getAlpha2()))
                .willReturn(okJson(gson.toJson(ConfigurationResponse.getDefaultConfigurationResponseWithCountryParam()))));

        stubFor(get(urlEqualTo("/mercury/wallets")).willReturn(okJson(gson.toJson(Collections.EMPTY_LIST))));


        gettingStarted = new GettingStarted();
        login = new Login();
        gettingStarted.clickSignIn();
        login.login(sender);
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

    public void setStubsForSender(Sender sender) {
        LoginStub.builder().forSender().withSuccessResponse().build();
        stubFor(get(urlEqualTo("/mercury/account/details")).willReturn(okJson(gson.toJson(DetailsResponse.getDetailsResponse(sender)))));
    }
}
