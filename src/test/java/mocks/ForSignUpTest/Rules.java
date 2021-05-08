package mocks.ForSignUpTest;

import lombok.Builder;

import java.util.List;

@Builder(toBuilder = true)
public class Rules {

    public Boolean required;
    public String regex;
    public String regexFailureMessage;
    public String minDate;
    public String maxDate;
    public Integer maxLength;
    public Integer minLength;
    public List<String> validDialCodes;

    public static Rules allowOnlyLowerOrUppercaseLettersHyphensOrApostrophes() {
        return Rules.builder()
            .required(true)
            .regex("^[^!\\@£$%^&()_+={}:\";<>,.\\/\\|\\\\`~0-9]*$")
            .regexFailureMessage("Please ensure your name has valid characters")
            .build();
    }

    public static Rules returnValidationForNonAllowedInput() {
        return allowOnlyLowerOrUppercaseLettersHyphensOrApostrophes().toBuilder()
            .maxLength(30)
            .minLength(2)
            .regexFailureMessage("Please ensure your name has valid characters and is less than 30 characters long.")
            .build();
    }
}
