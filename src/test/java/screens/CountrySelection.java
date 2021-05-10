package screens;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mocks.Codes.CountryCode;
import org.openqa.selenium.support.PageFactory;
import utils.DriverProvider;

import java.time.Duration;
import java.util.List;

import static settings.EnvironmentConfig.ENVIRONMENT_CONFIG;

public class CountrySelection {

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").clickable(true)")
    private List<AndroidElement> countryList;

    @AndroidFindBy(id = "search_button")
    private AndroidElement searchButton;

    @AndroidFindBy(id = "search_src_text")
    private AndroidElement searchText;

    public CountrySelection() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverProvider.getInstance(), Duration.ofSeconds(ENVIRONMENT_CONFIG.getWaitingTimeoutInSeconds())), this);;
    }

    public void selectCountry(CountryCode countryCode) {
        searchWith(countryCode.getName());
    }


    public void searchForCountry(final String countryName) {
        searchButton.click();
        searchText.setValue(countryName);
    }

    private void searchWith(final String countryName) {
        searchForCountry(countryName);
        countryList.stream().findFirst().get().click();
    }
}
