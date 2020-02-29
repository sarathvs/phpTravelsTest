package reusableModules;

import org.openqa.selenium.WebDriver;
import pages.NewsLetterPage;


public class NewsLetterSubscription {

    /**
     * Subscribe to new letters
     * @param emailId of the subscriber
     * @return subcription confirmation message
     */
    public static String subscribe(WebDriver driver, String emailId) {
        NewsLetterPage newsLetterSection = new NewsLetterPage(driver);
        newsLetterSection.enterEmailId(emailId);
        newsLetterSection.clickSubscribe();
        return newsLetterSection.getSubscriptionConfirmation();

    }
}
