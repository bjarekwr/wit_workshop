package mocks.TC3.configuration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Builder
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Flag {

    @Getter
    String id;
    @Getter
    Boolean isSupported;
}
