package mocks.TC2.feature;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

@Builder
public class TestValue {

    @SerializedName("Name")
    public String name;
    @SerializedName("Value")
    public Integer value;

    public static TestValue getDefault() {
        return TestValue.builder().name("coutryId").value(49).build();
    }
}
