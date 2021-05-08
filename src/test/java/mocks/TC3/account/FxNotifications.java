package mocks.TC3.account;

import lombok.Builder;
import mocks.Codes.CountryCode;

import static mocks.Codes.CountryCode.PH;

@Builder
public class FxNotifications {

    CountryCode countryCode;
    String countryName;
    Boolean enabled;

    public static FxNotifications getFxForPh() {
        return FxNotifications.builder()
            .countryCode(PH)
            .countryName("Philippines")
            .enabled(true).build();
    }
}
