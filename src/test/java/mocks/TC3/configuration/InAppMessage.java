package mocks.TC3.configuration;

import lombok.Builder;

import java.util.Arrays;
import java.util.List;

@Builder
public class InAppMessage {

    public String id;
    public Boolean isVisible;

    public static List<InAppMessage> getDefault() {
        return Arrays.asList(
            InAppMessage.builder().id("open_banking").isVisible(true).build(),
            InAppMessage.builder().id("whats_new_billpayments").isVisible(true).build(),
            InAppMessage.builder().id("referfriend").isVisible(true).build(),
            InAppMessage.builder().id("walletwhatsnew").isVisible(true).build(),
            InAppMessage.builder().id("fxrates").isVisible(false).build(),
            InAppMessage.builder().id("rafupsell").isVisible(true).build(),
            InAppMessage.builder().id("requestmoneyexplain").isVisible(true).build(),
            InAppMessage.builder().id("recipientreferfriend").isVisible(false).build(),
            InAppMessage.builder().id("gov_offer_pakistan").isVisible(true).build(),
            InAppMessage.builder().id("gov_offer_bangladesh").isVisible(true).build(),
            InAppMessage.builder().id("nigeria_usd_only").isVisible(true).build());
    }
}
