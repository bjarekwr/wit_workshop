package tests;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import com.google.gson.Gson;
import mocks.Codes.CountryCode;
import mocks.ForSignUpTest.Countries;
import mocks.ForSignUpTest.SignUpForm.SignupForm;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public abstract class BaseTest {

    static Gson gson = new Gson();
    private static WireMockServer wireMockServer;

    @BeforeAll
    public static void beforeAll(){
        wireMockServer = new WireMockServer(wireMockConfig()
                .port(1665)
                .httpsPort(1666)
                .keystorePath(WRAndroidTests.class.getResource("/mocks/wiremock.jks").getPath())
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

}
