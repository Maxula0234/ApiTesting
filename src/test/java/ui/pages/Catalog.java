package ui.pages;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.BasicHttpContext;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

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

    public void clickSaveCourses() throws IOException {
        String attribute = driver.findElement(new By.ByLinkText("Скачать каталог")).getAttribute("href");

        String downloadLink = "https://www.luxoft-training.ru/" + attribute;
        //Set file to save
        File fileToSave = new File("/Users/maksimhorovinkin/Downloads/file.pdf");

//Download file using default org.apache.http client
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(downloadLink);
        HttpResponse response = httpClient.execute(httpGet, new BasicHttpContext());

//Save file on disk
        copyInputStreamToFile(response.getEntity().getContent(), fileToSave);

    }
}
