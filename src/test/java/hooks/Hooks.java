package hooks;

import drivers.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ScreenshotUtils;

public class Hooks {

    @Before
    public void setUp() {
        DriverFactory.getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ScreenshotUtils.takeScreenshot();
            scenario.attach(screenshot, "image/png", "Failed Scenario Screenshot");
        }

        DriverFactory.quitDriver();
    }
}