import constants.Data;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DraftPage;
import pages.LoginPage;
import pages.NewLatterPage;
import util.WebDriverSingleton;

/**
 * Created by Dzmitry_Likhtarovich on 2/14/2018.
 */
public class TestShiftDraftToBin {

    private WebDriver driver;
    private LoginPage loginPage;
    private NewLatterPage newLatterPage;
    private DraftPage draftPage;

  //  @BeforeClass
  //  public void beforeClass() {
 //       driver = WebDriverSingleton.getWebDriverInstance();
 //   }


    @AfterClass
    public void afterClass() {

        WebDriverSingleton.getWebDriverInstance().close();

    }

    @Test
    public void testShiftLetterToBin() {
        driver.get(Data.URL);
        loginPage = new LoginPage();
        newLatterPage = loginPage.loginAs(Data.LOGIN, Data.PASSWORD).createNewLetter();
        newLatterPage.fillDestinationField(Data.ADDRESS);
        draftPage = newLatterPage.fillThemeField(Data.THEME).openDrafts();
        Assert.assertTrue(draftPage.isLetterExistInDrafts(Data.ADDRESS));
        draftPage.shiftLetterToBin(Data.ADDRESS);
        Assert.assertFalse(draftPage.isLetterExistInDrafts(Data.ADDRESS));
    }
}
