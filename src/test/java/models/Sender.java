package models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static mocks.Codes.CountryCode.GB;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@ToString(onlyExplicitlyIncluded = true)
public class Sender {

    @SerializedName("SenderCountryFullName")
    @JsonIgnore
    @Builder.Default
    String countryFullName = GB.getName();

    @SerializedName("SenderGender")
    @JsonIgnore
    @Builder.Default
    String gender = "Male";

    @SerializedName("SenderMobile")
    @JsonIgnore
    @Builder.Default
    String mobile = "5222222444";

    @SerializedName("SenderPhone")
    @JsonIgnore
    @Builder.Default
    String phone = "222222444";

    @SerializedName("SenderAddress")
    @JsonIgnore
    @Builder.Default
    Address address = Address.getDefaultGbAddress();

    @SerializedName("SenderCountry")
    @Builder.Default
    String countryCode = GB.toString();

    @SerializedName("SenderRegion")
    String senderRegion;

    @SerializedName("SenderPostalCode")
    String senderPostalCode;

    @SerializedName("S'enderFirstName")
    @JsonIgnore
    @Builder.Default
    String firstName = "S'ender-first name";

    @SerializedName("SenderMiddleName")
    @JsonIgnore
    @Builder.Default
    String middleName = "S'ender-middle name";

    @SerializedName("SenderLastName")
    @JsonIgnore
    @Builder.Default
    String lastName = "S'ender-last name";

    @SerializedName("SenderEmail")
    @Builder.Default
    @ToString.Include
    String email = String.format("%s_test@wrtest.com", DateTimeFormatter.ofPattern("yyyyMMdd.HHmmssSSSSSS").format(LocalDateTime.now()));

    @SerializedName("SenderPassword")
    @Builder.Default
    @ToString.Include
    String password = "Pa$$w0rd12";

    @SerializedName("SenderReferralCode")
    @Builder.Default
    String referralCode = null;

    @SerializedName("SenderTermsAndConditionsCheckbox")
    @Builder.Default
    Boolean termsAndConditionsCheckbox = null;

    @JsonIgnore
    @Builder.Default
    String id = "1";

    @JsonIgnore
    String region;

}
