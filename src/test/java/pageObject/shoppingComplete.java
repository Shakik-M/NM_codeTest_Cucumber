package pageObject;

import base.setUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import stepDef.Hook;

public class shoppingComplete extends setUp {

    public shoppingComplete (WebDriver driver){
        PageFactory.initElements(driver, this);
        setUp.driver = driver;
    }

    @FindBy(how = How.CSS,using = "[class='complete-header']")
    public WebElement successMessageLoc;

    public void assertSuccessMessage() {
        Assert.assertEquals(successMessageLoc.getText(), Hook.successMessage, "Checkout Complete Error!");
    }

}
