package mocks.TC2.feature;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

@Builder
public class Details {

    @SerializedName("IsSendingFromSupportedCountry")
    public boolean isSendingFromSupportedCountry;
    @SerializedName("HasPaidAtLeastOneMoneyTransferTransaction")
    public boolean hasPaidAtLeastOneMoneyTransferTransaction;
    @SerializedName("IsEnabledInReferAFriend")
    public boolean isEnabledInReferAFriend;

    public static Details getDefault() {
        return Details.builder()
            .isEnabledInReferAFriend(true)
            .isSendingFromSupportedCountry(true)
            .hasPaidAtLeastOneMoneyTransferTransaction(false)
            .build();
    }
}