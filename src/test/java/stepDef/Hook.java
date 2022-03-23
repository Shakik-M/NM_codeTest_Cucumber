package stepDef;

import base.setUp;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.messages.internal.com.google.common.base.Strings;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hook extends setUp{

    public static String url;
    public static String userName;
    public static String password;
    public static String item1 = "Sauce Labs Onesie";
    public static String item2 = "Sauce Labs Bolt T-Shirt";
    public static String item3 = "Sauce Labs Backpack";
    public static String item4 = "Sauce Labs Fleece Jacket";
    public static Double itemPrice1 = 7.99;
    public static Double itemPrice3 = 29.99;
    public static Double itemPrice4 = 49.99;
    public static String firstName = "Muhammad";
    public static String lastName = "Shakik";
    public static String postalCode = "12345";
    public static String successMessage = "THANK YOU FOR YOUR ORDER";
    public static String driverType = System.getProperty("browser");
    public static String envData = System.getProperty("env");

    @Before
    public void startTest(){

        if (Strings.isNullOrEmpty(driverType)){
            driverType = "chrome";
        }
        if (Strings.isNullOrEmpty(envData)){
            envData = "qa";
        }

        driver = setUpBrowser(driverType);

        switch (envData){
            case "qa":
                url = "https://www.saucedemo.com/";
                userName = "standard_user";
                password = "secret_sauce";
                break;
            case "stage":
                url = "https://www.saucedemo.com/";
                userName = "standard_user";
                password = "secret_sauce";

                break;
            case "prod":
                url = "https://www.saucedemo.com/";
                userName = "standard_user";
                password = "secret_sauce";
                break;

        }
        driver.get(url);
    }

    @After
    public void endTest(Scenario scenario){
        try {
            if (scenario.isFailed()){
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                // embed it in the report.
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
        } finally {
            driver.quit();
        }
    }


}
