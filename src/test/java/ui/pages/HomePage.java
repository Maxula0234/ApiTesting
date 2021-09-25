package ui.pages;

import com.sun.jdi.PrimitiveValue;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.util.ElementFilter;

public class HomePage {

    private final String URL = "https://www.luxoft-training.ru";
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver webDriver) {
        this.driver = webDriver;
        driver.manage().addCookie(new Cookie("key", "value"));
        driver.manage().window().maximize();
        this.wait = new WebDriverWait(driver,20);
    }

    public void goTo() {
        driver.get(URL);
        driver.findElement(new By.ByXPath("/html/body/div[6]/div/a")).click();
    }

    public void clickCatalog(){
        WebElement element = driver.findElement(new By.ByXPath("//*[@id=\"header\"]/div[1]/div/div[1]/nav/ul/li[1]/a"));
        element.click();
    }

}
