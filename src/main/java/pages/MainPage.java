package pages;


import constants.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.Highliter;
import util.Waiter;

/**
 * Created by Dzmitry_Likhtarovich on 2/9/2018.
 */
public class MainPage extends AbstractPage {
    private static final By CREATE_NEW_LETTER_LOCATOR = By.className("mail-ComposeButton-Text");
    private static final By ACCOUNT_LOCATOR = By.className("mail-User-Name");

    public NewLatterPage createNewLetter() {
        WebElement createNewLetterButton = driver.findElement(CREATE_NEW_LETTER_LOCATOR);
        Highliter.highlightElement(createNewLetterButton);
        createNewLetterButton.click();
        return new NewLatterPage();
    }

    public boolean isUserNameCorrect(String userName) {
        Waiter.waitForVisibilityOfElement(Data.TIME, ACCOUNT_LOCATOR);
        return driver.findElement(ACCOUNT_LOCATOR).getText().equals(userName);
    }


}
