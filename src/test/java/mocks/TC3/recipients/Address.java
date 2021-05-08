package mocks.TC3.recipients;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.val;
import mocks.Codes.CountryCode;
import mocks.TC3.CountryInfo;
import mocks.TC3.Recipient;

import static mocks.TC3.CountryInfo.getCountryInfo;

@Builder
public class Address {

    @Default
    public CountryInfo country = CountryInfo.getPhInfo();
    @Default
    public String city = "Manila";
    @Default
    public String postcode = "123";
    @Default
    public String address1 = "1st street";
    @Default
    public String address2 = "simplicio cruz compd";
    @Default
    public String address3 = "sucat paranaque";

    public static Address getRecipientAddress(Recipient recipient) {
        val recipientAddress = recipient.getAddress();
        return Address.builder()
            .country(getCountryInfo(Enum.valueOf(CountryCode.class, recipientAddress.getCountry().getIsoCode())))
            .city(recipientAddress.getCity())
            .postcode(recipientAddress.getPostCode())
            .address1(recipientAddress.getAddress1())
            .address2(recipientAddress.getAddress2())
            .address3(recipientAddress.getAddress3())
            .build();
    }
}
