package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

/**
 * Created by Dzmitry_Likhtarovich on 2/13/2018.
 */
public class JSExecutor {

    public static void clickElement(String locator) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) WebDriverSingleton.getWebDriverInstance();
        javascriptExecutor.executeScript("$('" +locator+"').click()");
    }

    public static WebElement findElement(String locator) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) WebDriverSingleton.getWebDriverInstance();
        return (WebElement)javascriptExecutor.executeScript("var el = document.querySelector('" +locator+"'); return el;");
    }

}
