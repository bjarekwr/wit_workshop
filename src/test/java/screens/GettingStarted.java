package screens;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import utils.DriverProvider;

import java.time.Duration;

import static settings.EnvironmentConfig.ENVIRONMENT_CONFIG;


public class GettingStarted {


    @AndroidFindBy(id = "get_started_button")
    private AndroidElement getStartedButton;

    @AndroidFindBy(id = "com.worldremit.android.dev:id/sign_in_button")
    private AndroidElement signInButton;

    @AndroidFindBy(id = "notification_dialog_primary_button")
    private AndroidElement notificationButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.worldremit.android.dev:id/title_text_view\")"
                                 + ".textMatches(\"We’re Simple\")")
    private AndroidElement firstOnboardingPage;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.worldremit.android.dev:id/title_text_view\")"
                                 + ".textMatches(\"We’re Fast\")")
    private AndroidElement secondOnboardingPage;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.worldremit.android.dev:id/title_text_view\")"
                                 + ".textMatches(\"We’re Safe\")")
    private AndroidElement thirdOnboardingPage;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.worldremit.android.dev:id/title_text_view\")"
                                 + ".textMatches(\"We’re Low Cost\")")
    private AndroidElement fourthOnboardingPage;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.worldremit.android.dev:id/title_text_view\")"
                                 + ".text(\"125,000+ five-star reviews\")")
    private AndroidElement fifthOnboardingPage;

    @AndroidFindBy(id = "page_indicator")
    private AndroidElement pageIndicator;

    public GettingStarted() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverProvider.getInstance(), Duration.ofSeconds(ENVIRONMENT_CONFIG.getWaitingTimeoutInSeconds())), this);
    }


    public void clickSignIn() {
        signInButton.click();
    }


    public void clickCheckRate() {
        getStartedButton.click();
    }


    public void clickGetStarted() {
        getStartedButton.click();
    }

    public AndroidElement getFirstOnboardingPage() {
        return firstOnboardingPage;
    }

    public AndroidElement getSecondOnboardingPage() {
        return secondOnboardingPage;
    }

    public AndroidElement getThirdOnboardingPage() {
        return thirdOnboardingPage;
    }

    public AndroidElement getFourthOnboardingPage() {
        return fourthOnboardingPage;
    }

    public AndroidElement getFifthOnboardingPage() {
        return fifthOnboardingPage;
    }

    public AndroidElement getPageIndicator() {
        return pageIndicator;
    }
}
