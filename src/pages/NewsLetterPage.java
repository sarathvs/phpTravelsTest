package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class NewsLetterPage {
    WebDriver driver;

    public NewsLetterPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterEmailId(String emailId) {
        driver.findElement(By.xpath("//button[contains(@class,\"sub_newsletter\")]/parent::div/parent::div/input")).clear();

        driver.findElement(By.xpath("//button[contains(@class,\"sub_newsletter\")]/parent::div/parent::div/input")).sendKeys(emailId);
    }

    public void clickSubscribe() {
        driver.findElement(By.xpath("//button[contains(@class,\"sub_newsletter\")]")).click();
    }

    public String getSubscriptionConfirmation() {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,\"subscriberesponse\")]")));

        return driver.findElement(By.xpath("//div[contains(@class,\"subscriberesponse\")]")).getText();
    }
}
