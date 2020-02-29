package reusableModules;
import org.openqa.selenium.WebDriver;
import pages.FlightSearchPage;
import pages.FlightSearchResultsPage;

public class FlightSearchResults {
    /**
     * Search flights with inputs and return back count of available flights
     * @param driver Webdriver instance
     * @param from From location
     * @param to To location
     * @param month Travel month
     * @param day Travel day
     * @param adultCount Count of adult members
     * @param childCount Count of children
     * @param infantCount Count of infants
     * @return count of flights available
     */

    public static int searchFlights(WebDriver driver, String from, String to, String month, String day, int adultCount, int childCount, int infantCount)  {
        FlightSearchPage flightSearch = new FlightSearchPage(driver);
        FlightSearchResultsPage flightSearchResults = new FlightSearchResultsPage(driver);

        flightSearch.clickFlightsButton();
        flightSearch.enterFromLocation(from);
        flightSearch.enterToLocation(to);
        flightSearch.enterJourneyDate(month, day);
        flightSearch.search();
        flightSearchResults.waitForSearchResultsPage();
        return flightSearchResults.searchCount();
    }

    /**
     *
     * @param driver Webdriver instance
     * @param routeStops No. of stops
     * @return count of flights available after filter
     */
    public static int filterResultsStops(WebDriver driver, int routeStops) {
        FlightSearchResultsPage flightSearchResults = new FlightSearchResultsPage(driver);
        flightSearchResults.selectStops(routeStops);
        flightSearchResults.waitForSearchResultsPage();
        return flightSearchResults.searchCount();
    }

    /**
     *
     * @param driver Webdriver instance
     * @param routeStops No. of stops
     * @param airline Airline to be filtered
     * @return count of flights available after filter
     */
    public static int filterResultsStopsAirline(WebDriver driver, int routeStops, String airline) {
        FlightSearchResultsPage flightSearchResults = new FlightSearchResultsPage(driver);
        flightSearchResults.selectStops(routeStops);
        flightSearchResults.waitForSearchResultsPage();
        flightSearchResults.selectAirlines(airline);
        flightSearchResults.waitForSearchResultsPage();
        return flightSearchResults.searchCount();
    }
}
