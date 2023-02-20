package generators;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class PDFWatermarkParse {
	
	public static void main(String[] args) throws IOException {
		File file = new File("src/main/resources/sodapdf-watermarked.pdf");
		DataHandler dh = new DataHandler(new FileDataSource(file));
		InputStream inputStream = dh.getInputStream();
		PDDocument document = PDDocument.load(inputStream);
		PDFTextStripper stripper = new PDFTextStripper();
		String pageText = stripper.getText(document);
		if (pageText.contains("igranlidir")) {
			System.out.println("sayfa 3 filigran içeriyor");
		}
		if (pageText.contains("ertu tarafından")) {
			System.out.println("sayfa 4 filigran içeriyor");
		}
		document.close();
	}
}
