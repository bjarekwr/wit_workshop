package mocks.ForSignUpTest;

import lombok.Builder;
import mocks.Codes.CountryCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Builder
public class Option {

    public String id;
    public String label;

    public static List<Option> getGenderOptions() {
        return Arrays.asList(
            Option.builder().id("Female").label("Female").build(),
            Option.builder().id("Male").label("Male").build()
        );
    }

    public static List<Option> getOptionCountry(CountryCode country) {
        return Collections.singletonList(
            Option.builder()
                .id(country.getAlpha2())
                .label(country.getName())
                .build()
        );
    }
}
