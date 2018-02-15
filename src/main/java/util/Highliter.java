package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

/**
 * Created by Dzmitry_Likhtarovich on 2/13/2018.
 */
public class Highliter {

    public static void highlightElement(WebElement element) {

        String bg = element.getCssValue("backgroundColor");
        JavascriptExecutor js = ((JavascriptExecutor) WebDriverSingleton.getWebDriverInstance());
        js.executeScript("arguments[0].style.backgroundColor = '" + "yellow" + "'", element);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        js.executeScript("arguments[0].style.backgroundColor = '" + bg + "'", element);


    }
}
