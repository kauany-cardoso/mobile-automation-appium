package drivers;

import config.MobileConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.Duration;

public class DriverFactory {

    private static AppiumDriver driver;

    private DriverFactory() {
        // Private constructor to prevent instantiation
    }

    public static AppiumDriver getDriver() {
        if (driver == null) {
            driver = createAndroidDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        return driver;
    }

    private static AppiumDriver createAndroidDriver() {
        String appAbsolutePath = Paths.get(MobileConfig.getAppPath())
                .toAbsolutePath()
                .toString();

        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName(MobileConfig.getPlatformName())
                .setDeviceName(MobileConfig.getDeviceName())
                .setAutomationName(MobileConfig.getAutomationName())
                .setApp(appAbsolutePath)
                .setNoReset(false)
                .setAutoGrantPermissions(true)
                .setNewCommandTimeout(Duration.ofSeconds(120));

        try {
            return new AndroidDriver(new URL(MobileConfig.getAppiumServerUrl()), options);
        } catch (MalformedURLException exception) {
            throw new RuntimeException("Invalid Appium server URL: " + MobileConfig.getAppiumServerUrl(), exception);
        }
    }

    public static AppiumDriver getCurrentDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}