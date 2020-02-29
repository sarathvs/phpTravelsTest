package reusableModules;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.LandingPage;


public class LoginLogout {

    /**
     * Login to the website
     * @param driver Webdriver instance
     * @param username login email id
     * @param password login password
     */
    public static void login(WebDriver driver, String username, String password) throws Exception{
        LoginPage login = new LoginPage(driver);
        login.enterUserName(username);
        login.enterPassword(password);
        login.clickLoginButton();
        login.waitForLogin();
    }

    /**
     * Read the welcome text
     * @param driver Webdriver instance
     * @return welcome text Ex: Hi, User1
     */
    public static String getWelcomeText(WebDriver driver) {
        LandingPage landingPage = new LandingPage(driver);
        return landingPage.welcomeText();
    }

    /**
     * Logout of the website
     * @param driver Webdriver instance
     */
    public static void logout(WebDriver driver) {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.selectMyAccount();
        landingPage.selectLogout();
    }

}
