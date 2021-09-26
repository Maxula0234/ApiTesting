package ui;

import io.restassured.response.Response;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Utils {

    /**
     * Сохраним файл на машину
     * @param response ответ от сервиса,с него возьмем данные
     * @param pathToSave путь для сохраниения
     * @throws IOException
     */
    public static void savePdf(Response response, String pathToSave) throws IOException {
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
