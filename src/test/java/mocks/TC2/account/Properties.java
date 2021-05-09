package mocks.TC2.account;

import lombok.Builder;

@Builder(toBuilder = true)
public class Properties {

    public String senderId;
    public Boolean obfuscated;
    public Boolean isActivated;
    public Boolean isEditable;

    public static Properties getDefaultProperties() {
        return Properties.builder().senderId("9713053").obfuscated(true).isActivated(true).isEditable(false).build();
    }

    /**
     * This is needed for iOS and is not breaking Android.
     * Once the user clicks "Edit" on MyDetails screen then we need to setup obfuscated to false to see "Save changes".
     **/
    public static Properties getPropertiesWithoutObfuscated() {
        return getDefaultProperties().toBuilder().obfuscated(false).build();
    }
}
