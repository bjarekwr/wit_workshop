package mocks.TC3;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.experimental.FieldDefaults;
import lombok.val;

import static lombok.AccessLevel.PRIVATE;

@Builder
@FieldDefaults(level = PRIVATE)
public class TransactionData {

    @SerializedName("mobile_wallet_number")
    Object mobileWalletNumber;
    @SerializedName("recipient_name")
    String recipientName;
    @SerializedName("service_name")
    String serviceName;

    public static TransactionData getDefaultData(Recipient recipient, DeliveryMethod deliveryMethod) {
        val recipientName = recipient.getMiddleName().isEmpty() ? String.join(" ", recipient.getFirstName(), recipient.getLastName())
            : String.join(" ", recipient.getFirstName(), recipient.getMiddleName(), recipient.getLastName());
        return TransactionData.builder()
            .recipientName(recipientName)
            .serviceName(deliveryMethod.getMethodName())
            .build();
    }
}
