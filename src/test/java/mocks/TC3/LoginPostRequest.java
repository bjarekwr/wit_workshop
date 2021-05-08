package mocks.TC3;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import models.Sender;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LoginPostRequest {

    String email;
    String password;

    public static LoginPostRequest getLoginPostRequest(Sender sender) {
        return LoginPostRequest.builder().email(sender.getEmail()).password(sender.getPassword()).build();
    }
}
