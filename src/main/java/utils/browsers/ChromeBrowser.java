package utils.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowser extends BaseBrowser{

    ChromeBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = setupChromeOptions();
        driver = new ChromeDriver(options);
    }

    private ChromeOptions setupChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--allow-file-access-from-files");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("--allow-file-access");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--test-type");
        return options;
    }

    private ChromeOptions doHeadless(ChromeOptions options) {
        String osVersion = System.getProperty("os.version");
        System.out.println("OS VERSION: " + osVersion);
        if (!osVersion.equalsIgnoreCase("5.4.0-53-generic")) {
            options.addArguments("--headless");
        }
        return options;
    }
}
