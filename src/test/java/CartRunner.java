import object.CartObject;
import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.Browser;
import utilities.Config;

public class CartRunner extends BaseTest {

    @Test(dataProvider = "getTestConfig", description = "This testcase is verifying successful add to cart")
    public void testAddToCart(Config testConfig) {
        LoginRunner loginRunner = new LoginRunner();
        loginRunner.testLogin(testConfig);

        SearchRunner searchRunner = new SearchRunner();
        searchRunner.testSearch(testConfig);

        CartObject cartObject = new CartObject(testConfig);
        cartObject.productItemClick();
        cartObject.chooseItemClick();
        cartObject.cartButtonClick();
        cartObject.setViewCartItems();

        Browser.takeScreenshot(testConfig);
    }
}
