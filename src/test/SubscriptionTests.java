package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import utilities.Constants;
import reusableModules.NewsLetterSubscription;
import java.util.Random;

import java.util.concurrent.TimeUnit;

/**
 * SubscriptionTests.java - has subscription tests
 * Tests include successful subscription, check for repeated subscription, invalid subscription
 * @author Sarath Babu V S
 * @version 1.0
 */

public class SubscriptionTests {
    String driverPath = ".//utilities//chromedriver.exe";
    WebDriver driver;

    String emailId;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(Constants.loginUrl);

        Random rand = new Random();
        int rand_int1 = rand.nextInt(1000);
        emailId = "testing"+rand_int1+"@test.com";
    }

    @Test
    public void validSubscription() {
        NewsLetterSubscription newsLetterSubscription = new NewsLetterSubscription();
        Assert.assertEquals(newsLetterSubscription.subscribe(driver, emailId),"Subscribed Successfully");
    }

    @Test(dependsOnMethods="validSubscription")
    public void alreadySubscribed() {
        NewsLetterSubscription newsLetterSubscription = new NewsLetterSubscription();
        Assert.assertEquals(newsLetterSubscription.subscribe(driver, emailId),"Already Subscribed");
    }

    @Test(dependsOnMethods="alreadySubscribed")
    public void inValidSubscription() throws  Exception {
        NewsLetterSubscription newsLetterSubscription = new NewsLetterSubscription();
        Assert.assertEquals(newsLetterSubscription.subscribe(driver, "test1"),"Kindly Enter a Valid Email Address.");

    }

    @AfterMethod
    public void timeBetweenTests() throws Exception{
        Thread.sleep(5000);
        driver.navigate().refresh();
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
