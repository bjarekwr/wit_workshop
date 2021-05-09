package mocks.TC2;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.val;
import mocks.Codes.CountryCode;

import static java.lang.Double.parseDouble;

@Getter
@Builder(toBuilder = true)
public class Price {

    @SerializedName("Send")
    public Double send;
    @SerializedName("Receive")
    public Double receive;
    @SerializedName("Fees")
    public Double fees;
    @SerializedName("ExchangeRate")
    public Double exchangeRate;
    @SerializedName("ReceiveCurrency")
    public String receiveCurrency;
    @SerializedName("SendCurrency")
    public String sendCurrency;
    @SerializedName("TR")
    public Double tr;
    @SerializedName("TFR")
    public Double tfr;

    public static Price getDefault(CountryCode sendCountry, CountryCode receiveCountry) {
        return Price.builder()
                .send(72.87)
                .receive(4324.0)
                .fees(1.99)
                .exchangeRate(58.80)
                .receiveCurrency(receiveCountry.getCurrency().toString())
                .sendCurrency(sendCountry.getCurrency().toString())
                .tr(5.94)
                .tfr(0.993701)
                .build();
    }

    public static Price getExactPrice(CountryCode sendCountry, CountryCode receiveCountry, String sendAmount) {
        val amount = parseDouble(sendAmount);
        return getDefault(sendCountry, receiveCountry).toBuilder()
                .send(amount)
                .receive(amount * 58.8)
                .build();
    }
}
