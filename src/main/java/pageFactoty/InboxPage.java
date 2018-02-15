package pageFactoty;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class InboxPage extends AbstractPage {
    private static final String DRAFTS_BUTTON_LOCATOR = ".//a[@href='#draft']//span";

    @FindBy(xpath = DRAFTS_BUTTON_LOCATOR)
    private WebElement draftsButton;

    public InboxPage(WebDriver driver) {
        super(driver);
    }

    public DraftPage openDrafts() {

        highlightElement(draftsButton);
        draftsButton.click();
        return new DraftPage(driver);
    }
}
