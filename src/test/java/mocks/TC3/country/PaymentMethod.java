package mocks.TC3.country;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import mocks.TC3.Fee;


import java.util.Arrays;
import java.util.List;

import static mocks.Codes.CountryCode.GB;
import static mocks.TC3.PaymentMethod.*;


@Builder(toBuilder = true)
public class PaymentMethod {

    public String code;
    public Integer id;
    public String name;
    public String description;
    public Double maximum;
    public Double minimum;
    public Integer type;
    @SerializedName("card_types")
    public List<String> cardTypes;
    public Icon icon;
    @SerializedName("currency_code")
    public String currencyCode;
    public String poster;
    private Fee fee;

    public static PaymentMethod getPphMethod() {
        return PaymentMethod.builder()
            .code(DEBIT_CREDIT_CARD_PPH.getPaymentMethodIdentifier())
            .id(12)
            .name(DEBIT_CREDIT_CARD_PPH.getPaymentMethodName())
            .description("When you use a credit card your bank may charge cash advance fees. Use a debit card to avoid this charge")
            .maximum(10000.0)
            .minimum(1.0)
            .type(0)
            .cardTypes(Arrays.asList("Visa", "Visa Debit", "Visa Electron", "Master Card", "Solo", "Maestro"))
            .icon(Icon.getCardIcon())
            .currencyCode(GB.getCurrency().toString())
            .build();
    }

    public static PaymentMethod getBnkMethod() {
        return PaymentMethod.builder()
            .code(BANK_TRANSFER.getPaymentMethodIdentifier())
            .id(2)
            .name(BANK_TRANSFER.getPaymentMethodName())
            .description("Pay directly from your bank account. Your transaction will complete as soon as your payment reflects on our account.")
            .maximum(10000.0)
            .minimum(1.0)
            .type(1)
            .icon(Icon.getCardIcon())
            .currencyCode(GB.getCurrency().toString())
            .build();
    }

    public static PaymentMethod getCybMethod() {
        return PaymentMethod.builder()
            .code(DEBIT_CREDIT_CARD_CYB.getPaymentMethodIdentifier())
            .id(20)
            .name(DEBIT_CREDIT_CARD_CYB.getPaymentMethodName())
            .description("When you use a credit card your bank may charge cash advance fees. Use a debit card to avoid this charge")
            .maximum(10000.0)
            .minimum(1.0)
            .type(0)
            .cardTypes(Arrays.asList("Visa", "Visa Debit", "Visa Electron", "Master Card", "Solo", "Maestro"))
            .icon(Icon.getCardIcon())
            .currencyCode(GB.getCurrency().toString())
            .build();
    }
}
