package tests;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;

import com.google.gson.Gson;
import com.worldremit.codes.CountryCode;
import model.legacyapi.countries.Countries;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import screens.GettingStarted;
import screens.Login;
import screens.Pin;


import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.okJson;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class FirstTest {

    private GettingStarted gettingStarted;
    private Login login;
    private Pin pin;

    @BeforeAll
    public static void beforeAll(){

    }

    @Test
    public void test(){

        WireMockServer wireMockServer = new WireMockServer(wireMockConfig()
                .port(1666)
                .httpsPort(1665)
                .keystorePath(FirstTest.class.getResource("/mocks/wiremock.jks").getPath())
                .extensions(new ResponseTemplateTransformer(true)));
        WireMock.configureFor(1666);
        wireMockServer.start();
        stubFor(get(urlEqualTo("/legacy-api/countries")).willReturn(okJson(new Gson().toJson(Countries.getDefaultCountries()))));
        stubFor(get(urlEqualTo("/legacy-api/my-country")).willReturn(okJson(new Gson().toJson(Countries.get(CountryCode.GB)))));


        gettingStarted = new GettingStarted();
        login = new Login();
        gettingStarted.clickSignIn();
        login.login("asd@asd.aa","asdasd");
    }

}
