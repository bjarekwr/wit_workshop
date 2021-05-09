package mocks.TC2.country;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import mocks.TC2.SendingReason;

import java.util.Map;

@Builder(toBuilder = true)
public class Field {

    public String id;
    public String name;
    public String type;
    public String input;
    public Boolean required;
    public Boolean visible;
    public Boolean readonly;
    @SerializedName("max_length")
    public Integer maxLength;
    @SerializedName("min_length")
    public Integer minLength;
    public Map<String, String> options;
    @SerializedName("error_message")
    public String errorMessage;

    public static Field getIdType() {
        return Field.builder()
            .id("ID Type")
            .type("string")
            .required(false)
            .visible(true)
            .readonly(false)
            .build();
    }

    public static Field getFirstName() {
        return Field.builder()
            .id("FLD_0_FIRST_NAME")
            .name("First name")
            .type("string")
            .required(true)
            .visible(true)
            .readonly(false)
            .build();
    }

    public static Field getLastName() {
        return Field.builder()
            .id("FLD_02_LAST_NAME")
            .name("Last name")
            .type("string")
            .required(true)
            .visible(true)
            .readonly(false)
            .build();
    }

    public static Field getCardNumber() {
        return Field.builder()
            .id("FLD_0CARD_NUMBER")
            .name("Card Number")
            .type("string")
            .required(false)
            .visible(true)
            .readonly(false)
            .build();
    }

    public static Field getEmail() {
        return Field.builder()
            .id("FLD_0Email")
            .name("Email")
            .type("string")
            .required(false)
            .visible(true)
            .readonly(false)
            .build();
    }

    public static Field getMobile() {
        return Field.builder()
            .id("FLD_0Mobile")
            .name("Mobile Number")
            .type("string")
            .minLength(10)
            .maxLength(11)
            .required(false)
            .visible(true)
            .readonly(false)
            .build();
    }

    public static Field getPhone() {
        return Field.builder()
            .id("FLD_0Phone")
            .name("Phone")
            .type("string")
            .required(false)
            .visible(true)
            .readonly(false)
            .build();
    }

    public static Field getAddressFlatNoField() {
        return Field.builder()
            .id("FLD_ADD_1Line1")
            .name("Flat/Unit No.")
            .type("string")
            .input("string")
            .required(false)
            .visible(true)
            .readonly(false)
            .build();
    }

    public static Field getAddressBuildingField() {
        return Field.builder()
            .id("FLD_ADD_2Line2")
            .name("Building No./Name")
            .type("string")
            .input("string")
            .required(false)
            .visible(true)
            .readonly(false)
            .build();
    }

    public static Field getAddressSuburbField() {
        return Field.builder()
            .id("FLD_ADD_3Line3")
            .name("Suburb")
            .type("string")
            .required(false)
            .visible(true)
            .readonly(false)
            .build();
    }

    public static Field getAddressPostCode() {
        return Field.builder()
            .id("FLD_ADD_4Postcode")
            .name("Postcode")
            .type("string")
            .maxLength(4)
            .required(false)
            .visible(true)
            .readonly(false)
            .build();
    }

    public static Field getAddressCityTownField() {
        return Field.builder()
            .id("FLD_ADD_5City")
            .name("City/Town")
            .type("string")
            .input("string")
            .required(true)
            .visible(true)
            .readonly(false)
            .build();
    }

    public static Field getAddressStateField() {
        return Field.builder()
            .id("FLD_ADD_6State")
            .name("State")
            .type("string")
            .input("select")
            .required(false)
            .visible(true)
            .readonly(false)
            .options(Map.of(
                "ONE", "FirstOption",
                "TWO", "SecondOption",
                "THREE", "ThirdOption"
            ))
            .build();
    }

    public static Field getBankField() {
        return Field.builder()
            .id("FLD_Bank_1Name")
            .name("Bank")
            .type("string")
            .input("selection")
            .required(true)
            .visible(true)
            .readonly(false)
            .build();
    }

    public static Field getBankCodeField() {
        return Field.builder()
            .id("FLD_Bank_2Code")
            .name("Bank code")
            .type("string")
            .input("string")
            .required(true)
            .visible(true)
            .readonly(true)
            .build();
    }

    public static Field getBranchNameField() {
        return Field.builder()
            .id("FLD_Bank_3Branch")
            .name("Branch Name")
            .type("string")
            .input("selection")
            .required(true)
            .visible(true)
            .readonly(false)
            .build();
    }

    public static Field getBranchCodeField() {
        return Field.builder()
            .id("FLD_Bank_2Code")
            .name("Branch code")
            .type("string")
            .required(true)
            .visible(true)
            .readonly(false)
            .build();
    }

    public static Field getBsbCodeField() {
        return Field.builder()
            .id("FLD_Bank_2Code")
            .name("BSB Code")
            .type("string")
            .required(true)
            .visible(true)
            .readonly(false)
            .build();
    }

    public static Field getBankIbanField() {
        return Field.builder()
            .id("FLD_Bank_4IBAN")
            .name("IBAN")
            .type("string")
            .required(false)
            .visible(true)
            .readonly(false)
            .build();
    }

    public static Field getBankSwiftField() {
        return Field.builder()
            .id("FLD_Bank_4SWIFT")
            .name("BIC")
            .type("string")
            .required(false)
            .visible(true)
            .readonly(false)
            .build();
    }

    public static Field getAccountNoField() {
        return Field.builder()
            .id("FLD_Bank_5Account")
            .name("Account number")
            .type("string")
            .input("string")
            .minLength(10)
            .maxLength(16)
            .required(true)
            .visible(true)
            .readonly(false)
            .build();
    }

    public static Field getAccountTypeField() {
        return Field.builder()
            .id("FLD_Bank_6Account_Type")
            .name("Account type")
            .type("string")
            .input("string")
            .required(false)
            .visible(true)
            .readonly(false)
            .options(Map.of(
                "39", "SAVINGS ACCOUNT",
                "40", "CHECKING ACCOUNT"
            ))
            .build();
    }

    public static Field getIdNumberField() {
        return Field.builder()
            .id("FLD_PAYMENT_NIC_NO")
            .name("ID Number")
            .type("string")
            .required(false)
            .visible(true)
            .readonly(false)
            .build();
    }

    public static Field getRelationshipToRecipient() {
        return Field.builder()
            .id("FLD_PAYMENT_REFERENCE")
            .name("Your relationship to recipient")
            .minLength(3)
            .maxLength(20)
            .type("string")
            .required(true)
            .visible(true)
            .readonly(false)
            .build();
    }

    public static Field getPaymentReasonField() {
        return Field.builder()
            .id("FLD_PAYMENT_REASON")
            .name("Sending Reason")
            .type("string")
            .required(false)
            .visible(true)
            .readonly(false)
            .build();
    }

    public static Field getPaymentReferenceField() {
        return Field.builder()
            .id("FLD_PAYMENT_REFERENCE")
            .name("Reference")
            .type("string")
            .required(false)
            .visible(true)
            .readonly(false)
            .build();
    }

    public static Field getDateOfBirthField() {
        return Field.builder()
            .id("txtDateOfBirth")
            .name("Date Of Birth")
            .type("string")
            .required(false)
            .visible(true)
            .readonly(false)
            .build();
    }

    public static Field getGenderField() {
        return Field.builder()
            .id("txtGender")
            .name("Gender")
            .type("string")
            .required(false)
            .visible(true)
            .readonly(false)
            .build();
    }

    public static Field getComplianceSendingReasonField() {
        return Field.builder()
            .id("FLD_Compliance_0Sending_Reason")
            .name("Reason for Sending")
            .type("string")
            .input("select")
            .required(true)
            .visible(true)
            .readonly(false)
            .options(
                Map.of(
                    SendingReason.FAMILY_OR_FRIEND_SUPPORT.getCode(), SendingReason.FAMILY_OR_FRIEND_SUPPORT.getValue(),
                    SendingReason.PURCHASE_OF_SERVICES.getCode(), SendingReason.PURCHASE_OF_SERVICES.getValue(),
                    SendingReason.PROPERTY_PAYMENT.getCode(), SendingReason.PROPERTY_PAYMENT.getValue(),
                    SendingReason.SENDING_FUND_TO_SELF.getCode(), SendingReason.SENDING_FUND_TO_SELF.getValue(),
                    SendingReason.GIFT.getCode(), SendingReason.GIFT.getValue()
                )
            )
            .errorMessage("Please select a sending reason")
            .build();
    }

    public static Field getAlipayIdField() {
        return getMobileAccountNoField().toBuilder()
            .name("Alipay ID")
            .build();
    }

    public static Field getMobileTransferField() {
        return getMobileAccountNoField().toBuilder()
            .name("Mobile Account Number")
            .build();
    }

    public static Field getMobileAccountNoField() {
        return Field.builder()
            .id("FLD_Mobile_Account_No")
            .type("phone")
            .input("phone")
            .required(true)
            .visible(true)
            .readonly(false)
            .build();
    }
}
