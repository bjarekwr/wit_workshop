package mocks.TC2.feature;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

import java.util.Collections;
import java.util.List;

@Builder
public class Rule {

    @SerializedName("TestValue")
    public TestValue testValue;
    @SerializedName("OperationType")
    public String operationType;
    @SerializedName("Result")
    public Boolean result;

    public static List<Rule> getDefault() {
        return Collections.singletonList(Rule.builder()
                                             .testValue(TestValue.getDefault())
                                             .operationType("GreaterThanOrEqualTo")
                                             .result(true)
                                             .build());
    }
}
