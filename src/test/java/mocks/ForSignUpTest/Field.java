package mocks.ForSignUpTest;

import lombok.Builder;
import lombok.Builder.Default;
import mocks.ForSignUpTest.SignUpForm.VisibilityDependsOn;

import java.util.List;

@Builder(toBuilder = true)
public class Field {

    @Default
    public String id = null;
    @Default
    String label = null;
    @Default
    List<LabelMarkup> labelMarkups = null;
    @Default
    String inputType = null;
    @Default
    List<Option> options = null;
    @Default
    String groupId = null;
    Rules rules;
    VisibilityDependsOn visibilityDependsOn;
    ValueDependsOn valueDependsOn;
    @Default
    String placeholder = null;
    @Default
    String description = null;
    @Default
    String dialCode = null;
    @Default
    String value = null;
    @Default
    String tooltip = null;
    OptionsUrl optionsUrl;
    @Default
    Boolean hidden = false;
    @Default
    Boolean readonly = false;
    @Default
    String itemType = null;
}
