package mocks.TC3.recipients;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Bank {

    public BankData bank;
    @SerializedName("bank_account_no")
    public String bankAccountNo;
    @SerializedName("bank_account_iban")
    public String bankAccountIban;
    @SerializedName("bank_account_bic")
    public String bankAccountBic;
    @SerializedName("account_type")
    public String accountType;

    public static Bank getPhilippineNationalBank() {
        return Bank.builder()
            .bank(BankData.builder().name("Philippine National Bank").branchName("Cubao Main").branchState("").build())
            .bankAccountNo("1234567890")
            .bankAccountIban("123456789123456789")
            .bankAccountBic("123456789")
            .accountType("0")
            .build();
    }

    public static Bank getTestBank() {
        return Bank.builder()
            .bank(BankData.builder()
                      .name("Bank 1")
                      .code("COR01")
                      .branchName("Branch1a")
                      .branchCode("CORBR1")
                      .branchState("")
                      .build())
            .bankAccountNo("1234567890")
            .bankAccountIban("123456789123456789")
            .bankAccountBic("123456789")
            .accountType("0")
            .build();
    }

    @Builder
    public static class BankData {

        public String code;
        public String name;
        @SerializedName("branch_name")
        public String branchName;
        @SerializedName("branch_code")
        public String branchCode;
        @SerializedName("branch_state")
        public String branchState;
    }
}
