package mocks.TC2.feature;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

import java.util.List;

@Builder
public class ReferralResponse {

    @SerializedName("Name")
    public String name;
    @SerializedName("Details")
    public Details details;
    @SerializedName("Errors")
    public Boolean errors;
    @SerializedName("Result")
    public Boolean result;
    @SerializedName("DataSources")
    public List<DataSource> dataSources;
    @SerializedName("Rules")
    public List<Rule> rules;
    @SerializedName("CacheExpiryTime")
    public Integer cacheExpiryTime;

    public static ReferralResponse getDefault() {
        return ReferralResponse.builder()
            .name("referral")
            .details(Details.getDefault())
            .result(false)
            .errors(false)
            .build();
    }
}
