package mocks.ForSignUpTest.SignUpForm;

public enum ItemType {
    FIELD("field"),
    GROUP("group");

    public String value;

    ItemType(final String value) {
        this.value = value;
    }
}
