package mocks.TC3;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Bank {

    @Builder.Default
    String code = "COR01";
    @Builder.Default
    String name = "COR01";
    @Builder.Default
    @JsonProperty("branch_code")
    String branchCode = "CORBR1";
    @Builder.Default
    @JsonProperty("branch_name")
    String branchName = "CORBR1";
    @Builder.Default
    String account = "1231231231";
}
