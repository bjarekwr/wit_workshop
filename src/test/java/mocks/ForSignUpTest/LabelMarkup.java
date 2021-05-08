package mocks.ForSignUpTest;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Builder
@FieldDefaults(level = PRIVATE)
public class LabelMarkup {

    @Default
    String markupType = "";
    @Default
    Integer start = 0;
    @Default
    Integer end = 1;
    @Default
    String url = "";
}
