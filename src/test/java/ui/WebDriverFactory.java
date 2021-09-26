package ui;

import Constant.WebDriverName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

    public static WebDriver getWebDriver(WebDriverName webDriverName) {
        switch (webDriverName) {
            case CHROME: {
                return new ChromeDriver();
            }
            case SAFARI: {
                break;
            }
        }
        return null;
    }
}
