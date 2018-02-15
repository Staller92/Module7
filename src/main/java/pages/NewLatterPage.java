package pages;

import constants.Data;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import util.Highliter;
import util.Waiter;


public class NewLatterPage extends AbstractPage {

    private static final By DESTINATION_LETTER_LOCATOR = By.xpath(".//div[@name='to']");
    private static final By SUBJECT_LETTER_LOCATOR = By.xpath(".//input[@name='subj']");
    private static final By CONTENT_LETTER_LOCATOR = By.xpath("//div[@role='textbox']");
    private static final By CONTENT_LETTER_IN_DRAFTS_LOCATOR = By.xpath("//div[@role='textbox']/div[1]");
    private static final By SEND_BUTTON_LOCATOR = By.cssSelector("._nb-action-button");
    private static final By DRAFTS_BUTTON_LOCATOR = By.xpath(".//a[@href='#draft']//span");



    public NewLatterPage fillDestinationField(String destination) {
        driver.findElement(DESTINATION_LETTER_LOCATOR).clear();
        driver.findElement(DESTINATION_LETTER_LOCATOR).sendKeys(destination);
        return this;
    }

    public NewLatterPage fillThemeField(String theme) {
        driver.findElement(SUBJECT_LETTER_LOCATOR).clear();
        driver.findElement(SUBJECT_LETTER_LOCATOR).sendKeys(theme);
        return this;
    }

    public NewLatterPage fillContentField(String content) {
        driver.findElement(CONTENT_LETTER_LOCATOR).clear();
        driver.findElement(CONTENT_LETTER_LOCATOR).sendKeys(content);
        return this;
    }

    public InboxPage sendEmail() {

        WebElement sendButton = driver.findElement(SEND_BUTTON_LOCATOR);
        Highliter.highlightElement(sendButton);
        sendButton.click();
        return new InboxPage();
    }

    public DraftPage openDrafts() {
        Waiter.waitForVisibilityOfElement(Data.TIME,DESTINATION_LETTER_LOCATOR);
        WebElement drafts = driver.findElement(DRAFTS_BUTTON_LOCATOR);
        Highliter.highlightElement(drafts);
        drafts.click();
        driver.switchTo().activeElement().click();

        return new DraftPage();
    }

    public boolean isLetterDestinationFieldCorrect(String destination) {

        return driver.findElement(DESTINATION_LETTER_LOCATOR).getText().equals(destination);

    }

    public boolean isLetterThemeFieldCorrect(String theme) {

        return driver.findElement(SUBJECT_LETTER_LOCATOR).getAttribute("value").equals(theme);
    }

    public boolean isLetterContentFieldCorrect(String content) {
        return driver.findElement(CONTENT_LETTER_IN_DRAFTS_LOCATOR).getText().equals(content);
    }
}
