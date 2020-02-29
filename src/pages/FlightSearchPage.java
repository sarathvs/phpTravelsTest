package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;


public class FlightSearchPage {

    WebDriver driver;

    public FlightSearchPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickFlightsButton() {
        driver.findElement(By.xpath("//a[@data-name=\"flights\"]")).click();
    }

    public void enterFromLocation(String from) {
        WebDriverWait wait = new WebDriverWait(driver,30);

        driver.findElement(By.xpath("//*[@id='s2id_location_from']")).click();
        driver.findElement(By.xpath("//*[@id='select2-drop']/div/input")).sendKeys(from);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='select2-results']//li[contains(.,"+from+")]/div")));
        element.click();



    }

    public void enterToLocation(String to) {
        WebDriverWait wait = new WebDriverWait(driver,30);


        driver.findElement(By.xpath("//*[@id='s2id_location_to']")).click();
        driver.findElement(By.xpath("//*[@id='select2-drop']/div/input")).sendKeys(to);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='select2-results']//li[contains(.,"+to+")]/div")));
        element.click();
    }

    public void enterJourneyDate(String month, String day) {

        driver.findElement(By.id("FlightsDateStart")).click();

        WebElement element = driver.findElement(By.id("FlightsDateStart"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);

        driver.findElement(By.xpath("//div[contains(@class,\"datepicker\") and contains(@class, \"active\")]/nav/div[@class=\"datepicker--nav-title\"]")).click();
        String temp = "//div[contains(@class,\"datepicker--cell datepicker--cell-month\") and contains(text(), '" + month + "')]";

        element = driver.findElement(By.xpath(temp));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        temp = "//div[@class=\"datepicker--cell datepicker--cell-day\" and contains(text()," + day + ")]";
        driver.findElement(By.xpath(temp)).click();
    }

    public void search() {
        driver.findElement(By.xpath("//form[@name=\"flightmanualSearch\"]//button[contains(text(),\"Search\")]")).click();
    }
}
