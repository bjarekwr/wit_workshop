package screens;

import com.google.common.collect.Iterables;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.val;
import mocks.Codes.CountryCode;
import org.openqa.selenium.support.PageFactory;
import utils.DriverProvider;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static settings.EnvironmentConfig.ENVIRONMENT_CONFIG;

public class CountrySelection {

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\")")
    public List<AndroidElement> recentList;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.worldremit.android.dev:id/selector_recycler_view\").childSelector(new "
                                 + "UiSelector().textMatches(\"All countries\"))")
    public AndroidElement allCountries;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").clickable(true)")
    private List<AndroidElement> countryList;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textMatches(\"Previously selected\")")
    private AndroidElement previouslySelected;

    @AndroidFindBy(id = "search_button")
    private AndroidElement searchButton;

    @AndroidFindBy(id = "search_src_text")
    private AndroidElement searchText;

    @AndroidFindBy(id = "loading_view")
    private AndroidElement loadingView;

    @AndroidFindBy(id = "progress_bar")
    private AndroidElement progressBar;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"Where would you like to send money?\")")
    private AndroidElement title;

    @AndroidFindBy(className = "android.widget.ImageButton")
    private AndroidElement backButton;

    public CountrySelection() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverProvider.getInstance(), Duration.ofSeconds(ENVIRONMENT_CONFIG.getWaitingTimeoutInSeconds())), this);;
    }


    public AndroidElement getTitle() {
        return title;
    }

    public AndroidElement getPreviouslySelected() {
        return previouslySelected;
    }

    public void clickBack() {
        backButton.click();
    }
    public void selectCountry(CountryCode countryCode) {
        searchWith(countryCode.getName());
    }

//    public void selectAgainAlreadyFoundCountry() {
//        recentList.last().shouldBe(enabled).click();
//    }

    public void selectCurrency(final String currencyCode) {
        searchWith(currencyCode);
    }

    public List<AndroidElement> getRecent() {
        val firstRecentCountyIndex = 3;
        var lastRecentCountryIndex = Iterables.indexOf(recentList, e -> e.getText().equals("All countries"));
        List<AndroidElement> recentCountries = new ArrayList<>();
        IntStream.range(firstRecentCountyIndex, lastRecentCountryIndex).forEach(i -> recentCountries.add(recentList.get(i)));
        return recentCountries;
    }

    public AndroidElement getFirstCountryFromResultList() {
        return countryList.stream().findFirst().get();
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
