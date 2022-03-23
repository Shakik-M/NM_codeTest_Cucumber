package pageObject;

import base.setUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class login extends setUp {

    public login (WebDriver driver){
        PageFactory.initElements(driver, this);
        setUp.driver = driver;
    }

    @FindBy(how = How.ID,using = "user-name")
    public WebElement nameLoc;

    public void enterUserName(String userName) {
        nameLoc.sendKeys(userName);
    }

    @FindBy(how = How.NAME,using = "password")
    public WebElement passLoc;

    public void enterPassword(String password) {
        passLoc.sendKeys(password);
    }

    @FindBy(how = How.ID,using = "login-button")
    public WebElement loginBtn;

    public void clickLoginButton() {
        loginBtn.click();
    }

    public void verifyHomepageTitle() {
        String act = driver.getTitle();
        String exp = "Swag Labs";
        Assert.assertEquals(exp, act);
    }

}
