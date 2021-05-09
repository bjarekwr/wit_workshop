package mocks.TC2.feature;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

import java.util.Collections;
import java.util.List;

@Builder
public class Data {

    @SerializedName("Alias")
    public String alias;
    @SerializedName("Path")
    public String path;
    @SerializedName("Result")
    public String result;

    public static List<Data> getDefault() {
        return Collections.singletonList(Data.builder().alias("countryId").path("id").result("49").build());
    }
}
