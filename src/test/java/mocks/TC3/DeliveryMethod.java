package mocks.TC3;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@AllArgsConstructor
public enum DeliveryMethod {

    ALIPAY("Alipay", "ALP", "alipayCorresponednt", 101),
    BANK_DEPOSIT_DEFAULT("Bank Deposit", "BNK", "WorldRemit BNK", 102),
    BANK_DEPOSIT_MIKKO("Bank Deposit", "BNK", "Mikko Bank", 112),
    CASH_PICKUP_CEBUANA("Cash Pickup", "CSH", "Cebuana", 103),
    CASH_PICKUP_MLHUILLER("Cash Pickup", "CSH", "MLhuillier", 113),
    MOBILE_MONEY_TRANSFER("Mobile Money Transfer", "MOB", "MMT", 104),
    DOOR_TO_DOOR_DELIVERY("Door to door delivery", "DTD", "DTD", 105),
    WORLDREMIT_WALLET("WorldRemit Wallet", "WAL", "Wallet", 106),
    AIRTIME("Airtime", "ATP", "AT", 107),
    BILL_PAYMENTS("Bill Payments", "BLP", "BPM", 981);

    @Getter
    private final String methodName;

    @Getter
    private final String methodCode;

    @Getter
    private final String correspondentName;

    @Getter
    private final Integer correspondentId;

    public static Stream<DeliveryMethod> stream() {
        return Stream.of(DeliveryMethod.values());
    }
}
