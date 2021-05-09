package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import static mocks.Codes.CountryCode.GB;


@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Address {

    @JsonIgnore
    @Default
    final String flatNumber = "1";
    final String buildingNameNo;
    final String street;
    final String city;
    final String postcode;
    final String country;

    public static Address getDefaultGbAddress() {
        return Address.builder()
            .buildingNameNo("221b")
            .street("Baker street")
            .city("London")
            .postcode("NW1")
            .country(GB.getName())
            .build();
    }
}
