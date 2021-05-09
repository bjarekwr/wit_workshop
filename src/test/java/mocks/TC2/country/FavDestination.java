package mocks.TC2.country;

import com.google.gson.annotations.SerializedName;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import lombok.Builder;
import lombok.val;

import static mocks.Codes.CountryCode.NG;


@Builder(toBuilder = true)
public class FavDestination {

    public String id;
    public String code;
    public String name;
    @SerializedName("short_name")
    public String shortName;
    @SerializedName("dial_code")
    public Integer dialCode;
    public String poster;

    public static FavDestination getNigeriaDestination() {
        val dialCode = PhoneNumberUtil.getInstance().getCountryCodeForRegion(NG.getAlpha2());
        return FavDestination.builder()
            .id(String.valueOf(dialCode))
            .code(NG.getAlpha2())
            .name(NG.getName())
            .shortName(NG.getAlpha3())
            .dialCode(dialCode)
            .poster("https://10.0.2.2/dummy_flag.png")
            .build();
    }
}
