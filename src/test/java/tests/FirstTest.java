package tests;

import mocks.Codes.CountryCode;
import mocks.TC2.AccessTokenResponse;
import mocks.TC2.ConfigurationResponse;
import mocks.TC2.Recipient;
import mocks.TC2.Transaction;
import mocks.TC2.account.DetailsResponse;
import mocks.TC2.account.preferences.NotificationsResponse;
import mocks.TC2.feature.ReferralResponse;
import mocks.TC2.onboarding.OnBoardingStep;
import mocks.TC2.onboarding.OnboardingResponse;
import models.Sender;
import org.junit.jupiter.api.Test;
import screens.GettingStarted;
import screens.Login;
import screens.Pin;
import screens.SignUp;

import java.util.Collections;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static mocks.Codes.CountryCode.GB;
import static mocks.TC2.AccountResponse.getActivatedAccountResponse;
import static mocks.TC2.ConfigurationResponse.getDefaultConfigurationResponseWithCountryParam;
import static mocks.TC2.DeliveryMethod.CASH_PICKUP_CEBUANA;
import static mocks.TC2.country.Country.getGb;
import static mocks.TC2.recipients.RecipientResponse.getGenericRecipient;

public class FirstTest extends BaseTest {


    private GettingStarted gettingStarted;
    private Login login;
    private Pin pin;

    @Test
    public void singUpTest(){
        setStubsForSignUpTest();

        gettingStarted = new GettingStarted();
        gettingStarted.clickGetStarted();
        SignUp signUp = new SignUp();
        signUp.fillForm(Sender.builder().build());
        signUp.clickSignUpButton();
    }

    @Test
    public void TC1(){
        setStubsForSignUpTest();
        gettingStarted = new GettingStarted();
        login = new Login();
        gettingStarted.clickSignIn();
        login.login("asd@asd.aa","asdasd");
    }

    @Test
    public void TC2(){
        var sender = Sender.builder().build();
        setStubsForSignUpTest();


        stubFor(post(urlEqualTo("/mercury/auth/login")).willReturn(okJson(gson.toJson(AccessTokenResponse.builder().build()))));
        stubFor(get(urlEqualTo("/mercury/account/details")).willReturn(okJson(gson.toJson(DetailsResponse.getDetailsResponse(sender)))));

        setStubForCountry(getGb());
        stubFor(get(urlEqualTo("/mercury/account/preferences/notifications")).willReturn(okJson(gson.toJson(NotificationsResponse.builder().build()))));
        stubFor(get(urlEqualTo("/mercury/account")).willReturn(okJson(gson.toJson(getActivatedAccountResponse(sender, CountryCode.GB)))));
        var recipient = Recipient.builder().build();
        stubFor(get(urlEqualTo("/legacy-api/recipients")).willReturn(okJson(gson.toJson(singletonList(getGenericRecipient(recipient))))));
        stubFor(get(urlEqualTo("/mercury/onboarding")).willReturn(okJson(gson.toJson(OnboardingResponse.getResponseForStep(OnBoardingStep.ACTIVATION)))));
        stubFor(get(urlEqualTo("/mercury/configuration")).willReturn(okJson(gson.toJson(getDefaultConfigurationResponseWithCountryParam()))));
        stubFor(get(urlPathMatching("/mercury/configuration")).withQueryParam("sendCountryCode", equalTo(GB.getAlpha2()))
                .willReturn(okJson(gson.toJson(ConfigurationResponse.getDefaultConfigurationResponseWithCountryParam()))));
        stubFor(get(urlEqualTo("/mercury/wallets")).willReturn(okJson(gson.toJson(Collections.EMPTY_LIST))));
        // transaction
        setStubForTransactions(singletonList(Transaction.getGbToPhTransaction(recipient, CASH_PICKUP_CEBUANA)));
        // referal
        stubFor(get(urlEqualTo("/legacy-api/feature/referral")).willReturn(okJson(gson.toJson(ReferralResponse.getDefault()))));
        // recurring pay
        stubFor(get(urlEqualTo("/mercury/recurring-payment/info")).willReturn(okJson(gson.toJson(emptyList()))));

        gettingStarted = new GettingStarted();
        login = new Login();
        gettingStarted.clickSignIn();
        login.login(sender);
    }

}
