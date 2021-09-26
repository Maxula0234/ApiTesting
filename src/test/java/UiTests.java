import com.google.common.io.Resources;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.Utils;
import ui.pages.HomePage;
import ui.utils.Helper.DbfHelper;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UiTests {
    public HomePage homePage;
    public DbfHelper dbfHelper = new DbfHelper();
    public WebDriverWait wait;
    private WebDriver driver;

    @BeforeAll
    public static void setChromBinaries() {
        System.setProperty("webdriver.chrome.driver", Resources.getResource("chromedriver").getPath());
    }

    @BeforeEach
    public void setDriver() {
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        this.wait = new WebDriverWait(driver, 5);
        homePage = new HomePage(driver, wait);
    }

    @AfterEach
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void testUnloadPdf() throws IOException, InterruptedException {
        String expectedValue = "Шаблоны проектирования приложений масштаба предприятия";
        String pathToSave = "/Users/maksimhorovinkin/Downloads/newFile.pdf";

        homePage.openHomePage();
        homePage.clickCatalog();
        Response response = homePage.clickSaveCoursesAndGetApi();
        Utils.savePdf(response, pathToSave);
        String textPdf = dbfHelper.readPdf(pathToSave);

        assertTrue(textPdf.contains(expectedValue));
    }
}
