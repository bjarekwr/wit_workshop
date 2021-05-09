package mocks.TC2;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import mocks.TC2.recipients.RecipientBank;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.sql.Timestamp.valueOf;

@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public class Recipient {

    @Builder.Default
    String id = "1";
    @Builder.Default
    String gender = "ms";
    @Builder.Default
    @JsonProperty("first_name")
    String firstName = "Ba-ar ak";
    @Builder.Default
    @JsonProperty("middle_name")
    String middleName = "Midd-l'e Name";
    @Builder.Default
    @JsonProperty("last_name")
    String lastName = "O'Bama";
    @Builder.Default
    @JsonProperty("phone_no")
    String phoneNumber = "1234567890";
    @Builder.Default
    @JsonProperty("mobile_no")
    String mobileNumber = "1234567890";
    @JsonProperty("mobile_account_no")
    String mobileAccountNo;
    @Builder.Default
    @JsonProperty("sending_reason_code")
    String sendingReasonCode = SendingReason.FAMILY_OR_FRIEND_SUPPORT.getCode();
    @Builder.Default
    String email = "testemail@wr.com";
    @Builder.Default
    @JsonProperty("dateOfBirthAsLocalDate")
    LocalDate dateOfBirth = LocalDate.of(1980, 10, 30);
    @Builder.Default
    @JsonProperty("dob")
    Long dob = valueOf(LocalDateTime.now().minusYears(30)).getTime();
    @Builder.Default
    @JsonProperty("identification_type")
    String identificationType = "Identity Card";
    @Builder.Default
    @Setter
    @JsonProperty("RecipientReference")
    String recipientReference = "Reference";
    @Builder.Default
    @JsonProperty("identification_id")
    String idNumber = "1234567890";
    @Builder.Default
    RecipientBank bank = RecipientBank.builder().build();
    @Builder.Default
    RecipientAddress address = RecipientAddress.builder().build();
}
