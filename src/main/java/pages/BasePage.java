package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.browsers.BrowserManager;

import java.time.Duration;

public abstract class BasePage {

    public WebDriver driver = BrowserManager.getBrowser().getDriver();
    public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    public void clickElement(String elementXpath) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
        driver.findElement(By.xpath(elementXpath)).click();
    }
}
