package utils;

import drivers.DriverFactory;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotUtils {

    private ScreenshotUtils() {
        // Private constructor to prevent instantiation
    }

    public static byte[] takeScreenshot() {
        AppiumDriver driver = DriverFactory.getCurrentDriver();

        if (driver == null) {
            return new byte[0];
        }

        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}