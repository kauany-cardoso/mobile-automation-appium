package screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ViewsScreen extends BaseScreen {

    @AndroidFindBy(accessibility = "Controls")
    private WebElement controlsOption;

    @AndroidFindBy(accessibility = "Date Widgets")
    private WebElement dateWidgetsOption;

    @AndroidFindBy(accessibility = "Expandable Lists")
    private WebElement expandableListsOption;

    public ViewsScreen() {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isControlsOptionDisplayed() {
        return isDisplayed(controlsOption);
    }

    public boolean isDateWidgetsOptionDisplayed() {
        return isDisplayed(dateWidgetsOption);
    }

    public boolean isExpandableListsOptionDisplayed() {
        return isDisplayed(expandableListsOption);
    }

    public void scrollToText(String text) {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"
        ));
    }
}