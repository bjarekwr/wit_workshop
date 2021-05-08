package mocks.ForSignUpTest;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ValueDependsOn {

    String fieldId;
}
