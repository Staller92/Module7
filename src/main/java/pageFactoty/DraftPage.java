package pageFactoty;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



import java.util.List;

public class DraftPage extends AbstractPage {

    private static final String OUT_BOX_LOCATOR = "//a[@href='#sent']//span";
    private static final String ALL_LETTERS_LOCATOR = ".//span[@class='mail-MessageSnippet-FromText']";
    private static final String TABLE_WITH_EMAILS_LOCATOR = "//div[@class='mail-MessageSnippet-Content']";


    @FindBy(xpath = ALL_LETTERS_LOCATOR)
    private List<WebElement> letters;

    @FindBy(xpath = TABLE_WITH_EMAILS_LOCATOR)
    private List<WebElement> rows;

    @FindBy(xpath = OUT_BOX_LOCATOR)
    private WebElement outBoxButton;

    public DraftPage(WebDriver driver) {
        super(driver);
    }

    public WebElement findLetterByDestinationInDrafts(String destination) {

        for (WebElement letter : letters) {
            if (letter.getText().equals(destination)) {
                return letter;
            }
        }
        return null;
    }

    public boolean isLetterExistInDrafts(String destination) {

        if (findLetterByDestinationInDrafts(destination) != null) {
            return true;
        }
        return false;
    }

    public NewLatterPage showLetterFromDrafts(String destination) {

        findLetterByDestinationInDrafts(destination).click();
        return new NewLatterPage(driver);

    }


    public OutboxPage openOutBox() {

        outBoxButton.click();
        return new OutboxPage(driver);
    }


}
