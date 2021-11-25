import object.RegistrationObject;
import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.Browser;
import utilities.Config;
import utilities.Constant;

public class RegistrationRunner extends BaseTest {

    @Test(dataProvider = "getTestConfig", description = "This testcase is verifying successful registration new account")
    public void testLoginButtonClick(Config testConfig) {
        Browser.openBrowserAndNavigateToUrl(testConfig, Constant.URL);

        RegistrationObject registrationObject = new RegistrationObject(testConfig);
        registrationObject.clickRegisterButton();
        registrationObject.inputEmailOrPhoneNumber();
        registrationObject.clickVerifySendCode();
        registrationObject.validationOTPSection();
        Browser.takeScreenshot(testConfig);
    }
}
