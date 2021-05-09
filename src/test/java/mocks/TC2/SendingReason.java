package mocks.TC2;

import lombok.Getter;

@Getter
public enum SendingReason {

    FAMILY_OR_FRIEND_SUPPORT("FFS", "Family or friend support"),
    PURCHASE_OF_SERVICES("PGS", "Purchase of services"),
    PROPERTY_PAYMENT("PP", "Property payment"),
    SENDING_FUND_TO_SELF("SFS", "Sending funds to self"),
    GIFT("GFT", "Gift");

    private String code;
    private String value;

    SendingReason(String code, String value) {
        this.code = code;
        this.value = value;
    }
}
