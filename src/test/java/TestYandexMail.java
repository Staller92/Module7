
import constants.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import util.Screenshoter;
import util.WebDriverSingleton;

/**
 * Created by Dzmitry_Likhtarovich on 2/12/2018.
 */
public class TestYandexMail {

    private LoginPage loginPage;
    private MainPage mainPage;
    private NewLatterPage newLatterPage;
    private DraftPage draftPage;
    private InboxPage inboxPage;
    private OutboxPage outboxPage;
    private SoftAssert softAssert;

    private WebDriver driver;

    @BeforeSuite
    public void beforeClass() {
        driver = WebDriverSingleton.getWebDriverInstance();
    }


    @AfterSuite
    public void afterClass() {

        WebDriverSingleton.getWebDriverInstance().close();

    }

    @Test
    public void testLogin() {

        driver.get(Data.URL);
        loginPage = new LoginPage();
        mainPage = loginPage.loginAs(Data.LOGIN, Data.PASSWORD);
        Screenshoter.takeScreenshot();
        Assert.assertTrue(mainPage.isUserNameCorrect(Data.LOGIN), "login is not successful");

    }

    @Test(dependsOnMethods = "testLogin")
    public void testCreateNewMailAndCheckDrafts() {

        newLatterPage = mainPage.createNewLetter();
        newLatterPage.fillDestinationField(Data.ADDRESS);
        newLatterPage.fillThemeField(Data.THEME);
        newLatterPage.fillContentField(Data.CONTENT);
        draftPage = newLatterPage.openDrafts();

        WebDriverSingleton.getWebDriverInstance().navigate().refresh();
        Screenshoter.takeScreenshot();
        Assert.assertTrue(draftPage.isLetterExistInDrafts(Data.ADDRESS), "Letter is not exist");

    }

    @Test(dependsOnMethods = "testCreateNewMailAndCheckDrafts")
    public void testCheckEmailFromDrafts() {

        newLatterPage = draftPage.showLetterFromDrafts(Data.ADDRESS);
        Screenshoter.takeScreenshot();
        softAssert = new SoftAssert();
        softAssert.assertTrue(newLatterPage.isLetterDestinationFieldCorrect(Data.ADDRESS), "Address is not the same");
        softAssert.assertTrue(newLatterPage.isLetterThemeFieldCorrect(Data.THEME), "Theme is not the same");
        softAssert.assertTrue(newLatterPage.isLetterContentFieldCorrect(Data.CONTENT), "Content is not the same");
        softAssert.assertAll();

    }

    @Test(dependsOnMethods = "testCheckEmailFromDrafts")
    public void testSendEmailAndCheckMailDisappearedFromDrafts() {

        inboxPage = newLatterPage.sendEmail();
        draftPage = inboxPage.openDrafts();
        WebDriverSingleton.getWebDriverInstance().navigate().refresh();
        Screenshoter.takeScreenshot();
        Assert.assertTrue(draftPage.isLetterExistInDrafts(Data.ADDRESS));

    }

    @Test(dependsOnMethods = "testSendEmailAndCheckMailDisappearedFromDrafts")
    public void testCheckEmailInOutBox() {

        outboxPage = draftPage.openOutBox();
        Screenshoter.takeScreenshot();
        Assert.assertTrue(outboxPage.isLetterExistInOutBox(Data.ADDRESS), "Mail didn't appear in outbox");

    }

    @Test(dependsOnMethods = "testCheckEmailInOutBox")
    public void testLogOff() {

        loginPage = outboxPage.logOff();
        Screenshoter.takeScreenshot();
        Assert.assertTrue(loginPage.isElementPresent(By.name("login")));

    }
}