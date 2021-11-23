package object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.*;

import java.io.File;

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
    WebDriver webDriver;

    public LoginObject(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public void openBrowserAndNavigateToUrl(WebDriver driver, String url) {
        if (driver == null)
            openBrowser();

        driver.get(url);
    }

    public void openBrowser() {
        DesiredCapabilities capabilities = null;
        if (Config.osName.startsWith("Window"))
            System.setProperty("webdriver.chrome.driver", "drivers" + File.separator + "chromedriver.exe");
        else
            System.setProperty("webdriver.chrome.driver", "drivers" + File.separator + "chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("start-fullscreen");
        capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        chromeOptions.merge(capabilities);
    }

    public void clickLoginButton() {
//        WaitHelper.waitForElementToBeClickable(testConfig, loginButton, "waiting for login button");
//        click(testConfig, loginButton, "loginButton is being clicked here");
        loginButton.click();
    }

    public void inputPhoneNumber() {
//        WaitHelper.waitForElementToBeClickable(testConfig, emailOrPhoneNumberField, "waiting for field button");
//        enterData(testConfig, emailOrPhoneNumberField, Constant.CREDENTIAL_PHONE_NUMBER, "field is being clicked here");

        emailOrPhoneNumberField.click();
        emailOrPhoneNumberField.sendKeys(Constant.CREDENTIAL_PHONE_NUMBER);
    }

    public void clickNextButton() {
//        WaitHelper.waitForElementToBeClickable(testConfig, emailOrPhoneNumberField, "waiting for next button");
//        click(testConfig, nextButton, "nextButton is being clicked here");

        nextButton.click();
    }

}
