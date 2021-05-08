package mocks.TC3;

import com.google.gson.annotations.SerializedName;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import lombok.val;
import mocks.Codes.CountryCode;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static lombok.AccessLevel.PRIVATE;
import static mocks.Codes.CountryCode.*;
import static mocks.TC3.Price.getDefault;

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


    public static Transaction getGbToInTransaction(Recipient recipient, DeliveryMethod deliveryMethod) {
        val senderCountry = GB;
        val recipientCountry = IN;
        return Transaction.builder()
            .id("10551351")
            .sendCountry(senderCountry.getAlpha2())
            .recipientId(recipient.getId())
            .receiveCountry(recipientCountry.getAlpha2())
            .currency(recipientCountry.getCurrency().toString())
            .correspondentId(deliveryMethod.getCorrespondentId().toString())
            .productCode(deliveryMethod.getMethodCode())
            .paymentMethod("7")
            .status(3)
            .cancellable(true)
            .timeStamp((int) Instant.now().getEpochSecond())
            .price(getDefault(senderCountry, recipientCountry))
            .airtimeTopId("0")
            .mobile("1234567890")
            .transactionData(TransactionData.getDefaultData(recipient, deliveryMethod))
            .total(76.86)
            .build();
    }

    public static Transaction getBankTransaction(Recipient recipient, DeliveryMethod deliveryMethod) {
        val senderCountry = GB;
        val recipientCountry = CountryCode.valueOf(recipient.getAddress().getCountry().getIsoCode());
        return Transaction.builder()
            .id("10551351")
            .sendCountry(senderCountry.getAlpha2())
            .recipientId(recipient.getId())
            .receiveCountry(recipientCountry.getAlpha2())
            .currency(recipientCountry.getCurrency().toString())
            .correspondentId(deliveryMethod.getCorrespondentId().toString())
            .productCode(deliveryMethod.getMethodCode())
            .paymentMethod("7")
            .status(2)
            .cancellable(false)
            .notCancellableMessage("We just checked and unfortunately you cannot amend or cancel your transaction right now. "
                                   + "This is because your transaction is being processed or is now processed. "
                                   + "Please contact us via the Help and Support button if you need further assistance.")
            .timeStamp((int) Instant.now().getEpochSecond())
            .price(getDefault(senderCountry, recipientCountry))
            .airtimeTopId("0")
            .mobile("1234567890")
            .total(76.86)
            .build();
    }
}

