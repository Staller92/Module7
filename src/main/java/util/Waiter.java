package util;



import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Dzmitry_Likhtarovich on 2/12/2018.
 */
public class Waiter {

    public static void waitForVisibilityOfElement(int seconds, By locator) {
        new WebDriverWait(WebDriverSingleton.getWebDriverInstance(), seconds).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static void waitForTitleCorrect(int seconds,String title) {
        new WebDriverWait(WebDriverSingleton.getWebDriverInstance(), seconds).until(ExpectedConditions.titleIs(title));
    }
}
