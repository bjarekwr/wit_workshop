package screens;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mocks.Codes.CountryCode;
import models.Sender;
import org.openqa.selenium.support.PageFactory;
import utils.DriverProvider;

import java.util.List;

import static io.appium.java_client.touch.offset.PointOption.point;

public class SignUp {

    private static final String SCROLLABLE_CONTAINER = "new UiScrollable(new UiSelector().resourceId(\"com.worldremit.android"
            + ".dev:id/field_container\")).scrollIntoView(";
    private static final String EDIT_TEXT = ".childSelector(new UiSelector().className(\"android.widget.EditText\")))";
    private static final String VALIDATION_MESSAGE = ".childSelector(new UiSelector()"
            + ".resourceId(\"com.worldremit.android.dev:id/textinput_error\")))";

    @AndroidFindBy(uiAutomator = SCROLLABLE_CONTAINER + "new UiSelector().description(\"SenderCountry\")" + EDIT_TEXT)
    private AndroidElement senderCountry;

    @AndroidFindBy(uiAutomator = SCROLLABLE_CONTAINER + "new UiSelector().description(\"SenderEmail\")" + EDIT_TEXT)
    private AndroidElement senderEmail;

    @AndroidFindBy(uiAutomator = SCROLLABLE_CONTAINER + "new UiSelector().description(\"SenderPassword\")" + EDIT_TEXT)
    private AndroidElement senderPassword;

    @AndroidFindBy(uiAutomator = SCROLLABLE_CONTAINER + "new UiSelector().description(\"SenderReferralCode\")" + EDIT_TEXT)
    private AndroidElement senderReferralCode;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"SenderRegion\")")
    private AndroidElement senderRegion;

    @AndroidFindBy(accessibility = "Navigate up")
    private AndroidElement goBack;

    @AndroidFindBy(uiAutomator =
            "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"com.worldremit"
                    + ".android.dev:id/sign_up_button\"));")
    private AndroidElement signUp;

    @AndroidFindBy(uiAutomator =
            "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"Privacy "
                    + "Policy\"));")
    private AndroidElement privacyPolicyFooter;

    @AndroidFindBy(id = "expanded_title")
    private AndroidElement headerElement;

    @AndroidFindBy(xpath = "//android.webkit.WebView")
    private List<AndroidElement> privacyPolicyWebView;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()"
            + ".resourceId(\"com.worldremit.android.dev:id/field_container\")).scrollIntoView"
            + "(new UiSelector().resourceId(\"com.worldremit.android.dev:id/check_box\"));")
    private AndroidElement termsAndConditionCheckbox;

    @AndroidFindBy(uiAutomator = SCROLLABLE_CONTAINER + "new UiSelector().description(\"SenderEmail\")" + VALIDATION_MESSAGE)
    private AndroidElement emailFieldValidation;

    @AndroidFindBy(uiAutomator = SCROLLABLE_CONTAINER + "new UiSelector().description(\"SenderPassword\")" + VALIDATION_MESSAGE)
    private AndroidElement passwordFieldValidation;

    public SignUp() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverProvider.getInstance()), this);
    }

    public void fillForm(Sender sender) {
        selectSenderCountry(CountryCode.getCountryByName(sender.getCountryFullName()));
        senderEmail.setValue(sender.getEmail());
        senderPassword.setValue(sender.getPassword());
    }

    public void selectSenderCountry(CountryCode countryCode) {
        var countrySelection = new CountrySelection();
        senderCountry.click();
        countrySelection.selectCountry(countryCode);
    }

    public void clickSignUpButton() {
        signUp.click();
    }
}

