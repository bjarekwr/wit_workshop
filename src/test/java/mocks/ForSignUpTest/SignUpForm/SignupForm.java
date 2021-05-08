package mocks.ForSignUpTest.SignUpForm;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.val;
import mocks.ForSignUpTest.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.singletonList;
import static mocks.ForSignUpTest.SignUpForm.ItemType.FIELD;

@Builder
public class SignupForm {

    @SerializedName("fields")
    public List<Field> fields;
    @SerializedName("groups")
    public List<Group> groups;

    public static SignupForm getDefaultSignupFormResponseBuilder() {
        val fields = List.of(
            getDefaultSenderCountryList(),
            getDefaultSenderRegionList(),
            getSenderEmail(),
            getSenderPassword(),
            getSenderGeneralTermsAndConditions(),
            getSenderGeneralTermsAndConditionsEEA(),
            getSenderGeneralTermsAndConditionsGB(),
            getTermsAndConditionsCheckbox(),
            getReferralCode());
        val groups = Arrays.asList(Group.getCountry(), Group.getLoginDetails());

        return SignupForm.builder().fields(fields).groups(groups).build();
    }

    public static Field getDefaultSenderCountryList() {
        val country = List.of(
            Option.builder().id("GB").label("United Kingdom").build(),
            Option.builder().id("JP").label("Japan").build(),
            Option.builder().id("US").label("United States").build());
        return getSenderCountry(country);
    }

    public static Field getSenderCountry(List<Option> countries) {
        val placeholderLabel = "Country";

        return Field.builder()
            .id("SenderCountry")
            .label(placeholderLabel)
            .inputType("country")
            .groupId(placeholderLabel)
            .options(countries)
            .rules(Rules.builder().required(true).build())
            .readonly(false)
            .build();
    }

    public static Field getDefaultSenderRegionList() {
        val region = List.of(
            Option.builder().id("AL").label("Alabama").build(),
            Option.builder().id("VA").label("Virginia").build());
        return getSenderRegion(region);
    }

    public static Field getSenderRegion(List<Option> regions) {
        return Field.builder()
            .id("SenderRegion")
            .label("State")
            .inputType("select")
            .groupId("Country")
            .options(regions)
            .rules(Rules.builder().required(true).build())
            .visibilityDependsOn(VisibilityDependsOn.builder().fieldId("SenderCountry").values(singletonList("US")).build())
            .readonly(false)
            .build();
    }

    public static Field getSenderFirstName() {
        val placeholderLabel = "First name";
        val rules = Rules.builder()
            .maxLength(30)
            .minLength(0)
            .required(true)
            .regex("^[^!@£$%^&*()_+\\-={}:\";'<>,.\\/\\\\|`~][^£$%^*_={}\";<>\\/\\\\|`~]{0,30}$")
            .regexFailureMessage("Please ensure your name has valid characters and is less than 30 characters long.")
            .build();

        return Field.builder()
            .id("SenderFirstName")
            .label(placeholderLabel)
            .placeholder(placeholderLabel)
            .inputType("string")
            .groupId("FullName")
            .rules(rules)
            .readonly(false)
            .build();
    }

    public static Field getSenderMiddleName() {
        val placeholderLabel = "Middle name";
        return Field.builder()
            .id("SenderMiddleName")
            .label(placeholderLabel)
            .placeholder(placeholderLabel)
            .inputType("string")
            .groupId("FullName")
            .rules(Rules.builder().required(false).build())
            .readonly(false)
            .build();
    }

    public static Field getSenderLastName() {
        val placeholderLabel = "Last name";
        val rules = Rules.builder()
            .maxLength(30)
            .minLength(0)
            .required(true)
            .regex("^[^!@£$%^&*()_+\\-={}:\";'<>,.\\/\\\\|`~][^£$%^*_={}\";<>\\/\\\\|`~]{0,30}$")
            .regexFailureMessage("Please ensure your name has valid characters and is less than 30 characters long.")
            .build();

        return Field.builder()
            .id("SenderLastName")
            .label(placeholderLabel)
            .placeholder(placeholderLabel)
            .inputType("string")
            .groupId("FullName")
            .rules(rules)
            .readonly(false)
            .build();
    }

    public static Field getSenderEmail() {
        val placeholderLabel = "Email";
        val rules = Rules.builder()
            .required(true)
            .regex(
                "^(([^<>()\\[\\]\\\\.,;:\\s@“]+(\\.[^<>()\\[\\]\\\\.,;:\\s@“]+)*)|(“.+“))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|"
                + "(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$")
            .regexFailureMessage("Email is invalid")
            .build();

        return Field.builder()
            .id("SenderEmail")
            .label(placeholderLabel)
            .placeholder(placeholderLabel)
            .inputType("email")
            .groupId("LoginDetails")
            .rules(rules)
            .readonly(false)
            .build();
    }

    public static Field getSenderPassword() {
        val placeholderLabel = "Password";
        val rules = Rules.builder()
            .required(true)
            .regex("^(?=.*?[0-9])(?=.*?[A-Z])(?=.*?[a-z]).{8,128}$")
            .regexFailureMessage("Your password must have at least\n - 8 characters\n - 1 number\n - 1 uppercase and 1 lower case letter")
            .build();

        return Field.builder()
            .id("SenderPassword")
            .label(placeholderLabel)
            .description("Your password should be at least 8 characters, and include 1 upper case letter, 1 lower case letter and 1 number.")
            .placeholder(placeholderLabel)
            .inputType("password")
            .groupId("LoginDetails")
            .rules(rules)
            .readonly(false)
            .build();
    }

    public static Field getTermsAndConditions() {
        val labelMarkups = new ArrayList<LabelMarkup>();
        labelMarkups.add(LabelMarkup.builder()
                             .markupType("Link")
                             .start(49)
                             .end(69)
                             .url("https://www.worldremit.com/en/about-us/terms-and-conditions") //probably we need to change to "lorem ipsum" mock
                             .build());
        labelMarkups.add(LabelMarkup.builder()
                             .markupType("Link")
                             .start(74)
                             .end(88)
                             .url("https://www.worldremit.com/en/about-us/privacy-policy") //probably we need to change to "lorem ipsum" mock
                             .build());
        val visibilityDependsOn = VisibilityDependsOn.builder()
            .fieldId("SenderCountry")
            .values(Arrays.asList(
                "BR",
                "CA",
                "GI",
                "GR",
                "HK",
                "IN",
                "JO",
                "KE",
                "KW",
                "NZ",
                "NG",
                "NO",
                "OM",
                "QA",
                "KR",
                "SA",
                "SG",
                "CH",
                "TW",
                "TZ",
                "AE",
                "US",
                "ZW"))
            .build();

        return Field.builder()
            .id("SenderTermsAndConditionsText")
            .label(
                "By submitting this form, you accept WorldRemit's Terms and Conditions and Privacy Policy and allow WorldRemit to contact you and "
                + "send you marketing communications using the contact details you have provided to us.")
            .labelMarkups(labelMarkups)
            .inputType("displayText")
            .visibilityDependsOn(visibilityDependsOn)
            .rules(Rules.builder().required(false).build())
            .readonly(false)
            .build();
    }

    public static Field getTermsAndConditionsPh() {
        val labelMarkups = new ArrayList<LabelMarkup>();
        labelMarkups.add(LabelMarkup.builder()
                             .markupType("Link")
                             .start(49)
                             .end(69)
                             .url("https://www.worldremit.com/en/about-us/terms-and-conditions?selectFrom=PH") //probably we need to change to
                             // "lorem ipsum" mock
                             .build());
        labelMarkups.add(LabelMarkup.builder()
                             .markupType("Link")
                             .start(74)
                             .end(88)
                             .url("https://www.worldremit.com/en/about-us/privacy-policy") //probably we need to change to "lorem ipsum" mock
                             .build());
        val visibilityDependsOn = VisibilityDependsOn.builder().fieldId("SenderCountry").values(singletonList("PH")).build();

        return Field.builder()
            .id("SenderTermsAndConditionsTextPH")
            .label(
                "By submitting this form, you accept WorldRemit's Terms and Conditions and Privacy Policy and allow WorldRemit to contact you and "
                + "send you marketing communications using the contact details you have provided to us.")
            .labelMarkups(labelMarkups)
            .inputType("displayText")
            .visibilityDependsOn(visibilityDependsOn)
            .rules(Rules.builder().required(false).build())
            .readonly(false)
            .build();
    }

    public static Field getTermsAndConditionsCheckbox() {
        val labelMarkups = new ArrayList<LabelMarkup>();
        labelMarkups.add(LabelMarkup.builder()
                             .markupType("Link")
                             .start(62)
                             .end(82)
                             .url("https://www.worldremit.com/en/about-us/terms-and-conditions") //probably we need to change to "lorem ipsum" mock
                             .build());
        labelMarkups.add(LabelMarkup.builder()
                             .markupType("Link")
                             .start(87)
                             .end(101)
                             .url("https://www.worldremit.com/en/about-us/privacy-policy") //probably we need to change to "lorem ipsum" mock
                             .build());
        val visibilityDependsOn = VisibilityDependsOn.builder().fieldId("SenderCountry").values(singletonList("JP")).build();

        return Field.builder()
            .id("SenderTermsAndConditionsCheckbox")
            .label(
                "By checking this box you understand and agree to WorldRemit's Terms and Conditions and Privacy Policy and allow WorldRemit to "
                + "contact you, including delivery of electronic receipts, by email and SMS.")
            .labelMarkups(labelMarkups)
            .inputType("checkbox")
            .visibilityDependsOn(visibilityDependsOn)
            .rules(Rules.builder().required(true).regexFailureMessage("Checkbox field is missing").build())
            .readonly(false)
            .build();
    }

    public static Field getSenderGeneralTermsAndConditions() {
        val labelMarkups = new ArrayList<LabelMarkup>();
        labelMarkups.add(LabelMarkup.builder()
                             .markupType("Link")
                             .start(49)
                             .end(69)
                             .url("https://www.worldremit.com/en/about-us/terms-and-conditions") //probably we need to change to "lorem ipsum" mock
                             .build());
        labelMarkups.add(LabelMarkup.builder()
                             .markupType("Link")
                             .start(74)
                             .end(88)
                             .url("https://www.worldremit.com/en/about-us/privacy-policy") //probably we need to change to "lorem ipsum" mock
                             .build());
        val visibilityDependsOn = VisibilityDependsOn.builder().fieldId("SenderCountry").values(singletonList("AU")).build();

        return Field.builder()
            .id("SenderGeneralTAndCText")
            .label("By submitting this form, you accept WorldRemit's Terms and Conditions and Privacy Policy.")
            .labelMarkups(labelMarkups)
            .inputType("displayText")
            .visibilityDependsOn(visibilityDependsOn)
            .rules(Rules.builder().required(false).build())
            .readonly(false)
            .build();
    }

    public static Field getSenderGeneralTermsAndConditionsEEA() {
        val labelMarkups = new ArrayList<LabelMarkup>();
        labelMarkups.add(LabelMarkup.builder()
                             .markupType("Link")
                             .start(49)
                             .end(69)
                             .url("https://www.worldremit.com/en/about-us/terms-and-conditions?region=fr") //probably we need to change to "lorem
                             // ipsum" mock
                             .build());
        labelMarkups.add(LabelMarkup.builder()
                             .markupType("Link")
                             .start(74)
                             .end(88)
                             .url("https://www.worldremit.com/en/about-us/privacy-policy?region=fr") //probably we need to change to "lorem ipsum"
                             // mock
                             .build());
        val visibilityDependsOn = VisibilityDependsOn.builder()
            .fieldId("SenderCountry")
            .values(Arrays.asList(
                "AT",
                "BE",
                "BG",
                "HR",
                "CY",
                "CZ",
                "DK",
                "EE",
                "FI",
                "FR",
                "DE",
                "GR",
                "HU",
                "IS",
                "IE",
                "IT",
                "LV",
                "LT",
                "LU",
                "MT",
                "NL",
                "NO",
                "PL",
                "PT",
                "RO",
                "SK",
                "SI",
                "ES",
                "SE",
                "CH"))
            .build();

        return Field.builder()
            .id("SenderGeneralTermsAndConditionsEEA")
            .label("By submitting this form, you accept WorldRemit's Terms and Conditions and Privacy Policy.")
            .labelMarkups(labelMarkups)
            .inputType("displayText")
            .visibilityDependsOn(visibilityDependsOn)
            .rules(Rules.builder().required(false).build())
            .readonly(false)
            .build();
    }

    public static Field getSenderGeneralTermsAndConditionsGB() {
        val labelMarkups = new ArrayList<LabelMarkup>();
        labelMarkups.add(LabelMarkup.builder()
                             .markupType("Link")
                             .start(49)
                             .end(69)
                             .url("https://www.worldremit.com/en/about-us/terms-and-conditions?region=gb") //probably we need to change to "lorem
                             // ipsum" mock
                             .build());
        labelMarkups.add(LabelMarkup.builder()
                             .markupType("Link")
                             .start(74)
                             .end(88)
                             .url("https://www.worldremit.com/en/about-us/privacy-policy?region=gb") //probably we need to change to "lorem ipsum"
                             // mock
                             .build());
        val visibilityDependsOn = VisibilityDependsOn.builder().fieldId("SenderCountry").values(singletonList("GB")).build();

        return Field.builder()
            .id("SenderGeneralTermsAndConditionsGB")
            .label("By submitting this form, you accept WorldRemit's Terms and Conditions and Privacy Policy.")
            .labelMarkups(labelMarkups)
            .inputType("displayText")
            .visibilityDependsOn(visibilityDependsOn)
            .rules(Rules.builder().required(false).build())
            .readonly(false)
            .build();
    }

    public static Field getSenderGeneralTermsAndConditionsRW() {
        val labelMarkups = new ArrayList<LabelMarkup>();
        labelMarkups.add(LabelMarkup.builder()
                             .markupType("Link")
                             .start(49)
                             .end(69)
                             .url("https://www.worldremit.com/en/about-us/terms-and-conditions?region=rw") //probably we need to change to "lorem
                             // ipsum" mock
                             .build());
        labelMarkups.add(LabelMarkup.builder()
                             .markupType("Link")
                             .start(74)
                             .end(88)
                             .url("https://www.worldremit.com/en/about-us/privacy-policy?region=rw") //probably we need to change to "lorem ipsum"
                             // mock
                             .build());
        val visibilityDependsOn = VisibilityDependsOn.builder().fieldId("SenderCountry").values(singletonList("RW")).build();

        return Field.builder()
            .id("SenderGeneralTermsAndConditionsRW")
            .label(
                "By submitting this form, you accept WorldRemit's Terms and Conditions and Privacy Policy and allow WorldRemit to contact you and "
                + "send you marketing communications using the contact details you have provided to us.")
            .labelMarkups(labelMarkups)
            .inputType("displayText")
            .visibilityDependsOn(visibilityDependsOn)
            .rules(Rules.builder().required(false).build())
            .readonly(false)
            .build();
    }

    public static Field getTermsAndConditionsCheckboxGdpr() {
        val labelMarkups = new ArrayList<LabelMarkup>();
        labelMarkups.add(LabelMarkup.builder()
                             .markupType("Link")
                             .start(62)
                             .end(82)
                             .url("https://www.worldremit.com/en/about-us/terms-and-conditions") //probably we need to change to "lorem ipsum" mock
                             .build());
        labelMarkups.add(LabelMarkup.builder()
                             .markupType("Link")
                             .start(87)
                             .end(101)
                             .url("https://www.worldremit.com/en/about-us/privacy-policy") //probably we need to change to "lorem ipsum" mock
                             .build());
        val visibilityDependsOn = VisibilityDependsOn.builder()
            .fieldId("SenderCountry")
            .values(Arrays.asList(
                "AU",
                "AT",
                "BE",
                "BG",
                "HR",
                "CY",
                "CZ",
                "DK",
                "EE",
                "FI",
                "FR",
                "DE",
                "HU",
                "IE",
                "IT",
                "LV",
                "LT",
                "LU",
                "MT",
                "NL",
                "PL",
                "PT",
                "RO",
                "SK",
                "SI",
                "ES",
                "SE",
                "GB"))
            .build();

        return Field.builder()
            .id("SenderTermsAndConditionsCheckboxGDPR")
            .label(
                "If you DO NOT wish to receive marketing information about our products and special offers, please check this box. You can manage "
                + "your push notification preferences on your mobile device.")
            .inputType("checkbox")
            .visibilityDependsOn(visibilityDependsOn)
            .rules(Rules.builder().required(false).build())
            .readonly(false)
            .build();
    }

    public static Field getReferralCode() {
        val placeholderLabel = "Referral Code";
        return Field.builder()
            .id("SenderReferralCode")
            .label(placeholderLabel)
            .placeholder(placeholderLabel)
            .groupId("LoginDetails")
            .inputType(FIELD.value)
            .rules(Rules.builder().regex("^(?:[A-Za-z0-9\\-\\ ]+|)$").required(false).build())
            .readonly(false)
            .build();
    }
}
