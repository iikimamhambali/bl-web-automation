import object.SearchObject;
import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.Browser;
import utilities.Config;
import utilities.Constant;

public class SearchRunner extends BaseTest {

    @Test(dataProvider = "getTestConfig", description = "This testcase is verifying successful buy now click to Midtrans demo site")
    public void testSearchProduct(Config testConfig) {
        Browser.openBrowserAndNavigateToUrl(testConfig, Constant.URL);

        SearchObject searchObject = new SearchObject(testConfig);
        searchObject.inputKeywords();
        searchObject.recommendedItemClick();

//        Browser.takeScreenshot(testConfig);
    }
}
