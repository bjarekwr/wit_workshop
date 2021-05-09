package mocks.TC2;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.val;
import mocks.Codes.CountryCode;
import models.Sender;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountResponse {

    String id;
    String reference;
    Boolean isActivated;
    String language;
    String email;
    String firstName;
    String middleName;
    String lastName;
    String gender;
    String mobile;
    String phone;
    Country country;
    String state;
    Boolean isSender;

    public static AccountResponse getActivatedAccountResponse(Sender sender, CountryCode countryCode) {
        return AccountResponse.builder()
            .id("10399259")
            .reference("WR10399259")
            .isActivated(true)
            .language("en")
            .email(sender.getEmail())
            .firstName(sender.getFirstName())
            .middleName(sender.getMiddleName())
            .lastName(sender.getLastName())
            .gender(sender.getGender())
            .mobile(sender.getMobile())
            .phone(sender.getPhone())
            .country(Country.getCountryResponse(countryCode))
            .state("••••")
            .isSender(true)
            .build();
    }

    @Builder
    private static class Country {

        String code;
        Integer dialCode;

        private static Country getCountryResponse(CountryCode countryCode) {
            val alphaCode = countryCode.getAlpha2();
            return Country.builder().code(alphaCode).dialCode(PhoneNumberUtil.getInstance()
                                                                  .getCountryCodeForRegion(alphaCode)).build();
        }
    }
}
