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

    public GettingStarted() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverProvider.getInstance(), Duration.ofSeconds(ENVIRONMENT_CONFIG.getWaitingTimeoutInSeconds())), this);
    }

    public void clickGetStarted() {
        getStartedButton.click();
    }
}
