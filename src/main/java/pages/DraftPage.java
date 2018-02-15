package pages;

import constants.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.Acts;
import util.Highliter;
import util.Waiter;

import java.util.List;

public class DraftPage extends AbstractPage {

    private static final By OUT_BOX_LOCATOR = By.xpath("//a[@href='#sent']//span");
    private final static By ALL_LETTERS_LOCATOR = By.xpath(".//span[@class='mail-MessageSnippet-FromText']");
    private static final By TABLE_WITH_EMAILS_LOCATOR = By.xpath("//div[@class='mail-MessageSnippet-Content']");
    private static final By CHECKBOX_LOCATOR = By.xpath(".//span[@class='_nb-checkbox-flag _nb-checkbox-normal-flag']");
    private static final By DELETE_LETTER_LOCATOR = By.xpath("//span[@class='mail-Toolbar-Item-Text js-toolbar-item-title js-toolbar-item-title-delete']");


    public WebElement findLetterByDestinationInDrafts(String destination) {


        Waiter.waitForVisibilityOfElement(Data.TIME, ALL_LETTERS_LOCATOR);
        List<WebElement> letters = driver.findElements(ALL_LETTERS_LOCATOR);
        if (letters.size() == 0) {
            return null;
        }
        for (WebElement letter : letters) {
            if (letter.getText().equals(destination)) {
                return letter;
            }
        }
        return null;
    }

    public boolean isLetterExistInDrafts(String destination) {
        WebElement element = findLetterByDestinationInDrafts(destination);

        if (element != null) {
            Highliter.highlightElement(element);
            return true;
        }
        return false;
    }

    public NewLatterPage showLetterFromDrafts(String destination) {

        findLetterByDestinationInDrafts(destination).click();
        return new NewLatterPage();

    }

    public DraftPage shiftLetterToBin(String destination) {
        boolean isSelected = false;
        List<WebElement> rows = driver.findElements(TABLE_WITH_EMAILS_LOCATOR);
        WebElement bin = driver.findElement(DELETE_LETTER_LOCATOR);

        for (WebElement row : rows) {
            if (row.findElement(ALL_LETTERS_LOCATOR).getText().equals(destination)) {
                isSelected = true;
                row.findElement(CHECKBOX_LOCATOR).click();
            }

        }
        if (isSelected) {
            Acts.shift(driver.findElement(ALL_LETTERS_LOCATOR), bin);
        }

        return this;

    }

    public OutboxPage openOutBox() {

        driver.findElement(OUT_BOX_LOCATOR).click();
        return new OutboxPage();
    }


}
