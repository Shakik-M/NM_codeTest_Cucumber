package pageObject;

import base.setUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import stepDef.Hook;

public class cart extends setUp {
    Hook Hook = new Hook();

    public cart (WebDriver driver){
        PageFactory.initElements(driver, this);
        setUp.driver = driver;
    }

    @FindBy(how = How.XPATH,using = "//div[@class='cart_item'][1]/div/a")
    public WebElement cartItem1Loc;

    @FindBy(how = How.XPATH,using = "//div[@class='cart_item'][2]/div/a")
    public WebElement cartItem2Loc;

    @FindBy(how = How.XPATH,using = "//div[@class='cart_item'][3]/div/a")
    public WebElement cartItem3Loc;

    public void assertCartItems(){
        Assert.assertEquals(cartItem1Loc.getText(), stepDef.Hook.item1, "ERROR! I1");
        Assert.assertEquals(cartItem2Loc.getText(), stepDef.Hook.item2, "ERROR! I2");
        Assert.assertEquals(cartItem3Loc.getText(), stepDef.Hook.item3, "ERROR! I3");
    }

    @FindBy(how = How.XPATH,using = "//div[@class='cart_item'][2]/div/div[2]/button")
    public WebElement removeItemLoc;

    public void removeItem() {
        removeItemLoc.click();
    }

    @FindBy(how = How.CSS,using = "[id='continue-shopping']")
    public WebElement continueShoppingLoc;

    public void continueShopping() {
        continueShoppingLoc.click();
    }

    @FindBy(how = How.ID,using = "checkout")
    public WebElement cartToCheckoutLoc;

    public void cartToCheckout() {
        cartToCheckoutLoc.click();
    }

}
