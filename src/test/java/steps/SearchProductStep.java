package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import object.SearchObject;
import org.openqa.selenium.WebDriver;
import utilities.BaseTest;

public class SearchProductStep extends BaseTest {

    WebDriver webDriver = null;
    SearchObject searchObject = null;

    @Given("on the landing page")
    public void onTheLandingPage() {
        System.out.println("On the landing page");
    }

    @When("click on the search bar and press enter")
    public void clickOnTheSearchBarAndPressEnter() {
        System.out.println("clicked");
    }

    @Then("show product result")
    public void showProductResult() {
        System.out.println("Show result");
    }
}
