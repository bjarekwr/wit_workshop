package mocks.ForSignUpTest;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

import java.util.Map;

@Builder
public class OptionsUrl {

    @SerializedName("Url")
    private String url;
    @SerializedName("Parameters")
    private Map<String, String> parameters;
}
