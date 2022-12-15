package utils.browsers;

import org.apache.logging.log4j.Logger;
import settings.Configs;
import utils.logger.TestLogger;

public class BrowserManager {

    protected static final Logger logger = TestLogger.logger;
    private Configs tafSetting = Configs.getWebConfigs();
    private static BaseBrowser browser;

    public static BaseBrowser getBrowser() {
        if (browser == null) {
            new BrowserManager().initDriver();
        }
        return browser;
    }

    private void initDriver() {
        if (tafSetting.isChrome()) {
            browser = new ChromeBrowser();
        }
    }

    public static void quitSession() {
        getBrowser().getDriver().quit();
        browser = null;
    }

    public static void closeBrowser() {
        getBrowser().getDriver().close();
    }
}
