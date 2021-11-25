package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.*;

public class LoginStep extends BaseTest {

    @Given("on the {string}")
    public void onThe(String URL) {
        System.out.println("URL");
    }

    @When("click button login")
    public void clickButtonLogin() {
        System.out.println("Clicked");
    }

    @And("input phone number")
    public void inputPhoneNumber() {
        System.out.println("inputted");
    }

    @And("click on the button lanjut")
    public void clickOnTheButtonLanjut() {
        System.out.println("Clicked");
    }

    @Then("show verification popup")
    public void showVerificationPopup() {

    }
}
