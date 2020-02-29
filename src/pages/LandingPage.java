package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    WebDriver driver;

    public LandingPage(WebDriver driver){
        this.driver = driver;
    }

    public String welcomeText() {
        return driver.findElement(By.xpath("(//h3)[1]")).getText();

    }

    public void selectMyAccount() {
        driver.findElement(By.xpath("//a[contains(text(), \"Logout\")]/parent::div/parent::div/parent::div")).click();
    }

    public void selectLogout() {
        driver.findElement(By.xpath("//a[contains(text(), \"Logout\")]")).click();
    }
}
