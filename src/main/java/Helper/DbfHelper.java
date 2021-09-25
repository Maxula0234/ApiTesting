package Helper;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class DbfHelper {
    public String readPdf(String absolutPath) throws IOException {
        File filePdf = new File(absolutPath);

        PDDocument pddDocument = PDDocument.load(filePdf);
        PDFTextStripper textStripper = new PDFTextStripper();
        String text = textStripper.getText(pddDocument);
        return text;
    }

}
