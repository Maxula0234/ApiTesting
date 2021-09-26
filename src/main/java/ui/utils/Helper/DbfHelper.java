package ui.utils.Helper;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class DbfHelper {

    /**
     * Вычитаем пдф из каталога (используя библиотеку преобразуем в String)
     * @param absolutPath путь до файла
     * @return
     * @throws IOException
     */
    public String readPdf(String absolutPath) throws IOException {
        File filePdf = new File(absolutPath);

        PDDocument pddDocument = PDDocument.load(filePdf);
        PDFTextStripper textStripper = new PDFTextStripper();
        String text = textStripper.getText(pddDocument);
        return text;
    }

}
