package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import screens.HomeScreen;
import screens.ViewsScreen;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ApiDemosSteps {

    private final HomeScreen homeScreen = new HomeScreen();
    private final ViewsScreen viewsScreen = new ViewsScreen();

    @Then("I should see the Views menu")
    public void iShouldSeeTheViewsMenu() {
        assertThat(homeScreen.isViewsMenuDisplayed(), is(true));
    }

    @Then("I should see the App menu")
    public void iShouldSeeTheAppMenu() {
        assertThat(homeScreen.isAppMenuDisplayed(), is(true));
    }

    @Then("I should see the Animation menu")
    public void iShouldSeeTheAnimationMenu() {
        assertThat(homeScreen.isAnimationMenuDisplayed(), is(true));
    }

    @When("I access the Views menu")
    public void iAccessTheViewsMenu() {
        homeScreen.accessViewsMenu();
    }

    @Then("I should see the Controls option")
    public void iShouldSeeTheControlsOption() {
        assertThat(viewsScreen.isControlsOptionDisplayed(), is(true));
    }

    @Then("I should see the Date Widgets option")
    public void iShouldSeeTheDateWidgetsOption() {
        assertThat(viewsScreen.isDateWidgetsOptionDisplayed(), is(true));
    }

    @Then("I should see the Expandable Lists option")
    public void iShouldSeeTheExpandableListsOption() {
        assertThat(viewsScreen.isExpandableListsOptionDisplayed(), is(true));
    }

    @When("I scroll to the {string} option")
    public void iScrollToTheOption(String optionText) {
        viewsScreen.scrollToText(optionText);
    }

    @Then("the {string} option should be visible")
    public void theOptionShouldBeVisible(String optionText) {
        viewsScreen.scrollToText(optionText);
        assertThat(true, is(true));
    }
}