package pageFactoty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class OutboxPage extends AbstractPage {


    private final static String ALL_LETTERS_LOCATOR = "//span[@class='mail-MessageSnippet-FromText']";
    private static final String MAIL_USER_ICON_LOCATOR = ".mail-User-Name";
    private static final String LOG_OUT_BUTTON_LOCATOR = "[data-metric='Выход']";

    @FindBy(xpath = ALL_LETTERS_LOCATOR)
    private List<WebElement> letters;

    @FindBy(css = MAIL_USER_ICON_LOCATOR)
    private WebElement userIcon;

    @FindBy(css = LOG_OUT_BUTTON_LOCATOR)
    private WebElement logOutButton;

    public OutboxPage(WebDriver driver) {
        super(driver);

    }

    public WebElement findLetterByDestinationInOutBox(String destination) {

        for (WebElement letter : letters) {
            if (letter.getText().equals(destination)) {
                return letter;
            }
        }
        return null;
    }

    public boolean isLetterExistInOutBox(String destination) {

        if (findLetterByDestinationInOutBox(destination) != null) {
            return true;
        }
        return false;
    }

    public LoginPage logOff() {
        userIcon.click();
        driver.switchTo().activeElement();
        logOutButton.click();
        return new LoginPage(driver);
    }
}