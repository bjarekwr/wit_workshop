package mocks.TC3;

import com.google.gson.annotations.SerializedName;
import com.google.i18n.phonenumbers.PhoneNumberUtil;

import lombok.Builder;
import mocks.Codes.CountryCode;

import static mocks.Codes.CountryCode.PH;


@Builder
public class CountryInfo {

    public static final String DUMMY_FLAG_PNG = "https://10.0.2.2/dummy_flag.png";

    @SerializedName("is_airtime_supported")
    public Boolean isAirtimeSupported;
    @SerializedName("is_money_transfer_supported")
    public Boolean isMoneyTransferSupported;
    public String id;
    public String code;
    public String name;
    @SerializedName("short_name")
    public String shortName;
    @SerializedName("dial_code")
    public Integer dialCode;
    public String poster;

    public static CountryInfo getPhInfo() {
        return getCountryInfo(PH);
    }

    public static CountryInfo getCountryInfo(CountryCode countryCode) {
        Integer dialCode = PhoneNumberUtil.getInstance().getCountryCodeForRegion(countryCode.getAlpha2());
        return CountryInfo.builder()
            .id(dialCode.toString())
            .code(countryCode.getAlpha2())
            .name(countryCode.getName())
            .shortName(countryCode.getAlpha3())
            .dialCode(dialCode)
            .poster(DUMMY_FLAG_PNG)
            .build();
    }
}
