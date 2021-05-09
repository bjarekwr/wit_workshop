package mocks.TC2.country;

import com.google.gson.annotations.SerializedName;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.experimental.FieldDefaults;
import mocks.TC2.DeliveryMethod;

import java.util.Collections;
import java.util.List;

import static mocks.TC2.country.Field.*;

@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeliveryService {

    String code;
    String name;
    @SerializedName("pre_requisites")
    PreRequisites preRequisites;
    @SerializedName("Type")
    Integer type;
    @SerializedName("Description")
    String description;
    @Default
    @SerializedName("DescriptionMarkups")
    List<Object> descriptionMarkups = Collections.emptyList();
    @SerializedName("CorrespondentSelectionPrompt")
    String correspondentSelectionPrompt;
    @SerializedName("CorrespondentSelectionTitle")
    String correspondentSelectionTitle;
    @SerializedName("CorrespondentSelectionLabel")
    String correspondentSelectionLabel;

    public static DeliveryService getBnkService() {
        return DeliveryService.builder()
            .code(DeliveryMethod.BANK_DEPOSIT_DEFAULT.getMethodCode())
            .name(DeliveryMethod.BANK_DEPOSIT_DEFAULT.getMethodName())
            .preRequisites(PreRequisites.builder()
                               .fields(List.of(
                                   getIdType(),
                                   getFirstName(),
                                   getLastName(),
                                   getCardNumber(),
                                   getEmail(),
                                   getMobile(),
                                   getPhone(),
                                   getAddressFlatNoField(),
                                   getAddressBuildingField(),
                                   getAddressSuburbField(),
                                   getAddressPostCode(),
                                   getAddressCityTownField(),
                                   getAddressStateField(),
                                   getBankField(),
                                   getBankCodeField(),
                                   getBsbCodeField(),
                                   getBranchNameField(),
                                   getBranchCodeField(),
                                   getBankIbanField(),
                                   getBankSwiftField(),
                                   getAccountNoField(),
                                   getAccountTypeField(),
                                   getIdNumberField(),
                                   getRelationshipToRecipient(),
                                   getPaymentReasonField(),
                                   getPaymentReferenceField(),
                                   getDateOfBirthField(),
                                   getGenderField(),
                                   getComplianceSendingReasonField()))
                               .build())
            .type(2)
            .description("Bank transfer")
            .correspondentSelectionLabel("Bank")
            .correspondentSelectionPrompt("Select a bank")
            .correspondentSelectionTitle("Which bank is your recipient with?")
            .build();
    }

    public static DeliveryService getCshPickupService() {
        return DeliveryService.builder()
            .code(DeliveryMethod.CASH_PICKUP_CEBUANA.getMethodCode())
            .name(DeliveryMethod.CASH_PICKUP_CEBUANA.getMethodName())
            .preRequisites(PreRequisites.builder()
                               .fields(List.of(
                                   getFirstName(),
                                   getLastName(),
                                   getEmail(),
                                   getMobile(),
                                   getAddressCityTownField(),
                                   getComplianceSendingReasonField()))
                               .build())
            .type(1)
            .description("Cash pickup service description")
            .correspondentSelectionLabel("Agent")
            .correspondentSelectionPrompt("Select an agent")
            .correspondentSelectionTitle("Which agent will your recipient pick up their cash from?")
            .build();
    }

    public static DeliveryService getAirtimeService() {
        return DeliveryService.builder()
            .code(DeliveryMethod.AIRTIME.getMethodCode())
            .name(DeliveryMethod.AIRTIME.getMethodName())
            .preRequisites(PreRequisites.builder()
                               .fields(List.of(
                                   getFirstName(),
                                   getLastName(),
                                   getEmail(),
                                   getMobile(),
                                   getAddressCityTownField(),
                                   getComplianceSendingReasonField()))
                               .build())
            .type(32)
            .description("Airtime service description")
            .correspondentSelectionLabel("Provider")
            .correspondentSelectionPrompt("Select provider")
            .correspondentSelectionTitle("Which is your recipient’s mobile operator?")
            .build();
    }

    public static DeliveryService getAlipayService() {
        return DeliveryService.builder()
            .code(DeliveryMethod.ALIPAY.getMethodCode())
            .name(DeliveryMethod.ALIPAY.getMethodName())
            .preRequisites(PreRequisites.builder()
                               .fields(List.of(
                                   getFirstName(),
                                   getLastName(),
                                   getMobile(),
                                   getAlipayIdField(),
                                   getAddressCityTownField(),
                                   getComplianceSendingReasonField()))
                               .build())
            .type(256)
            .description("Alipay service description")
            .correspondentSelectionLabel("Alipay")
            .correspondentSelectionPrompt("Alipay")
            .correspondentSelectionTitle("What is your recipient's Alipay ID?")
            .build();
    }

    public static DeliveryService getMobService() {
        return DeliveryService.builder()
            .code(DeliveryMethod.MOBILE_MONEY_TRANSFER.getMethodCode())
            .name(DeliveryMethod.MOBILE_MONEY_TRANSFER.getMethodName())
            .preRequisites(PreRequisites.builder()
                               .fields(List.of(
                                   getFirstName(),
                                   getLastName(),
                                   getMobile(),
                                   getMobileTransferField(),
                                   getAddressCityTownField(),
                                   getComplianceSendingReasonField()))
                               .build())
            .type(256)
            .description("Mobile money transfer service description")
            .correspondentSelectionLabel("Provider")
            .correspondentSelectionPrompt("Select provider")
            .correspondentSelectionTitle("Which is your recipient’s mobile operator?")
            .build();
    }
}

@Builder
class PreRequisites {

    private List<Field> fields;
}
