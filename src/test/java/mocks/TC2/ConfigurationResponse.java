package mocks.TC2;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import mocks.TC2.configuration.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static mocks.TC2.configuration.AppUpdateOffer.getDefaultAppUpdateOffer;

@Builder(toBuilder = true)
@Getter
public class ConfigurationResponse {

    private static FlagSettingsMock flagSettings = new FlagSettingsMock();
    @Default
    String onboardingVariant = "Default";
    List<Flag> flags;
    AppUpdateOffer forceUpdateRequired;
    AppUpdateOffer softUpdateRequired;
    @Default
    AbTesting abTesting = AbTesting.getDefault();
    @Default
    private List<InAppMessage> inAppMessages = InAppMessage.getDefault();
    @Default
    private BillPaymentsConfiguration billPaymentsConfiguration = BillPaymentsConfiguration.builder().build();
    @Default
    private List<String> preferredLanguagesSupported = List.of("da", "de", "en", "es", "fr", "nl");

    public static ConfigurationResponse getDefaultConfigurationResponseWithCountryParam() {
        return ConfigurationResponse.builder()
            .flags(flagSettings.getDefaultFlags())
            .build();
    }

    public static ConfigurationResponse getDesiredFlagConfiguration(Map<String, Boolean> desiredFlags) {
        return ConfigurationResponse.builder()
            .flags(flagSettings.getDesiredFlags(desiredFlags))
            .build();
    }

    public static ConfigurationResponse getInitialConfigurationResponse() {
        return ConfigurationResponse.builder()
            .flags(Collections.emptyList())
            .build();
    }

    public static ConfigurationResponse getForceUpdateConfigurationResponse() {
        return ConfigurationResponse.builder()
            .forceUpdateRequired(getDefaultAppUpdateOffer())
            .flags(flagSettings.getDefaultFlags())
            .build();
    }
}
