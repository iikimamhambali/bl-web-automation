package object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BasePage;
import utilities.Config;
import utilities.WaitHelper;

public class CartObject extends BasePage {

    Config testConfig;

    public CartObject(Config testConfig) {
        PageFactory.initElements(testConfig.driver, this);
        this.testConfig = testConfig;
    }

    @FindBy(className = "bl-product-card__thumbnail")
    public WebElement productItem;

    @FindBy(css = ".multiselect__tags")
    public WebElement chooseItem;

    @FindBy(css = ".c-main-product__action__cart")
    public WebElement cartButton;

    // cart dialog component
    @FindBy(className = "c-dialog__content")
    public WebElement cartDialog;

    @FindBy(css = ".c-cart-dialog__item__quantity > button:nth-of-type(2)")
    public WebElement increaseItem;

    @FindBy(css = ".c-cart-dialog__item__quantity > button:nth-of-type(1)")
    public WebElement decreaseItem;

    @FindBy(css = ".u-txt--medium.ico_ui_cross")
    public WebElement removeItem;

    @FindBy(className = "c-dialog__close")
    public WebElement closeCartDialog;

    @FindBy(css = ".c-cart-dialog__cart-button")
    public WebElement viewCartItems;

    public void productItemClick() {
        for (int i = 0; i <= 10; i++) {
            if (i == 5) {
                WaitHelper.waitForElementToBeClickable(testConfig, productItem, "waiting for product item");
                click(testConfig, productItem, "productItem is being clicked here");
            }
        }
    }

    public void chooseItemClick() {
        for (int i = 0; i <= 5; i++) {
            if (i == 0) {
                WaitHelper.waitForElementToBeClickable(testConfig, chooseItem, "waiting for choose item");
                click(testConfig, chooseItem, "chooseItem is being clicked here");
            }
        }
    }

    public void cartButtonClick() {
        WaitHelper.waitForElementToBeClickable(testConfig, cartButton, "waiting for cart button");
        click(testConfig, cartButton, "cartButton is being clicked here");
    }

    public Boolean isCartDialogDisplayed() {
        WaitHelper.waitForElementToBeClickable(testConfig, cartDialog, "waiting for cart dialog");
        return true;
    }

    public void setIncreaseItem() {
        if (IsElementDisplayed(testConfig, cartDialog)) {
            WaitHelper.waitForElementToBeClickable(testConfig, increaseItem, "waiting for increase button");
            click(testConfig, increaseItem, "increaseItem is being clicked here");
        }
    }

    public void setDecreaseItem() {
        if (IsElementDisplayed(testConfig, cartDialog)) {
            WaitHelper.waitForElementToBeClickable(testConfig, decreaseItem, "waiting for decrease button");
            click(testConfig, decreaseItem, "decreaseItem is being clicked here");
        }
    }

    public void setRemoveItem() {
        if (IsElementDisplayed(testConfig, cartDialog)) {
            WaitHelper.waitForElementToBeClickable(testConfig, removeItem, "waiting for remove item button");
            click(testConfig, removeItem, "removeItem is being clicked here");
        }
    }

    public void setCloseCartDialog() {
        if (IsElementDisplayed(testConfig, cartDialog)) {
            WaitHelper.waitForElementToBeClickable(testConfig, closeCartDialog, "waiting for close button");
            click(testConfig, closeCartDialog, "closeCartDialog is being clicked here");
        }
    }

    public void setViewCartItems() {
        if (IsElementDisplayed(testConfig, cartDialog)) {
            WaitHelper.waitForElementToBeClickable(testConfig, viewCartItems, "waiting for view cart button");
            click(testConfig, viewCartItems, "viewCartItems is being clicked here");
        }
    }
}
