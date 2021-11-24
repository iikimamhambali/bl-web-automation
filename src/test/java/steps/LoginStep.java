package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import object.LoginObject;
import org.openqa.selenium.WebDriver;
import utilities.*;

public class LoginStep extends BaseTest {

    WebDriver webDriver = null;
    LoginObject loginObject = null;

    @Given("on the {string}")
    public void onThe(String URL) {
        loginObject.openBrowserAndNavigateToUrl(webDriver, Constant.URL);
        System.out.println("URL");
    }

    @When("click button login")
    public void clickButtonLogin() {
        loginObject.clickLoginButton();
        System.out.println("Clicked");
    }

    @And("input phone number")
    public void inputPhoneNumber() {
        loginObject.inputPhoneNumber();
        System.out.println("inputted");
    }

    @And("click on the button lanjut")
    public void clickOnTheButtonLanjut() {
        loginObject.clickNextButton();
        System.out.println("Clicked");
    }

    @Then("show verification popup")
    public void showVerificationPopup() {

    }

    @Given("already on verification popup")
    public void alreadyOnVerificationPopup() {

    }

    @When("click on the section otp")
    public void clickOnTheSectionOtp() {

    }

    @Then("show input otp page")
    public void showInputOtpPage() {
    }
}
