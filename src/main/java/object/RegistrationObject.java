package object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BasePage;
import utilities.Config;
import utilities.Constant;
import utilities.WaitHelper;

public class RegistrationObject extends BasePage {

    @FindBy(css = "//p[.='Daftar']")
    public WebElement registerButton;

    @FindBy(className = "bl-text-field__input")
    public WebElement inputEmailOrPhoneNumber;

    @FindBy(css = ".bl-button--primary")
    public WebElement verifyRegisterButton;

    // verify register popup
    @FindBy(className = "bl-card")
    public WebElement verifyRegisterPopup;

    @FindBy(css = ".ml-16")
    public WebElement closeVerifyRegisterPopup;

    @FindBy(css = ".mb-8")
    public WebElement verifySendCode;

    // verify otp popup
    @FindBy(className = "bl-text-field__input")
    public WebElement otpField;

    @FindBy(css = ".bl-button[data-v-1b117e18]")
    public WebElement verifyOTPButton;

    Config testConfig;

    public RegistrationObject(Config testConfig) {
        PageFactory.initElements(testConfig.driver, this);
        this.testConfig = testConfig;
    }

    public void clickRegisterButton() {
        WaitHelper.waitForElementToBeClickable(testConfig, registerButton, "waiting for register button");
        click(testConfig, registerButton, "registerButton is being clicked here");
    }

    public void inputEmailOrPhoneNumber() {
        WaitHelper.waitForElementToBeClickable(testConfig, inputEmailOrPhoneNumber, "waiting for email or phone number field");
        enterData(testConfig, inputEmailOrPhoneNumber, Constant.CREDENTIAL_REGISTER_PHONE_NUMBER, "email or phone number is being clicked here");
    }

    public void clickVerifyRegisterButton() {
        WaitHelper.waitForElementToBeClickable(testConfig, verifyRegisterButton, "waiting for verify register button");
        click(testConfig, verifyRegisterButton, "verifyRegisterButton is being clicked here");
    }

    public void clickVerifySendCode() {
        WaitHelper.waitForElementToBeClickable(testConfig, verifySendCode, "waiting for verify verify send code button");
        click(testConfig, verifySendCode, "verifySendCode is being clicked here");
    }

    public void validationOTPSection() {
        WaitHelper.waitForSeconds(testConfig, 20);

        if (IsElementEnabled(testConfig, verifyOTPButton)) {
            WaitHelper.waitForElementToBeClickable(testConfig, verifyOTPButton, "waiting for verification button");
            click(testConfig, verifyOTPButton, "verifyOTPButton is being clicked here");
        } else {
            testConfig.logComment("FAILED");
        }
    }
}
