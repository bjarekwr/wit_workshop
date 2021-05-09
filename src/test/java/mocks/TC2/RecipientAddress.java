package mocks.TC2;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import mocks.TC2.recipients.RecipientCountry;

import static mocks.TC2.recipients.RecipientCountry.getCountryForRecipientFromIndia;

@Builder
@Getter
public class RecipientAddress {

    @Builder.Default
    RecipientCountry country = RecipientCountry.builder().build();
    @Builder.Default
    String address1 = "1st street";
    @Builder.Default
    String address2 = "simplicio cruz compd";
    @Builder.Default
    String address3 = "sucat paranaque";
    @Builder.Default
    String city = "Manila";
    String state;
    @Builder.Default
    String postCode = "123";
    @Builder.Default
    @SerializedName("house_no")
    String houseNo = "23";
    @Builder.Default
    String town = "";
    @Builder.Default
    String region = "LUZ";

    public static RecipientAddress getIndiaRecipientAddress() {
        return RecipientAddress.builder()
            .country(getCountryForRecipientFromIndia())
            .city("Bogota")
            .build();
    }
}
