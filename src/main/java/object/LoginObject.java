package object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.*;

public class LoginObject extends BasePage {

    @FindBy(css = ".te-header-login > .pr-4")
    private WebElement loginButton;

    @FindBy(css = "#LoginID")
    private WebElement emailOrPhoneNumberField;

    @FindBy(css = "#submit_button")
    private WebElement nextButton;

    @FindBy(css = "#login-with-otp")
    private WebElement otpSection;

    @FindBy(css = "[aria-label='Kode rahasia']")
    private WebElement otpField;

    @FindBy(css = ".bl-button[data-v-1b117e18]")
    private WebElement verificationButton;

    Config testConfig;

    public LoginObject(Config testConfig) {
        PageFactory.initElements(testConfig.driver, this);
        this.testConfig = testConfig;
    }

    public void clickLoginButton() {
        WaitHelper.waitForElementToBeClickable(testConfig, loginButton, "waiting for login button");
        click(testConfig, loginButton, "loginButton is being clicked here");
    }

    public void inputPhoneNumber() {
        WaitHelper.waitForElementToBeClickable(testConfig, emailOrPhoneNumberField, "waiting for field button");
        enterData(testConfig, emailOrPhoneNumberField, Constant.CREDENTIAL_PHONE_NUMBER, "field is being clicked here");
    }

    public void clickNextButton() {
        WaitHelper.waitForElementToBeClickable(testConfig, nextButton, "waiting for next button");
        click(testConfig, nextButton, "nextButton is being clicked here");
    }

    public void validationOTPSection() {
        WaitHelper.waitForSeconds(testConfig, 20);

        if (IsElementEnabled(testConfig, verificationButton)) {
            WaitHelper.waitForElementToBeClickable(testConfig, verificationButton, "waiting for verification button");
            click(testConfig, verificationButton, "verificationButton is being clicked here");
        } else {
            testConfig.logComment("FAILED");
        }
    }
}
