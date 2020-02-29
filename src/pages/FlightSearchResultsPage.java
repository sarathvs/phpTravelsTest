package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FlightSearchResultsPage {
    WebDriver driver;

    public FlightSearchResultsPage(WebDriver driver){
        this.driver = driver;
    }

    public void waitForSearchResultsPage() {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),\"Modify Search\")]")));
        return;
    }

    public int searchCount() {
        List<WebElement> list = driver.findElements(By.xpath("//div[@class=\"theme-search-results-item-mask-link\"]"));
        return list.size();
    }

    public void selectStops(int stopCount) {
        String temp = "//input[@id=" +stopCount + " and @type='radio']/parent::div/label";
        driver.findElement(By.xpath(temp)).click();

    }

    public void selectAirlines(String airline) {
        String temp = "//input[@name='airlines' and @value='" + airline+ "']/parent::div";
        WebElement element = driver.findElement(By.xpath(temp));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);

        driver.findElement(By.xpath(temp)).click();
    }

}
