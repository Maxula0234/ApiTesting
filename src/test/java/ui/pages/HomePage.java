package ui.pages;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static io.restassured.RestAssured.given;

@Slf4j
public class HomePage extends BasePage {
    @FindBy(xpath = "//*[@id=\"header\"]/div[1]/div/div[1]/nav/ul/li[1]/a")
    private WebElement catalog;
    @FindBy(linkText = "Скачать каталог")
    private WebElement saveCatalog;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void openHomePage() {
        driver.get(BASE_URL);
        catalog.isDisplayed();
    }

    public void clickCatalog() {
        catalog.click();
    }

    public Response clickSaveCoursesAndGetApi() throws IOException, InterruptedException {
        String href = saveCatalog.getAttribute("href");
        return given().contentType("application/pdf").baseUri(href).get();
    }

}
