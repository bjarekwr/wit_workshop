package mocks.TC2.country;

import com.google.gson.annotations.SerializedName;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import lombok.Builder;
import lombok.val;

import static mocks.Codes.CountryCode.PH;

@Builder(toBuilder = true)
public class PopularDestination {

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

    public static PopularDestination getPhpDestination() {
        val dialCode = PhoneNumberUtil.getInstance().getCountryCodeForRegion(PH.getAlpha2());
        return PopularDestination.builder()
            .isAirtimeSupported(true)
            .isMoneyTransferSupported(true)
            .id(String.valueOf(dialCode))
            .code(PH.getAlpha2())
            .name(PH.getName())
            .shortName(PH.getAlpha3())
            .dialCode(dialCode)
            .poster("https://10.0.2.2/dummy_flag.png")
            .build();
    }
}
