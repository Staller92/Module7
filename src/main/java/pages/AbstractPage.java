package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import util.WebDriverSingleton;

/**
 * Created by Dzmitry_Likhtarovich on 2/9/2018.
 */
public abstract class AbstractPage {

    protected  WebDriver driver;

    protected AbstractPage() {
        this.driver = WebDriverSingleton.getWebDriverInstance();
    }

    public WebDriver getDriver() {
        return driver;
    }
    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }
}
