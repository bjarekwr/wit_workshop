package mocks.TC3;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AccessTokenResponse {

    @Default
    String tokenType = "Bearer";
    @Default
    String accessToken = "some_secret_token";
}
