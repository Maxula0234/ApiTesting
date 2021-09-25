import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.safari.SafariDriver;
import ui.pages.Catalog;
import ui.pages.HomePage;

import java.io.IOException;

public class UiTests {
    HomePage homePage = new HomePage(new SafariDriver());
    Catalog catalog = new Catalog(new SafariDriver());
    private final String URL = "https://www.luxoft-training.ru";


    @Test
    void projectIsConfigured() throws IOException {
        homePage.goTo();
        homePage.clickCatalog();
//        catalog.clickSaveCourses();
    }
}
