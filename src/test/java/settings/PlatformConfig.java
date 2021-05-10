package settings;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties",
                 "system:env",
                 "classpath:android.properties"})
public interface PlatformConfig extends Config {

    PlatformConfig PLATFORM_CONFIG = ConfigFactory.create(PlatformConfig.class);

    @Key("appiumUrl")
    @DefaultValue("http://127.0.0.1:5001/wd/hub")
    String getAppiumUrl();

    @Key("appPath")
    String appPath();

    @Key("deviceName")
    String deviceName();

    @Key("avd")
    String avd();

    @Key("automationName")
    String automationName();

    @Key("platformVersion")
    String platformVersion();

    @Key("executionPlatform")
    String getExecutionPlatform();

    @Key("appPackage")
    String getAppPackage();

    @Key("appPackageTerminate")
    String getAppPackageTerminate();

    @Key("appActivity")
    String getAppActivity();

    @Key("appWaitActivity")
    String getAppWaitActivity();

    @Key("dateTimePattern")
    @DefaultValue("yyyy-MM-dd'T'HH:mm:ss.SS'Z'")
    String dateTimePattern();

    @Key("newCommandTimeout")
    String newCommandTimeout();
}
