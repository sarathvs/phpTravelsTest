package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.*;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import reusableModules.*;
import utilities.Constants;

/**
 * LoginTests.java - has login tests with credentials from xlsx
 * Each test verifies successful login
 * @author Sarath Babu V S
 * @version 1.0
 */

public class LoginTests {

    String driverPath = ".//utilities//chromedriver.exe";
    WebDriver driver;


   @BeforeClass
    public void setup(){

        System.setProperty("webdriver.chrome.driver", driverPath);
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.manage().window().maximize();
        driver.get(Constants.loginUrl);
    }


    @DataProvider(name = "Login Data")
    public Object[][] dat(){
        return GetExcelData.getExcelData(Constants.loginData,"Sheet1");
    }


    @Test(dataProvider="Login Data")
    public void testLoginPage(String username, String password) throws Exception{
        LoginLogout.login(driver, username,password);
        Assert.assertTrue(LoginLogout.getWelcomeText(driver).contains("Hi"));
        LoginLogout.logout(driver);

    }

    @AfterClass
    public void teardown() {
       driver.quit();
    }
}
