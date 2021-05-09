package mocks.TC2.recipients;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import mocks.TC2.Recipient;

import java.time.ZoneOffset;


import static lombok.AccessLevel.PRIVATE;
import static mocks.TC2.recipients.Address.getRecipientAddress;

@Getter
@Builder(toBuilder = true)
@FieldDefaults(level = PRIVATE)
public class RecipientResponse {

    Bank bank;
    @Default
    Integer services = 0;
    @SerializedName("sending_reason_code")
    @Default
    String sendingReasonCode = null;
    @Default
    String id =  null;
    @Default
    Boolean isLocked = false;
    @Default
    Boolean active = false;
    @Default
    String gender =  null;
    @SerializedName("first_name")
    @Default
    String firstName =  null;
    @SerializedName("middle_name")
    @Default
    String middleName =  null;
    @SerializedName("last_name")
    @Default
    String lastName =  null;
    @Default
    String email =  null;
    @SerializedName("mobile_no")
    @Default
    String mobileNo =  null;
    @SerializedName("phone_no")
    @Default
    String phoneNo =  null;
    Address address;
    Long dob;
    @SerializedName("password_expired")
    @Default
    Boolean passwordExpired = false;
    @SerializedName("is_id_approved")
    @Default
    Boolean isIdApproved = false;
    @Default
    Boolean isSender = false;
    @SerializedName("mobile_account_no")
    @Default
    String mobileAccountNo =  null;
    @SerializedName("identification_type")
    @Default
    String identificationType =  null;
    @SerializedName("identification_id")
    @Default
    String identificationId =  null;
    @Default
    @SerializedName("RecipientReference")
    String recipientReference = "reference";

    public static RecipientResponse getGenericRecipient(Recipient recipient) {
        return builder()
            .services(3)
            .sendingReasonCode(recipient.getSendingReasonCode())
            .id(recipient.getId())
            .isLocked(false)
            .active(true)
            .gender(recipient.getGender())
            .firstName(recipient.getFirstName())
            .middleName(recipient.getMiddleName())
            .lastName(recipient.getLastName())
            .email(recipient.getEmail())
            .mobileNo(recipient.getMobileNumber())
            .phoneNo(recipient.getPhoneNumber())
            .mobileAccountNo(recipient.getMobileAccountNo())
            .address(getRecipientAddress(recipient))
            .dob(recipient.getDateOfBirth().atStartOfDay(ZoneOffset.UTC).toEpochSecond())
            .passwordExpired(false)
            .isIdApproved(false)
            .isSender(true)
            .bank(Bank.getTestBank())
            .identificationType(recipient.getIdentificationType())
            .identificationId(recipient.getId())
            .build();
    }
}
