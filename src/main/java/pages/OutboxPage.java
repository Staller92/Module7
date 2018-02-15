package pages;

import constants.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.Highliter;
import util.Waiter;

import java.util.List;

public class OutboxPage extends AbstractPage {


    private final static By ALL_LETTERS_LOCATOR = By.xpath("//span[@class='mail-MessageSnippet-FromText']");
    private static final By MAIL_USER_ICON_LOCATOR = By.cssSelector(".mail-User-Name") ;
    private static final By LOG_OUT_BUTTON_LOCATOR = By.xpath("//div[@class='b-user-dropdown-content b-user-dropdown-content-with-exit']/div[last()]/a");

    public WebElement findLetterByDestinationInOutBox(String destination) {

        List<WebElement> letters = driver.findElements(ALL_LETTERS_LOCATOR);
        for (WebElement letter : letters) {
            if (letter.getText().equals(destination)) {
                return letter;
            }
        }
        return null;
    }

    public boolean isLetterExistInOutBox(String destination) {
        WebElement element = findLetterByDestinationInOutBox(destination);

        if (element != null) {
            Highliter.highlightElement(element);
            return true;
        }
        return false;
    }

    public LoginPage logOff() {
        Waiter.waitForVisibilityOfElement(Data.TIME, MAIL_USER_ICON_LOCATOR);
        driver.findElement(MAIL_USER_ICON_LOCATOR).click();
        driver.switchTo().activeElement();
        driver.findElement(LOG_OUT_BUTTON_LOCATOR).click();
        return new LoginPage();
    }
}