package mocks.TC2;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum PaymentMethod {

    BANK_TRANSFER("Bank Transfer", "ACT"),
    DEBIT_CREDIT_CARD("Debit / Credit Card", "Debit / Credit Card"),
    DEBIT_CREDIT_CARD_PPH("Debit / Credit Card", "PPH"),
    DEBIT_CREDIT_CARD_CYB("Debit / Credit Card", "CYB"),
    ONLINE_BANK_TRANSFER("Online Bank Transfer", "SFT"),
    FREE("Free", "FREE"),
    OPEN_BANKING("Automatic Bank Transfer", "OPB");

    @Getter
    private String paymentMethodName;
    @Getter
    private String paymentMethodIdentifier;
}
