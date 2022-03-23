package pageObject;

import base.setUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class inventory extends setUp {

    public inventory (WebDriver driver){
        PageFactory.initElements(driver, this);
        setUp.driver = driver;
    }

    @FindBy(how = How.XPATH,using = "//select[@class='product_sort_container']/option[3]")
    public WebElement priceSorterLoHi;

    public void sortLowtoHigh() {
        priceSorterLoHi.click();
    }

    @FindBy(how = How.XPATH,using = "//div[@class='inventory_list']/div[1]/div[2]/div[2]/button")
    public WebElement item1Add;

    public void addItem1toCart() {
        item1Add.click();
    }

    @FindBy(how = How.XPATH,using = "//div[@class='inventory_list']/div[3]/div[2]/div[2]/button")
    public WebElement item2Add;

    public void addItem2toCart() {
        item2Add.click();
    }

    @FindBy(how = How.XPATH,using = "//div[@class='inventory_list']/div[5]/div[2]/div[2]/button")
    public WebElement item3Add;

    public void addItem3toCart() {
        item3Add.click();
    }

    @FindBy(how = How.XPATH,using = "//div[@class='inventory_list']/div[4]/div[2]/div[2]/button")
    public WebElement item4Add;

    public void addItem4toCart() {
        item4Add.click();
    }

    @FindBy(how = How.CLASS_NAME,using = "shopping_cart_link")
    public WebElement cartLoc;

    public void gotoCart() {
        cartLoc.click();
    }

}
