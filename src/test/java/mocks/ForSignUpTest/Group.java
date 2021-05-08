package mocks.ForSignUpTest;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Builder.Default;

@Builder
public class Group {

    @SerializedName("id")
    public String id;
    @SerializedName("label")
    public String label;
    @SerializedName("addressLookupEnabled")
    public Boolean addressLookupEnabled;
    @SerializedName("layout")
    @Default
    public String layout = "Inline";

    public static Group getCountry() {
        return Group.builder().id("Country").label("Country").addressLookupEnabled(false).build();
    }

    public static Group getLoginDetails() {
        return Group.builder().id("LoginDetails").label("Your login details").addressLookupEnabled(false).build();
    }

    public static Group getAddressWithLookupDisabled() {
        return Group.builder().id("address").label("Address").addressLookupEnabled(false).layout("SubForm").build();
    }

    public static Group getAddressWithLookupEnabled() {
        return Group.builder().id("address").label("Address").addressLookupEnabled(true).layout("SubForm").build();
    }
}
