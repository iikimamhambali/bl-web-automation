import object.SearchObject;
import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.Browser;
import utilities.Config;
import utilities.Constant;

public class SearchRunner extends BaseTest {

    public void testSearch(Config testConfig) {
        Browser.openBrowserAndNavigateToUrl(testConfig, Constant.URL);
        SearchObject searchObject = new SearchObject(testConfig);
        searchObject.inputKeywords();
        searchObject.recommendedItemClick();
    }

    @Test(dataProvider = "getTestConfig", description = "This testcase is verifying successful search product")
    public void testSearchProduct(Config testConfig) {
        testSearch(testConfig);
    }
}
