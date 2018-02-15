package util;


import constants.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {
    private static WebDriver driver;

    private WebDriverSingleton() {
    }

    public static WebDriver getWebDriverInstance() {
        if (driver != null) {
            return driver;
        }
        return driver = init();
    }

    private static WebDriver init() {
 //   System.setProperty(Data.CHROME_DRIVER, System.getProperty("user.dir") + Data.PATH_TO_CHROME_DRIVER);
      //  driver = new ChromeDriver();


        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");


        try {
            driver = new RemoteWebDriver(new URL("http://10.6.218.14:5557/wd/hub"), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().pageLoadTimeout(Data.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Data.IMPLICITLY_WAIT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }


}
