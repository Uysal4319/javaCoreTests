import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class RemoveWatermark {
	public static void main(String[] args) {
		String inputPdf = "input.pdf";
		String outputPdf = "src/main/resources/output.pdf";
		
		try {
			PdfReader reader = new PdfReader(inputPdf);
			int pageCount = reader.getNumberOfPages();
			
			PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(outputPdf));
			PdfContentByte content;
			
			for (int i = 1; i <= pageCount; i++) {
				content = stamper.getOverContent(i);
				System.out.println();
				content.setColorFill(BaseColor.WHITE); 
				content.rectangle(0, 0, 595, 30); 
				content.fill();
				
				
				PdfDictionary pageDict = reader.getPageN(i);
				PdfArray annots = pageDict.getAsArray(PdfName.ANNOTS);
				
				if (annots != null) {
					for (int j = 0; j < annots.size(); j++) {
						PdfObject annot = annots.getPdfObject(j);
						System.out.println(annot.isIndirect());
						annots.remove(j);
						j--;
						
					}
				}
			}
			
			stamper.close();
			reader.close();
		} catch (IOException |
				 DocumentException e) {
			e.printStackTrace();
		}
	}
}
