package mocks.TC3;

import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Builder;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@Builder
public class LoginStub {

    public static class LoginStubBuilder {

        private final String loginUrl = "/mercury/auth/login";
        private final Gson GSON = new GsonBuilder().serializeNulls().create();
        private MappingBuilder loginStub;

        public LoginStubBuilder forSender() {
            loginStub = post(urlEqualTo(loginUrl));
            return this;
        }

        public LoginStubBuilder withSuccessResponse() {
            loginStub.willReturn(okJson(GSON.toJson(AccessTokenResponse.builder().build())));
            return this;
        }

        public void build() {
            stubFor(loginStub);
        }
    }
}
