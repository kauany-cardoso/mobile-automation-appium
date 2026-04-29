package screens;

import drivers.DriverFactory;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseScreen {

    protected AppiumDriver driver;
    protected WebDriverWait wait;

    public BaseScreen() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void tap(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected String getText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    protected boolean isDisplayed(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }
}