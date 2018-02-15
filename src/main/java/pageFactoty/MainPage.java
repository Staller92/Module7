package pageFactoty;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Created by Dzmitry_Likhtarovich on 2/9/2018.
 */
public class MainPage extends AbstractPage {

    private static final String CREATE_NEW_LETTER_LOCATOR = "mail-ComposeButton-Text";
    private static final String ACCOUNT_LOCATOR = "mail-User-Name";

    @FindBy(className = CREATE_NEW_LETTER_LOCATOR)
    private WebElement createNewLetterButton;

    @FindBy(className = ACCOUNT_LOCATOR)
    private WebElement accountButton;


    public MainPage(WebDriver driver) {
        super(driver);

    }
    public NewLatterPage createNewLetter() {

        highlightElement(createNewLetterButton);
        createNewLetterButton.click();
        return new NewLatterPage(driver);
    }



    public boolean isUserNameCorrect(String userName) {
             return accountButton.getText().equals(userName);
    }


}
