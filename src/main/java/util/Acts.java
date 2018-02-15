package util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Dzmitry_Likhtarovich on 2/13/2018.
 */
public class Acts {

    public static void mouseClick(WebElement element) {
        new Actions(WebDriverSingleton.getWebDriverInstance()).click(element).build().perform();
    }

    public static void shift(WebElement startElement, WebElement endElement) {
        new Actions(WebDriverSingleton.getWebDriverInstance())
                .clickAndHold(startElement).moveToElement(startElement, 100, 100)
                .moveToElement(endElement).release().build().perform();
    }
}

