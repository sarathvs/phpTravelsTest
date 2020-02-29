package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import reusableModules.FlightSearchResults;
import utilities.Constants;

import java.util.concurrent.TimeUnit;

/**
 * FlightSearchTests.java - has flight search tests
 * Tests include search and filter by stops/airlines
 * @author Sarath Babu V S
 * @version 1.0
 */


public class FlightSearchTests {
    String driverPath = ".//utilities//chromedriver.exe";
    WebDriver driver;


    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(Constants.homeUrl);

    }

    @Test
    public void searchFlights()  {
        FlightSearchResults flightSearchResults = new FlightSearchResults();
        int count = flightSearchResults.searchFlights(driver, Constants.flightFrom, Constants.flightTo, Constants.journeyMonth, Constants.journeyDay, 0, 0, 0);
        Assert.assertEquals(count, Constants.flightCount);
    }

    @Test(dependsOnMethods="searchFlights")
    public void searchFlightsWithRouteStops()  {
       FlightSearchResults flightSearchResults = new FlightSearchResults();
       int count = flightSearchResults.filterResultsStops(driver,Constants.stops);
       Assert.assertEquals(count, Constants.flightCount1Stop);
    }

    @Test(dependsOnMethods="searchFlights")
    public void searchFlightsWithStopsAndAirlines()  {
        FlightSearchResults flightSearchResults = new FlightSearchResults();
        int count = flightSearchResults.filterResultsStopsAirline(driver, Constants.stops, Constants.airlines);
        Assert.assertEquals(count,Constants.flightCount1StopAirlines);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }

}
