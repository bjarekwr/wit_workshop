package settings;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties",
                 "system:env",
                 "classpath:mock.properties"})
public interface EnvironmentConfig extends Config {

    EnvironmentConfig ENVIRONMENT_CONFIG = ConfigFactory.create(EnvironmentConfig.class);

    @Key("appium.server.port.range.start")
    long getAppiumServerPortRangeStart();

    @Key("url.service.legacyApi")
    String getLegacyApiServiceUrl();

    @Key("url.service.mercuryApi")
    String getMercuryServiceUrl();

    @Key("url.service.discountApi")
    String getDiscountApiServiceUrl();

    @Key("url.service.transferStateChangeService")
    String getTransactionStatusServiceUrl();

    @Key("url.service.pricingFeeApi")
    String getPricingFeeServiceUrl();

    @Key("url.service.mockApi")
    String getMockServiceUrl();

    @Key("element.presence.timeout.in.milliseconds")
    long getWaitingTimeoutForElementPresence();

    @Key("element.clickable.long.duration.timeout.in.milliseconds")
    long getWaitingLongDurationTimeoutForElementPresence();

    @Key("element.clickable.timeout.in.seconds")
    long getWaitingTimeoutForElementToBeClickableInSeconds();

    @Key("element.presence.timeout.in.seconds")
    long getWaitingTimeoutInSeconds();

    @Key("element.presence.long.duration.timeout.in.seconds")
    long getWaitingLongTimeoutInSeconds();

    @Key("url.service.wallet")
    String getWalletApiService();
}
