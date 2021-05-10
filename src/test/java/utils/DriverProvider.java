package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.SneakyThrows;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

import static settings.PlatformConfig.PLATFORM_CONFIG;

public class DriverProvider {

    private DriverProvider(){
    }

    public static AndroidDriver<AndroidElement> driver;

    public static AndroidDriver<AndroidElement> getInstance(){
        if (driver == null){
            driver = setupDriver();
        }
        return driver;
    }

    @SneakyThrows
    private static AndroidDriver<AndroidElement> setupDriver(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, PLATFORM_CONFIG.automationName());
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, PLATFORM_CONFIG.getAppPackage());
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,PLATFORM_CONFIG.getAppActivity());
        capabilities.setCapability(AndroidMobileCapabilityType.AVD, PLATFORM_CONFIG.avd());
        capabilities.setCapability("app","/Users/bjarek/Desktop/com.worldremit.android.dev.qa.apk");
        capabilities.setCapability(PLATFORM_CONFIG.newCommandTimeout(),"999999");
        // Initialize driver
        return new AndroidDriver<AndroidElement>(new URL(PLATFORM_CONFIG.getAppiumUrl()), capabilities);

    }
}
