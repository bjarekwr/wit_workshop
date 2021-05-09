package mocks.TC2.account.preferences;

import lombok.Builder;
import lombok.Builder.Default;
import mocks.TC2.account.FxNotifications;

import java.util.List;

@Builder
public class PushNotifications {

    @Default
    public Boolean promotions = true;
    @Default
    public Boolean announcements = true;
    public List<FxNotifications> fxNotifications;
}
