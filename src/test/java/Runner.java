import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import object.LoginObject;
import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.Browser;
import utilities.Config;
import utilities.Constant;

@CucumberOptions(
        features = "src/test/resources/Login.feature",
        glue = {"steps"},
        plugin = {"json:target/cucumber-report/cucumber.json"}
)

public class Runner extends AbstractTestNGCucumberTests {

//    @Test(dataProvider = "getTestConfig", description = "This testcase is verifying successful buy now click to Midtrans demo site")
//    public void testLoginButtonClick(Config testConfig) {
//        Browser.openBrowserAndNavigateToUrl(testConfig, Constant.URL);
//
//        LoginObject loginObject = new LoginObject(testConfig);
//        loginObject.clickLoginButton();
//        loginObject.inputPhoneNumber();
//        loginObject.clickNextButton();
//
//        Browser.takeScreenshot(testConfig);
//    }


}
