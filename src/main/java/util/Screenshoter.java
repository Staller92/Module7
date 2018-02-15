package util;

import constants.Data;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

/**
 * Created by Dzmitry_Likhtarovich on 2/13/2018.
 */
public class Screenshoter {

    public static void takeScreenshot() {

        WebDriver driver = WebDriverSingleton.getWebDriverInstance();
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String screenshotName = Data.SCREENSHOTS_NAME_TPL + System.nanoTime();
            File copy = new File(screenshotName + ".png");
        try {
            FileUtils.copyFile(screenshot, copy);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

