package mocks.TC2;

import lombok.Builder;

import java.util.List;

import static java.util.Collections.singletonList;

@Builder
public class Actions {

    private static final String MANUAL = "Manual";
    private static final String AUTO = "Auto";
    String changeBeneficiary;
    String cancel;
    String downloadReceipt;
    String changePayOutMethod;
    String displayBankDetails;
    String uploadID;
    String contactUs;
    String cashPickupInstructions;
    List<String> recommended;

    public static Actions getManualActions() {
        return Actions.builder()
            .changeBeneficiary(MANUAL)
            .cancel(MANUAL)
            .changePayOutMethod(MANUAL)
            .build();
    }

    public static Actions getDownloadReceipt() {
        return Actions.builder()
            .changeBeneficiary(MANUAL)
            .cancel(MANUAL)
            .downloadReceipt(AUTO)
            .changePayOutMethod(MANUAL)
            .recommended(singletonList("downloadReceipt"))
            .build();
    }

    public static Actions getUploadIdentification() {
        return Actions.builder()
            .changeBeneficiary(AUTO)
            .uploadID(AUTO)
            .cancel(MANUAL)
            .changePayOutMethod(MANUAL)
            .recommended(singletonList("uploadID"))
            .build();
    }

    public static Actions getDisplayBankDetails() {
        return Actions.builder()
            .displayBankDetails(AUTO)
            .changeBeneficiary(MANUAL)
            .cancel(MANUAL)
            .changePayOutMethod(MANUAL)
            .recommended(singletonList("displayBankDetails"))
            .build();
    }

    public static Actions getContactUs() {
        return Actions.builder()
            .changeBeneficiary(AUTO)
            .uploadID(AUTO)
            .cancel(MANUAL)
            .changePayOutMethod(MANUAL)
            .recommended(singletonList("contactUs"))
            .build();
    }

    public static Actions getAutoActions() {
        return Actions.builder()
            .changeBeneficiary(AUTO)
            .cancel(MANUAL)
            .changePayOutMethod(MANUAL)
            .build();
    }

    public static Actions getCashPickupInstructions() {
        return Actions.builder()
            .changeBeneficiary(MANUAL)
            .changePayOutMethod(MANUAL)
            .downloadReceipt(AUTO)
            .cancel(MANUAL)
            .cashPickupInstructions(AUTO)
            .recommended(List.of("cashPickupInstructions", "downloadReceipt"))
            .build();
    }
}
