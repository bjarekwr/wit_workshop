package mocks.TC2.recipients;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.google.gson.annotations.SerializedName;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import lombok.Builder;
import lombok.Getter;

import static mocks.Codes.CountryCode.IN;

@Builder
@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class RecipientCountry {

    @Builder.Default
    Integer id = null;
    @Builder.Default
    @SerializedName("code")
    String isoCode = "PH";
    @Builder.Default
    String name = "Philippines";
    @Builder.Default
    @SerializedName("short_name")
    String shortName = null;
    @Builder.Default
    @SerializedName("en_name")
    String enName = null;
    @Builder.Default
    String poster = null;
    @Builder.Default
    @SerializedName("dial_code")
    String dialCode = "44";
    String state;

    public static RecipientCountry getCountryForRecipientFromIndia() {
        return RecipientCountry.builder()
            .isoCode(IN.getAlpha2())
            .name(IN.getName())
            .dialCode(String.valueOf(PhoneNumberUtil.getInstance().getCountryCodeForRegion(IN.getAlpha2())))
            .build();
    }
}
