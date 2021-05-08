package mocks.TC3.account.preferences;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationsResponse {

    @Default
    public PushNotifications pushNotifications = PushNotifications.builder().build();
    @Default
    public Boolean sms = true;
    @Default
    public Boolean whatsApp = false;
}
