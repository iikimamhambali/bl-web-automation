package object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BasePage;
import utilities.Config;
import utilities.WaitHelper;

public class SearchObject extends BasePage {

    Config testConfig;

    public SearchObject(Config testConfig) {
        PageFactory.initElements(testConfig.driver, this);
        this.testConfig = testConfig;
    }

    @FindBy(css = "#v-omnisearch__input")
    public WebElement searchBar;

    @FindBy(css = "#autosuggest__result-item--0")
    public WebElement recommendedItem;

    public void inputKeywords() {
        WaitHelper.waitForElementToBeClickable(testConfig, searchBar, "waiting for search bar button");
        click(testConfig, searchBar, "searchBar is being clicked here");
        enterData(testConfig, searchBar, "Kursi Kantor", "Value is inputted");
    }

    public void recommendedItemClick() {
        WaitHelper.waitForElementToBeClickable(testConfig, recommendedItem, "waiting for recommended item");
        click(testConfig, recommendedItem, "recommendedItem is being clicked here");
    }
}
