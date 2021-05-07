package screens;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverProvider;

import static settings.EnvironmentConfig.ENVIRONMENT_CONFIG;

public class Login {

    @AndroidFindBy(id = "welcome")
    public AndroidElement welcomeLabel;

    @AndroidFindBy(id = "email")
    public AndroidElement emailField;

    @AndroidFindBy(id = "password")
    public AndroidElement passField;

    @AndroidFindBy(id = "text_input_end_icon")
    private AndroidElement showPasswordSwitch;

    @AndroidFindBy(id = "progress")
    private AndroidElement progressBar;

    @AndroidFindBy(id = "sign_up_button")
    private AndroidElement signUpLabel;

    @AndroidFindBy(id = "forgot_password")
    private AndroidElement forgottenPasswordLabel;

    @AndroidFindBy(id = "login_button")
    private AndroidElement loginButton;

    @AndroidFindBy(uiAutomator =
                       "new UiSelector().resourceId(\"com.worldremit.android.dev:id/toolbar\").childSelector(new UiSelector().className"
                       + "(\"android.widget.ImageButton\"));")
    private AndroidElement backButton;

    @AndroidFindBy(id = "textinput_error")
    private AndroidElement textFieldInputError;

    public Login() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverProvider.getInstance()), this);
    }

    public void goToSignUpForm() {
        signUpLabel.click();
    }


    public void clickForgetPassword() {
        forgottenPasswordLabel.click();
    }


    public void clickBackButton() {
        backButton.click();
    }


    public void login(final String email, final String password) {
        fillLoginData(email, password);
        clickLoginButton();
    }

    public void clearEmailField() {
        emailField.clear();
    }

    public void clearPasswordField() {
        passField.clear();
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void showPassword() {
        // FIXME: 6/16/20 this cond should be removed and ios fix this point in the APP
        if (showPasswordSwitch.isDisplayed()) {
            showPasswordSwitch.click();
        }
    }

    private void fillLoginData(String email, String password) {
        WebDriverWait wait = new WebDriverWait(DriverProvider.getInstance(),ENVIRONMENT_CONFIG.getWaitingTimeoutForElementPresence());
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.setValue(email);
        passField.setValue(password);
    }
}
