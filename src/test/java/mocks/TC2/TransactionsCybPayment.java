package mocks.TC2;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static java.lang.String.format;
import static lombok.AccessLevel.PRIVATE;
import static mocks.TC2.PaymentMethod.DEBIT_CREDIT_CARD_CYB;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class TransactionsCybPayment {

    @SerializedName("Id")
    String id;
    @Default
    @SerializedName("Uri")
    String uri = "https://10.0.2.2:1666/payment/cybersource.html";
    @Default
    @SerializedName("Payload")
    String payload = "";
    @Default
    @SerializedName("SuccessUri")
    String successUri = "https://10.0.2.2:1666/payment/success.html";
    @Default
    @SerializedName("FailureUri")
    String failureUri = "https://10.0.2.2:1666/payments/failure.html";
    @Default
    @SerializedName("PendingUri")
    String pendingUri = "https://10.0.2.2:1666/payment/pending.html";
    @SerializedName("StatusUri")
    String statusUri;
    @Default
    @SerializedName("Is3DSecure2")
    Boolean is3DSecure2 = false;

    public TransactionsCybPayment getCybPaymentResponse(String transactionId) {
        return TransactionsCybPayment.builder()
            .id(transactionId)
            .statusUri(format(
                "https://api.staging.worldremit.com/api/payment/status?provider=%s&paymentId=%s",
                DEBIT_CREDIT_CARD_CYB.getPaymentMethodIdentifier(),
                transactionId))
            .build();
    }
}
