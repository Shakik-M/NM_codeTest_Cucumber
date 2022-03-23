package pageObject;

import base.setUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import stepDef.Hook;

import java.text.DecimalFormat;

public class checkout extends setUp {

    DecimalFormat df = new DecimalFormat("0.00");

    public checkout (WebDriver driver){
        PageFactory.initElements(driver, this);
        setUp.driver = driver;
    }

    @FindBy(how = How.XPATH,using = "//div[@class='cart_item'][1]/div/a")
    public WebElement chkItem1Loc;

    @FindBy(how = How.XPATH,using = "//div[@class='cart_item'][2]/div/a")
    public WebElement chkItem2Loc;

    @FindBy(how = How.XPATH,using = "//div[@class='cart_item'][3]/div/a")
    public WebElement chkItem3Loc;

    public void assertCheckOutItems(){
        Assert.assertEquals(chkItem1Loc.getText(), Hook.item1, "ERROR Chkout! I1");
        Assert.assertEquals(chkItem2Loc.getText(), Hook.item3, "ERROR Chkout! I2");
        Assert.assertEquals(chkItem3Loc.getText(), Hook.item4, "ERROR Chkout! I4");
    }


    @FindBy(how = How.CSS,using = "[class='summary_tax_label']")
    public WebElement taxLoc;

    @FindBy(how = How.CSS,using = "[class='summary_total_label']")
    public WebElement totalPriceLoc;

    public void assertTotalPrice(){
        Double itemPriceInclTax = Double.parseDouble(taxLoc.getText().substring(6))+Hook.itemPrice1+Hook.itemPrice3+Hook.itemPrice4;
        String ExpTotalPrice = df.format(itemPriceInclTax);
        Double TP = Double.parseDouble(totalPriceLoc.getText().substring(8));
        String ActTotalPrice = df.format(TP);
        Assert.assertEquals(ActTotalPrice, ExpTotalPrice, "Total Price Error!");
    }

    @FindBy(how = How.ID,using = "finish")
    public WebElement finishBtnLoc;

    public void clickFinishBtn() {
        finishBtnLoc.click();
    }



}
