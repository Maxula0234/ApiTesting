package ui.pages;


import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Catalog {

    private final String URL = "https://www.luxoft-training.ru/training/katalog_kursov/";
    private WebDriver driver;
    private WebDriverWait wait;

    public Catalog(WebDriver webDriver) {
        this.driver = webDriver;
        driver.manage().addCookie(new Cookie("key", "value"));
        driver.manage().window().maximize();
        this.wait = new WebDriverWait(driver, 15);
    }

    public void goTo() {
        driver.get(URL);
    }

}
