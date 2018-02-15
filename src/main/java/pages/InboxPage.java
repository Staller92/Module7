package pages;

import constants.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.Highliter;
import util.Waiter;

public class InboxPage extends AbstractPage {
    private static final By DRAFTS_BUTTON_LOCATOR = By.xpath(".//a[@href='#draft']//span");


    public DraftPage openDrafts() {
        Waiter.waitForVisibilityOfElement(Data.TIME, DRAFTS_BUTTON_LOCATOR);
        WebElement draftsButton = driver.findElement(DRAFTS_BUTTON_LOCATOR);
        Highliter.highlightElement(draftsButton);
        draftsButton.click();
        return new DraftPage();
    }
}
