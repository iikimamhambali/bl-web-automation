import object.LoginObject;
import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.Browser;
import utilities.Config;
import utilities.Constant;

public class LoginRunner extends BaseTest {

    public void testLogin(Config testConfig) {
        Browser.openBrowserAndNavigateToUrl(testConfig, Constant.URL);
        LoginObject loginObject = new LoginObject(testConfig);
        loginObject.clickLoginButton();
        loginObject.inputPhoneNumber();
        loginObject.clickNextButton();
        loginObject.validationOTPSection();
    }

    @Test(dataProvider = "getTestConfig", description = "This testcase is verifying successful login")
    public void testLoginButtonClick(Config testConfig) {
        testLogin(testConfig);
        Browser.takeScreenshot(testConfig);
    }
}
