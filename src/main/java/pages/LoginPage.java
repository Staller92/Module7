package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.Acts;
import util.Highliter;

/**
 * Created by Dzmitry_Likhtarovich on 2/9/2018.
 */
public class LoginPage extends AbstractPage {

    private static final By USERNAME_INPUT_LOCATOR = By.name("login");
    private static final By PASSWORD_LOCATOR = By.name("passwd");
    private static final By ENTRANCE_BUTTON_LOCATOR = By.xpath("html/body//button");


    public LoginPage inputLogin(String login) {
        driver.findElement(USERNAME_INPUT_LOCATOR).sendKeys(login);
        return this;
    }

    public LoginPage inputPassword(String password) {
        driver.findElement(PASSWORD_LOCATOR).sendKeys(password);
        return this;
    }

    public MainPage submit() {
        WebElement entranceButton = driver.findElement(ENTRANCE_BUTTON_LOCATOR);
        Highliter.highlightElement(entranceButton);
        Acts.mouseClick(entranceButton);
        return new MainPage();
    }

    public MainPage loginAs(String login, String password) {
        inputLogin(login);
        inputPassword(password);
        submit();
        return new MainPage();
    }
}
