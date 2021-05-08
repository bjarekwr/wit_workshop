package mocks.TC3.country;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.val;
import mocks.Codes.CountryCode;

import java.util.List;


import static java.util.Collections.singletonList;
import static lombok.AccessLevel.PRIVATE;

@Builder(toBuilder = true)
@FieldDefaults(level = PRIVATE)
public class Currencies {

    @Getter
    List<CurrencyInfo> receive;
    List<CurrencyInfo> send;
    List<PairInfo> pairs;

    public static Currencies getSendCurrency(CountryCode sendCountry) {
        return Currencies.builder()
            .send(singletonList(
                CurrencyInfo.getCountryCurrency(sendCountry)))
            .build();
    }


    public static Currencies getCurrencyPair(CountryCode senderCountry, CountryCode recipientCountry) {
        return Currencies.builder()
            .receive(singletonList(CurrencyInfo.getCountryCurrency(recipientCountry)))
            .send(singletonList(CurrencyInfo.getCountryCurrency(senderCountry)))
            .pairs(List.of(
                PairInfo.builder()
                    .send(senderCountry.getCurrency().toString())
                    .receive(recipientCountry.getCurrency().toString())
                    //todo: defaultSendAmount = 1.1 for iOS
                    .defaultSendAmount(1.0)
                    .build()))
            .build();
    }

    @Builder
    public static class CurrencyInfo {

        public String code;
        public String name;
        public String symbol;

        public static CurrencyInfo getCountryCurrency(CountryCode countryCode) {
            val countryCurrency = countryCode.getCurrency();
            return CurrencyInfo.builder()
                    .code(countryCurrency.toString())
                    .name(countryCurrency.getDisplayName())
                    .symbol(countryCurrency.getSymbol())
                    .build();
        }
    }

    @Builder
    public static class PairInfo {

        public String send;
        public String receive;
        @SerializedName("default_send_amount")
        @Default
        public Double defaultSendAmount = 1.0;
    }
}
