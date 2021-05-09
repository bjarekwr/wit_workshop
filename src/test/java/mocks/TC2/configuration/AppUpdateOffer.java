package mocks.TC2.configuration;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.Value;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Value
@Builder(access = PRIVATE)
public class AppUpdateOffer {

    @Default
    String title = "Update required";
    @Default
    String content = "Lorem ipsum dolor sit amet consectetur adipiscing elit.";
    List<Object> contentMarkup;
    @Default
    String callToActionTitle = "Update now";
    String secondaryActionTitle;

    public static AppUpdateOffer getDefaultAppUpdateOffer() {
        return AppUpdateOffer.builder().build();
    }
}
