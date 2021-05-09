package mocks.TC2;

import com.google.gson.annotations.SerializedName;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import mocks.Codes.CountryCode;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static lombok.AccessLevel.PRIVATE;
import static mocks.Codes.CountryCode.*;
import static mocks.TC2.Price.getDefault;

@SuperBuilder(toBuilder = true)
@Getter
@FieldDefaults(level = PRIVATE)
public class Transaction {

    @Default
    String id = DateTimeFormatter.ofPattern("ddHHmmssSSSSSS").format(LocalDateTime.now());
    @SerializedName("send_country")
    String sendCountry;
    @SerializedName("recipient_id")
    String recipientId;
    String senderId;
    @SerializedName("receive_country")
    String receiveCountry;
    String currency;
    @SerializedName("correspondent_id")
    String correspondentId; // should be the same as in InitialCalculation
    @SerializedName("product_code")
    String productCode;
    @SerializedName("payment_method")
    String paymentMethod;
    @SerializedName("Status")
    Integer status;
    Boolean cancellable;
    @SerializedName("time_stamp")
    Integer timeStamp;
    Price price;
    @SerializedName("AirtimeTopId")
    String airtimeTopId;
    @SerializedName("Mobile")
    String mobile;
    @SerializedName("Data")
    TransactionData transactionData;
    Double total;
    String notCancellableMessage;

    public static Transaction getTransactionToPhFromSendCountry(CountryCode sendCountryCode, Recipient recipient, DeliveryMethod deliveryMethod) {
        return Transaction.builder()
            .id("10551350")
            .sendCountry(sendCountryCode.getAlpha2())
            .recipientId(recipient.getId())
            .receiveCountry(PH.getAlpha2())
            .currency(PH.getCurrency().toString())
            .correspondentId(deliveryMethod.getCorrespondentId().toString())
            .productCode(deliveryMethod.getMethodCode())
            .paymentMethod("7")
            .status(3)
            .cancellable(true)
            .timeStamp((int) Instant.now().getEpochSecond())
            .price(getDefault(sendCountryCode, PH))
            .airtimeTopId("0")
            .mobile("1234567890")
            .transactionData(TransactionData.getDefaultData(recipient, deliveryMethod))
            .total(76.86)
            .build();
    }


    public static Transaction getGbToPhTransaction(Recipient recipient, DeliveryMethod deliveryMethod) {
        return getTransactionToPhFromSendCountry(GB, recipient, deliveryMethod);
    }
}

