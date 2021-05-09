package mocks.TC2.country;

import com.google.gson.annotations.SerializedName;
import com.google.i18n.phonenumbers.PhoneNumberUtil;

import lombok.Builder;
import lombok.val;
import mocks.Codes.CountryCode;

@Builder(toBuilder = true)
public class Destination {

    @SerializedName("is_airtime_supported")
    public Boolean isAirtimeSupported;
    @SerializedName("is_money_transfer_supported")
    public Boolean isMoneyTransferSupported;
    @SerializedName("id")
    public String id;
    @SerializedName("code")
    public String code;
    @SerializedName("name")
    public String name;
    @SerializedName("short_name")
    public String shortName;
    @SerializedName("dial_code")
    public Integer dialCode;
    @SerializedName("poster")
    public String poster;

    public static Destination getDefaultFor(CountryCode countryCode) {
        return buildCountry(countryCode).toBuilder()
            .isAirtimeSupported(true)
            .isMoneyTransferSupported(true)
            .build();
    }

    private static Destination buildCountry(CountryCode countryCode) {
        val dialCode = PhoneNumberUtil.getInstance().getCountryCodeForRegion(countryCode.getAlpha2());
        return Destination.builder()
            .id(String.valueOf(dialCode))
            .code(countryCode.getAlpha2())
            .name(countryCode.getName())
            .shortName(countryCode.getAlpha3())
            .dialCode(dialCode)
            .poster("https://10.0.2.2/dummy_flag.png")
            .build();
    }
}
