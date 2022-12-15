package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import steps.Steps;
import utils.browsers.BrowserManager;

public class BaseTest {

    protected Steps steps = new Steps();

    @BeforeMethod
    public void openSitePage(){
        steps.loadPageWithCredentials("test", "30MkU21JyEOiKjyS");
    }

    @AfterTest
    public void close() {
        BrowserManager.closeBrowser();
        BrowserManager.quitSession();
    }

}
