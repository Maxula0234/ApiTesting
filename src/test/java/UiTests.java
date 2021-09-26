import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import ui.Utils;
import ui.pages.HomePage;
import ui.utils.Helper.DbfHelper;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UiTests {
    static HomePage homePage = new HomePage();
    private final String URL = "https://www.luxoft-training.ru";
    DbfHelper dbfHelper = new DbfHelper();

    @AfterAll
    public static void terDown() {
        homePage.quitDriver();
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
