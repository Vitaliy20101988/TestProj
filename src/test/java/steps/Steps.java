package steps;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.home_page.HomePage;
import settings.Configs;
import utils.browsers.BrowserManager;
import utils.logger.TestLogger;

public class Steps {

    private static final Logger logger = TestLogger.logger;
    protected WebDriver driver;


    public Steps() {
        driver = BrowserManager.getBrowser().getDriver();
    }


    public void loadPageWithCredentials(String login, String password) {
        String url = Configs.getWebConfigs().getUrl();
        String[] urlParts = url.split("//");
        driver.get(urlParts[0] + "//" + login + ":" + password + "@" + urlParts[1]);
    }

    public void clickElement(String elementXpath) {
        HomePage homePage = new HomePage();
        homePage.clickElement(elementXpath);
    }

    public void verify404Status() {
        Assert.assertFalse(driver.getCurrentUrl().contains("/404"), "URL should not contains /404");
    }
}
