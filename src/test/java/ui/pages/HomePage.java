package ui.pages;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static io.restassured.RestAssured.given;

@Slf4j
public class HomePage extends BasePage {
    By catalog = new By.ByXPath("//*[@id=\"header\"]/div[1]/div/div[1]/nav/ul/li[1]/a");
    By saveCatalog = new By.ByLinkText("Скачать каталог");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void openHomePage() {
        driver.get(BASE_URL);
        waitVisib(catalog);
    }

    public void clickCatalog() {
        waitAndClick(catalog);
    }

    public Response clickSaveCoursesAndGetApi() throws IOException, InterruptedException {
        WebElement save = waitVisib(saveCatalog);
        String href = save.getAttribute("href");

        return given().contentType("application/pdf").baseUri(href).get();
    }

}
