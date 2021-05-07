package screens;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverProvider;

import java.util.stream.IntStream;

import static settings.EnvironmentConfig.ENVIRONMENT_CONFIG;


public class Pin {

    @AndroidFindBy(id = "pinpad_1")
    public AndroidElement numberKey;

    @Getter
    @AndroidFindBy(id = "first_pin_header")
    public AndroidElement createPinScreenHeaderText;

    @AndroidFindBy(id = "second_pin_header")
    public AndroidElement confirmPinScreenHeaderText;

    @AndroidFindBy(id = "pin_dots")
    public AndroidElement pinPadFields;

    @AndroidFindBy(id = "pinpad")
    public AndroidElement numbersKeyboard;

    @AndroidFindBy(id = "pinpad_delete")
    public AndroidElement deleteButton;

    @AndroidFindBy(id = "header")
    public AndroidElement enterYourPinHeader;

    @AndroidFindBy(id = "pinpad_forgot")
    public AndroidElement forgetPinButton;

    @AndroidFindBy(id = "error_text")
    public AndroidElement errorMessage;

    @AndroidFindBy(id = "pinpad_2")
    private AndroidElement wrongNumberKey;

    public Pin() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverProvider.getInstance()), this);
    }

    public void setAndConfirm() {
        WebDriverWait wait = new WebDriverWait(DriverProvider.getInstance(),ENVIRONMENT_CONFIG.getWaitingTimeoutForElementPresence());
        wait.until(ExpectedConditions.visibilityOf(createPinScreenHeaderText));
        set();
        wait.until(ExpectedConditions.visibilityOf(confirmPinScreenHeaderText));
        confirm();
    }

    public void enter() {
        WebDriverWait wait = new WebDriverWait(DriverProvider.getInstance(),ENVIRONMENT_CONFIG.getWaitingTimeoutForElementPresence());
        wait.until(ExpectedConditions.visibilityOf(numberKey));
        numberKey.click();
        numberKey.click();
        numberKey.click();
        numberKey.click();
    }

    public void enterWrongNumber() {
        var wait = new WebDriverWait(DriverProvider.getInstance(),ENVIRONMENT_CONFIG.getWaitingTimeoutForElementPresence());
        wait.until(ExpectedConditions.visibilityOf(wrongNumberKey));
        wrongNumberKey.click();
        wrongNumberKey.click();
        wrongNumberKey.click();
        wrongNumberKey.click();
    }

    public void enterWrongNumberTenTimes() {
        IntStream.range(0, 10).forEach(i -> enterWrongNumber());
    }

    public AndroidElement waitForPinPadDisplayed() {
        var wait = new WebDriverWait(DriverProvider.getInstance(),ENVIRONMENT_CONFIG.getWaitingTimeoutForElementPresence());
        wait.until(ExpectedConditions.visibilityOf(numberKey));
        return numberKey;
    }

    private void set() {
        enter();
    }

    private void confirm() {
        enter();
    }
}
