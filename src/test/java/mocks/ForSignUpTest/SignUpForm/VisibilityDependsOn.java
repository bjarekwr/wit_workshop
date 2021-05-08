package mocks.ForSignUpTest.SignUpForm;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

import java.util.List;

@Builder
public class VisibilityDependsOn {

    @SerializedName("fieldId")
    public String fieldId;
    @SerializedName("values")
    public List<String> values;
}
