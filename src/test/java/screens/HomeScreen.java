package screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomeScreen extends BaseScreen {

    @AndroidFindBy(accessibility = "Views")
    private WebElement viewsMenu;

    @AndroidFindBy(accessibility = "App")
    private WebElement appMenu;

    @AndroidFindBy(accessibility = "Animation")
    private WebElement animationMenu;

    public HomeScreen() {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isViewsMenuDisplayed() {
        return isDisplayed(viewsMenu);
    }

    public boolean isAppMenuDisplayed() {
        return isDisplayed(appMenu);
    }

    public boolean isAnimationMenuDisplayed() {
        return isDisplayed(animationMenu);
    }

    public void accessViewsMenu() {
        tap(viewsMenu);
    }
}