package mocks.TC2.configuration;

import lombok.Builder;
import lombok.Builder.Default;

import java.util.List;

import static mocks.Codes.CountryCode.IN;


@Builder
public class BillPaymentsConfiguration {

    @Default
    List<String> receiverCountries = List.of(IN.toString());
}
