package mocks.TC2.account;

import com.google.i18n.phonenumbers.PhoneNumberUtil;

import lombok.Builder;
import lombok.val;
import mocks.Codes.CountryCode;
import mocks.ForSignUpTest.*;
import models.Sender;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static mocks.Codes.CountryCode.GB;

@Builder
public class DetailsResponse {

    public List<Field> fields;
    public List<Group> groups;
    public Properties properties;

    public static DetailsResponse getDetailsResponse(Sender sender) {
        val groups = singletonList(Group.getAddressWithLookupDisabled());
        return DetailsResponse.builder()
            .fields(getAllFields(sender))
            .groups(groups)
            .properties(Properties.getDefaultProperties())
            .build();
    }

    /**
     * This is needed for iOS and is not breaking Android.
     * For iOS we need to have details response with 'obfuscated = false', otherwise 'Save changes' button is not displayed
     * once the user clicks 'Edit' on MyDetails screen. It is used in MyDetailsScreenTests.
     **/
    public static DetailsResponse getDetailsResponseWithoutObfuscated(List<Field> customFields) {
        val groups = singletonList(Group.getAddressWithLookupDisabled());
        return DetailsResponse.builder()
            .fields(customFields)
            .groups(groups)
            .properties(Properties.getPropertiesWithoutObfuscated())
            .build();
    }

    public static List<Field> getAllFields(Sender sender) {
        return List.of(
            getReferenceNumber("WR10399259"),
            getFirstName(sender),
            getMiddleName(sender),
            getLastName(sender),
            getEmail(sender),
            getDateOfBirth("1988-01-21T00:00:00Z"),
            getSenderGender(sender),
            getSenderMobile(sender),
            getSenderFlatUnit(sender),
            getSenderBuilding(sender),
            getSenderStreet(sender),
            getSenderPostalCode(sender),
            getSenderCity(sender),
            getSenderCountry(sender)
        );
    }

    public static Field getReferenceNumber(String value) {
        return getReferenceNumber().toBuilder()
            .value(value)
            .build();
    }

    public static Field getReferenceNumber() {
        return Field.builder()
            .id("SenderReferenceNumber")
            .label("Customer ID")
            .labelMarkups(singletonList(LabelMarkup.builder().build()))
            .inputType("string")
            .value("WR10399259")
            .readonly(true)
            .build();
    }

    public static Field getFirstName(Sender sender) {
        return getFirstName().toBuilder()
            .value(sender.getFirstName())
            .build();
    }

    public static Field getFirstName() {
        return Field.builder()
            .id("SenderFirstName")
            .label("First name")
            .labelMarkups(singletonList(LabelMarkup.builder().build()))
            .inputType("string")
            .rules(Rules.returnValidationForNonAllowedInput())
            .readonly(true)
            .build();
    }

    public static Field getMiddleName(Sender sender) {
        return getMiddleName().toBuilder()
            .value(sender.getMiddleName())
            .build();
    }

    public static Field getMiddleName() {
        return Field.builder()
            .id("SenderMiddleName")
            .label("Middle name")
            .labelMarkups(singletonList(LabelMarkup.builder().build()))
            .inputType("string")
            .rules(Rules.returnValidationForNonAllowedInput().toBuilder().required(false).build())
            .readonly(true)
            .build();
    }

    public static Field getLastName(Sender sender) {
        return getLastName().toBuilder()
            .value(sender.getLastName())
            .build();
    }

    public static Field getLastName() {
        return Field.builder()
            .id("SenderLastName")
            .label("Last name")
            .labelMarkups(singletonList(LabelMarkup.builder().build()))
            .description("Please input your full legal name as shown on your passport or driving license")
            .inputType("string")
            .rules(Rules.returnValidationForNonAllowedInput())
            .readonly(true)
            .build();
    }

    public static Field getEmail(Sender sender) {
        return getEmail().toBuilder()
            .value(sender.getEmail())
            .build();
    }

    public static Field getEmail() {
        val emailFieldDescription = "PLEASE TAKE NOTE: If you change your email address, you will be asked to log-in again, so make sure you "
                                    + "remember your password!";
        return Field.builder()
            .id("SenderEmail")
            .label("Email (used for logging-in)")
            .labelMarkups(singletonList(LabelMarkup.builder().build()))
            .description(emailFieldDescription)
            .tooltip(emailFieldDescription)
            .placeholder(emailFieldDescription)
            .inputType("email")
            .rules(Rules.builder()
                       .required(true)
                       .regex("^[A-Z0-9a-z\\._%+-]+@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$")
                       .regexFailureMessage("Email is invalid")
                       .build())
            .readonly(true)
            .build();
    }

    public static Field getDateOfBirth(String dateOfBirth) {
        return getDateOfBirth().toBuilder()
            .value(dateOfBirth)
            .build();
    }

    public static Field getDateOfBirth() {
        return Field.builder()
            .id("SenderDateOfBirth")
            .label("Date of birth")
            .labelMarkups(emptyList())
            .description("Fore example: 21 05 1999")
            .inputType("date")
            .rules(Rules.builder()
                       .required(true)
                       .minDate(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SS'Z'").format(LocalDateTime.now().minusYears(99)))
                       .maxDate(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SS'Z'").format(LocalDateTime.now().minusYears(18)))
                       .build())
            .readonly(false)
            .itemType("field")
            .build();
    }

    public static Field getSenderGender(Sender sender) {
        return getSenderGender().toBuilder()
            .value(sender.getGender())
            .build();
    }

    public static Field getSenderGender() {
        return Field.builder()
            .id("SenderGender")
            .label("Gender")
            .labelMarkups(emptyList())
            .inputType("select")
            .options(Option.getGenderOptions())
            .rules(Rules.builder().required(true).build())
            .readonly(true)
            .itemType("field")
            .build();
    }

    public static Field getSenderMobile(Sender sender) {
        return getSenderMobile().toBuilder()
            .value(sender.getMobile())
            .build();
    }

    public static Field getSenderMobile() {
        val areaCode = String.valueOf(PhoneNumberUtil.getInstance().getCountryCodeForRegion(GB.getAlpha2()));
        return Field.builder()
            .id("SenderMobile")
            .label("Mobile")
            .labelMarkups(emptyList())
            .description("Mobile")
            .placeholder("Mobile number")
            .inputType("phone")
            .dialCode(areaCode)
            .rules(Rules.builder().required(true)
                       .regex("^[^0]\\d+$")
                       .regexFailureMessage("Mobile number must only contain numbers with no leading 0. e.g. 7512345678")
                       .build())
            .readonly(true)
            .itemType("field")
            .build();
    }

    public static Field getSenderPhoneNumber(String value) {
        return getSenderPhoneNumber().toBuilder()
            .value(value)
            .build();
    }

    public static Field getSenderPhoneNumber() {
        return Field.builder()
            .id("SenderPhoneNumber")
            .label("Phone")
            .labelMarkups(emptyList())
            .description("Issuing Country")
            .inputType("phone")
            .dialCode("44")
            .rules(Rules.builder().required(false)
                       .regex("^\\d+$")
                       .regexFailureMessage("Phone number must only contain numbers")
                       .build())
            .readonly(false)
            .itemType("field")
            .build();
    }

    public static Field getSenderFlatUnit(Sender sender) {
        return getSenderFlatUnit().toBuilder()
            .value(sender.getAddress().getFlatNumber())
            .build();
    }

    public static Field getSenderFlatUnit() {
        return Field.builder()
            .id("SenderFlatUnit")
            .label("Flat/Unit No.")
            .labelMarkups(emptyList())
            .inputType("string")
            .groupId("address")
            .rules(Rules.builder().required(false)
                       .regex("^[0-9]*$")
                       .build())
            .readonly(false)
            .itemType("field")
            .build();
    }

    public static Field getSenderBuilding(Sender sender) {
        return getSenderBuilding().toBuilder()
            .value(sender.getAddress().getBuildingNameNo())
            .build();
    }

    public static Field getSenderBuilding() {
        return Field.builder()
            .id("SenderBuilding")
            .label("Building No./Name")
            .labelMarkups(emptyList())
            .inputType("string")
            .groupId("address")
            .rules(Rules.builder().required(true)
                       .build())
            .readonly(true)
            .itemType("field")
            .build();
    }

    public static Field getSenderStreet(Sender sender) {
        return getSenderStreet().toBuilder()
            .value(sender.getAddress().getStreet())
            .build();
    }

    public static Field getSenderStreet() {
        return Field.builder()
            .id("SenderStreet")
            .label("Street")
            .labelMarkups(emptyList())
            .inputType("string")
            .groupId("address")
            .rules(Rules.builder()
                       .required(true)
                       .maxLength(200)
                       .regex("^[a-zA-Z ]*$")
                       .build())
            .readonly(true)
            .itemType("field")
            .build();
    }

    public static Field getSenderSuburb(Sender sender) {
        return getSenderSuburb().toBuilder()
            .value(sender.getAddress().getCity())
            .build();
    }

    public static Field getSenderSuburb() {
        return Field.builder()
            .id("SenderSuburb")
            .label("Suburb")
            .labelMarkups(emptyList())
            .inputType("string")
            .groupId("address")
            .rules(Rules.builder().required(false)
                       .minLength(2)
                       .regex("^[a-zA-Z ]*$")
                       .build())
            .readonly(false)
            .itemType("field")
            .build();
    }

    public static Field getSenderCity(Sender sender) {
        return getSenderCity().toBuilder()
            .value(sender.getAddress().getCity())
            .build();
    }

    public static Field getSenderCity() {
        return Field.builder()
            .id("SenderCity")
            .label("City/Town")
            .labelMarkups(emptyList())
            .inputType("string")
            .groupId("address")
            .rules(Rules.builder()
                       .required(true)
                       .maxLength(200)
                       .regex("^[a-zA-Z ]*$")
                       .build())
            .readonly(false)
            .itemType("field")
            .build();
    }

    public static Field getSenderRegion(Sender sender) {
        return getSenderRegion().toBuilder()
            .value(sender.getAddress().getPostcode())
            .build();
    }

    public static Field getSenderRegion() {
        return Field.builder()
            .id("SenderRegion")
            .label("Region")
            .labelMarkups(emptyList())
            .inputType("string")
            .groupId("address")
            .rules(Rules.builder()
                       .required(false)
                       .maxLength(40)
                       .build())
            .readonly(false)
            .itemType("field")
            .build();
    }

    public static Field getSenderPostalCode(Sender sender) {
        return getSenderPostalCode().toBuilder()
            .value(sender.getAddress().getPostcode())
            .build();
    }

    public static Field getSenderPostalCode() {
        return Field.builder()
            .id("SenderPostalCode")
            .label("Postcode")
            .labelMarkups(emptyList())
            .inputType("string")
            .groupId("address")
            .rules(Rules.builder()
                       .required(true)
                       .build())
            .readonly(true)
            .itemType("field")
            .build();
    }

    public static Field getSenderCountry(Sender sender) {
        val senderCountry = CountryCode.getByCode(sender.getCountryCode());
        return getSenderCountryField(sender).toBuilder()
            .value(senderCountry.getAlpha2())
            .build();
    }

    private static Field getSenderCountryField(Sender sender) {
        val senderCountry = CountryCode.getByCode(sender.getCountryCode());
        return Field.builder()
            .id("SenderCountry")
            .label("Country")
            .labelMarkups(singletonList(LabelMarkup.builder().build()))
            .description("Please input your full legal name as shown on your passport or driving license")
            .inputType("country")
            .groupId("address")
            .options(Option.getOptionCountry(senderCountry))
            .rules(Rules.builder().required(true).build())
            .readonly(true)
            .build();
    }
}
