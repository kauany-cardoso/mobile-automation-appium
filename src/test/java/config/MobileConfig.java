package config;

public class MobileConfig {

    private static final String DEFAULT_PLATFORM_NAME = "Android";
    private static final String DEFAULT_DEVICE_NAME = "Android Emulator";
    private static final String DEFAULT_AUTOMATION_NAME = "UiAutomator2";
    private static final String DEFAULT_APP_PATH = "src/test/resources/apps/ApiDemos-debug.apk";
    private static final String DEFAULT_APPIUM_SERVER_URL = "http://127.0.0.1:4723/";

    private MobileConfig() {
        // Private constructor to prevent instantiation
    }

    public static String getPlatformName() {
        return System.getProperty("platformName", DEFAULT_PLATFORM_NAME);
    }

    public static String getDeviceName() {
        return System.getProperty("deviceName", DEFAULT_DEVICE_NAME);
    }

    public static String getAutomationName() {
        return System.getProperty("automationName", DEFAULT_AUTOMATION_NAME);
    }

    public static String getAppPath() {
        return System.getProperty("appPath", DEFAULT_APP_PATH);
    }

    public static String getAppiumServerUrl() {
        return System.getProperty("appiumServerUrl", DEFAULT_APPIUM_SERVER_URL);
    }
}