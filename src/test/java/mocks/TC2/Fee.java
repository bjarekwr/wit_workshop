package mocks.TC2;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Builder
@Value
public class Fee {

    BigDecimal amount;
    String currency;
    FeeType type;
}
