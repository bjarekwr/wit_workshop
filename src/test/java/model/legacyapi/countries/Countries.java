package model.legacyapi.countries;

import com.google.gson.annotations.SerializedName;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.worldremit.codes.CountryCode;
import lombok.Builder;
import lombok.val;

import java.util.Arrays;
import java.util.List;

import static com.worldremit.codes.CountryCode.*;

@Builder
public class Countries {

    public static final String DUMMY_FLAG_PNG = "https://10.0.2.2/dummy_flag.png";
    public String id;
    public String code;
    public String name;
    @SerializedName("short_name")
    public String shortName;
    @SerializedName("dial_code")
    public Integer dialCode;
    public String poster;

    public static List<Countries> getDefaultCountries() {
        return Arrays.asList(get(GB), get(PH), get(IN), get(JP));
    }

    public static Countries get(CountryCode countryCode) {
        val dialCode = PhoneNumberUtil.getInstance().getCountryCodeForRegion(countryCode.getAlpha2());
        return Countries.builder()
            .id(String.valueOf(dialCode))
            .code(countryCode.getAlpha2())
            .name(countryCode.getName())
            .shortName(countryCode.getAlpha3())
            .dialCode(dialCode)
            .poster(DUMMY_FLAG_PNG)
            .build();
    }
}
