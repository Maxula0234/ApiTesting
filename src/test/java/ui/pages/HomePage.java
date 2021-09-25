package ui.pages;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static io.restassured.RestAssured.given;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

@Slf4j
public class HomePage {

    private final String URL = "https://www.luxoft-training.ru";
    By catalog = new By.ByXPath("//*[@id=\"header\"]/div[1]/div/div[1]/nav/ul/li[1]/a");
    By saveCatalog = new By.ByLinkText("Скачать каталог");
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage() {
        System.setProperty("webdriver.chrome.driver", "/Users/maksimhorovinkin/Downloads/chromedriver 2");

        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        this.wait = new WebDriverWait(driver, 30);
    }

    public void goTo() {
        driver.get(URL);
    }

    public void clickCatalog() {
        WebElement element = driver.findElement(catalog);
        element.click();
    }

    public void quitDriver() {
        driver.quit();
    }

    public Response clickSaveCoursesAndGetApi() throws IOException, InterruptedException {
        WebElement save = wait.until(visibilityOfElementLocated(saveCatalog));
        String href = save.getAttribute("href");

        return given().contentType("application/pdf").baseUri(href).get();
    }

    public void savePdf(Response response, String pathToSave) throws IOException {
        OutputStream outStream = null;
        File outputFile = new File(pathToSave);

        try {
            outStream = new FileOutputStream(outputFile);
            outStream.write(response.asByteArray());
        } catch (Exception e) {
            System.out.println("Error writing file " + outputFile.getAbsolutePath());
        } finally {
            if (outStream != null) {
                outStream.close();
            }
        }
    }
}
