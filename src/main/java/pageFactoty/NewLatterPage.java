package pageFactoty;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class NewLatterPage extends AbstractPage {
    private static final String DESTINATION_LETTER_LOCATOR = ".//div[@name='to']";
    private static final String SUBJECT_LETTER_LOCATOR = ".//input[@name='subj']";
    private static final String CONTENT_LETTER_LOCATOR = ".cke_show_borders[role='textbox']";
    private static final String SEND_BUTTON_LOCATOR = "._nb-action-button";
    private static final String DRAFTS_BUTTON_LOCATOR = ".//a[@href='#draft']//span";

    @FindBy(xpath = DESTINATION_LETTER_LOCATOR)
    private WebElement destinationField;

    @FindBy(xpath = SUBJECT_LETTER_LOCATOR)
    private WebElement subjectField;

    @FindBy(css = CONTENT_LETTER_LOCATOR)
    private WebElement contentFiled;

    @FindBy(css = SEND_BUTTON_LOCATOR)
    private WebElement sendButton;

    @FindBy(xpath = DRAFTS_BUTTON_LOCATOR)
    private WebElement draftsButton;

    public NewLatterPage(WebDriver driver) {
        super(driver);

    }

    public NewLatterPage fillDestinationField(String destination) {
        destinationField.clear();
        destinationField.sendKeys(destination);
        return this;
    }

    public NewLatterPage fillThemeField(String theme) {
        subjectField.clear();
        subjectField.sendKeys(theme);
        return this;
    }

    public NewLatterPage fillContentField(String content) {
        contentFiled.clear();
        contentFiled.sendKeys(content);
        return this;
    }

    public InboxPage sendEmail() {


        sendButton.click();
        return new InboxPage(driver);
    }

    public DraftPage openDrafts() {


        draftsButton.click();
        driver.switchTo().activeElement().click();
        return new DraftPage(driver);
    }

    public boolean isLetterDestinationFieldCorrect(String destination) {

        return destinationField.getText().equals(destination);
    }

    public boolean isLetterThemeFieldCorrect(String theme) {

        return subjectField.getAttribute("value").equals(theme);
    }

    public boolean isLetterContentFieldCorrect(String content) {

        return contentFiled.getText().equals(content);
    }
}
