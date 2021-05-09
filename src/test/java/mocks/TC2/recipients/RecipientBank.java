package mocks.TC2.recipients;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import mocks.TC2.Bank;

@Builder
@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class RecipientBank {

    @JsonProperty("bank")
    @Builder.Default
    mocks.TC2.Bank bank = Bank.builder().build();
    @JsonProperty("bank_account_no")
    @Builder.Default
    String bankAccountNumber = "1234567890";
    @JsonProperty("bank_account_iban")
    @Builder.Default
    String bankAccountIban = "123456789123456789";
    @JsonProperty("bank_account_bic")
    @Builder.Default
    String bankAccountBic = "123456789";
    @Builder.Default
    String accountType = null;
}
