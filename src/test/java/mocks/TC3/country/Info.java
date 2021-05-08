package mocks.TC3.country;

import com.google.gson.annotations.SerializedName;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import lombok.Builder;
import lombok.val;
import mocks.Codes.CountryCode;

@Builder
// Quite similar to PopularDestination, FavDestiantion, Destination probably worth to
// leave only destination
public class Info {

    public String id;
    public String code;
    public String name;
    @SerializedName("short_name")
    public String shortName;
    @SerializedName("dial_code")
    public Integer dialCode;
    public String poster;

    public static Info getInfoFor(CountryCode countryCode) {
        val dialCode = PhoneNumberUtil.getInstance().getCountryCodeForRegion(countryCode.getAlpha2());
        return Info.builder()
            .id(String.valueOf(dialCode))
            .code(countryCode.getAlpha2())
            .name(countryCode.getName())
            .shortName(countryCode.getAlpha3())
            .dialCode(dialCode)
            .poster("https://10.0.2.2/dummy_flag.png")
            .build();
    }
}
