package pageObject;

import base.setUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class userInfo extends setUp {

    public userInfo (WebDriver driver){
        PageFactory.initElements(driver, this);
        setUp.driver = driver;
    }

    @FindBy(how = How.NAME,using = "firstName")
    public WebElement firstNameLoc;

    public void enterFirstName(String firstName) {
        firstNameLoc.sendKeys(firstName);
    }

    @FindBy(how = How.NAME,using = "lastName")
    public WebElement lastNameLoc;

    public void enterLastName(String lastName) {
        lastNameLoc.sendKeys(lastName);
    }

    @FindBy(how = How.NAME,using = "postalCode")
    public WebElement postalCodeLoc;

    public void enterPostalCode(String postalCode) {
        postalCodeLoc.sendKeys(postalCode);
    }

    @FindBy(how = How.CSS,using = "[value='Continue']")
    public WebElement conChkOutBtn;

    public void continueChkOutButton() {
        conChkOutBtn.click();
    }

}
