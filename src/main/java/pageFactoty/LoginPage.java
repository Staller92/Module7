package pageFactoty;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Created by Dzmitry_Likhtarovich on 2/9/2018.
 */
public class LoginPage extends AbstractPage {

    private static final String USERNAME_INPUT_LOCATOR = "login";
    private static final String PASSWORD_LOCATOR = "passwd";
    private static final String ENTRANCE_BUTTON_LOCATOR = "//button[@class='button auth__button domik3__auth-button button_theme_bordergray button_size_m i-bem button_js_inited auth__button_color_yellow']";

    @FindBy(name = USERNAME_INPUT_LOCATOR)
    private WebElement userName;

    @FindBy(name = PASSWORD_LOCATOR)
    private WebElement passwordField;

    @FindBy(xpath = ENTRANCE_BUTTON_LOCATOR)
    private WebElement entanceButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public LoginPage inputLogin(String login) {
        userName.sendKeys(login);
        return this;
    }


    public LoginPage inputPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public MainPage pressEnter() {

        highlightElement(entanceButton);
        entanceButton.click();
        return new MainPage(driver);
    }

    public MainPage login(String login, String password) {
        inputLogin(login);
        inputPassword(password);
        pressEnter();
        return new MainPage(driver);
    }
}
