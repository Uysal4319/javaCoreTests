package generators.pdf;

import org.apache.commons.io.FileUtils;
import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdfparser.PDFStreamParser;
import org.apache.pdfbox.pdfwriter.ContentStreamWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.util.PDFOperator;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.List;
import java.util.Map;

public class PDFExporter implements Serializable {
	private static final long serialVersionUID = 1L;
//	private static final String ENCODING = "ISO-8859-9";
	private static final String ENCODING = "UTF-8";
	private static final Logger logger = LoggerFactory.getLogger(PDFExporter.class);
	private static FopFactory fopFactory;
	private static TransformerFactory xslTransformerFactory;
	
	public static void main(String[] args) {
		PDFExporter editor = new PDFExporter();
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
//			Document xmlDoc = new Document();
//			Element rootElement = new Element("record");
//			xmlDoc.setRootElement(rootElement);
			
			Document xmlDoc = editor.fillReplacementMap();
			editor.exportPdfFromFop("src/main/java/generators/pdf", "template.xsl", xmlDoc, bos);
			bos.close();
			FileUtils.writeByteArrayToFile(new File("src/main/java/generators/pdf/out.pdf"), bos.toByteArray());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void exportPdfFromFop(String confFolder, String xslFile, Document xmlDoc, OutputStream os) {
		logger.info("conf folder=" + confFolder + " xsl file=" + xslFile);
		initFopFactory();
		String xmlRecordOut = writeElement(xmlDoc);
		logger.info("xml doc=" + xmlRecordOut);
		Fop fop;
		try {
			fop = fopFactory.newFop(MimeConstants.MIME_PDF, os);
		} catch (FOPException e) {
			throw new RuntimeException(e);
		}
		String xslFilePath = "src/main/java/generators/pdf/template.xsl";
		logger.info("xsl file path=" + xslFilePath);
		
		StreamSource streamSourceXsl = new StreamSource(xslFilePath);
		try {
			Transformer transformer = xslTransformerFactory.newTransformer(streamSourceXsl);
			Source xmlSource = new StreamSource(new StringReader(xmlRecordOut));
			Result res = new SAXResult(fop.getDefaultHandler());
			transformer.transform(xmlSource, res);
			
		} catch (Exception e) {
			logger.error("Error generating pdf doc", e);
		}
	}
	
	private void initFopFactory() {
		if (fopFactory == null) {
			try {
				String confPath = "src/main/java/generators/pdf/fop.xconf";
				logger.info("conf path=" + confPath);
				fopFactory = FopFactory.newInstance(new File(confPath));
			} catch (SAXException | IOException e) {
				throw new RuntimeException(e);
			}
		}
		if (xslTransformerFactory == null) {
			xslTransformerFactory = TransformerFactory.newInstance();
		}
	}
	
	public String writeElement(Document doc) {
		XMLOutputter outp = new XMLOutputter(Format.getPrettyFormat());
		StringWriter strWriter = new StringWriter(2048);
		try {
			outp.output(doc, strWriter);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				strWriter.close();
			} catch (IOException e) {
				logger.error("error while strWriter close.");
			}
		}
		return strWriter.toString();
	}
	
	private Document fillReplacementMap() {
		Document xmlDoc = new Document();
		Element rootElement = new Element("record");
		xmlDoc.setRootElement(rootElement);
		rootElement.addContent(new Element("department").setText("Software"));
		rootElement.addContent(new Element("name").setText("Ertu"));
		rootElement.addContent(new Element("surname").setText("Uysal"));
		rootElement.addContent(new Element("office").setText("İstanbul"));
		rootElement.addContent(new Element("fatherName").setText("babaisimi"));
		rootElement.addContent(new Element("phone").setText("5025024145"));
		rootElement.addContent(new Element("title").setText("software engineer"));
		rootElement.addContent(new Element("birthYear").setText("1995"));
		rootElement.addContent(new Element("birthPlace").setText("Samsun"));
		rootElement.addContent(new Element("expectedStartDate").setText("10.10.2022"));
		rootElement.addContent(new Element("startDate").setText("15.04.2022"));
		rootElement.addContent(new Element("workplaces").setText("harbiSoft"));
		
		Element elementMsisdnList = new Element("jobList");
		elementMsisdnList.addContent(new Element("job").setAttribute("col", String.valueOf(1)).setText("software engineer"));
		elementMsisdnList.addContent(new Element("job").setAttribute("col", String.valueOf(2)).setText("software developer"));
		elementMsisdnList.addContent(new Element("job").setAttribute("col", String.valueOf(3)).setText("full stack developer"));
		
		rootElement.addContent(elementMsisdnList);
		
		return xmlDoc;
	}
	
	public void replaceText(String inputFile, OutputStream out, Map<String, String> replaceMap) {
		PDDocument doc = null;
		try {
			doc = PDDocument.load(inputFile);
			List<PDPage> pages = doc.getDocumentCatalog().getAllPages();
			for (int i = 0; i < pages.size(); i++) {
				PDPage page = pages.get(i);
				PDStream contents = page.getContents();
				PDFStreamParser parser = new PDFStreamParser(contents.getStream());
				parser.parse();
				List<Object> tokens = parser.getTokens();
				for (int j = 0; j < tokens.size(); j++) {
					Object next = tokens.get(j);
					if (next instanceof PDFOperator) {
						PDFOperator op = (PDFOperator) next;
						if (op.getOperation().equals("TJ")) {
							COSArray previous = (COSArray) tokens.get(j - 1);
							
							for (int k = 0; k < previous.size(); k++) {
								Object arrElement = previous.getObject(k);
								
								if (arrElement instanceof COSString) {
									COSString cosString = (COSString) arrElement;
									String string = cosString.getString();
									
									boolean found = false;
									
									if (replaceMap.get(string) != null) {
										found = true;
									}
									cosString.reset();
									if (found) {
										cosString.append(replaceMap.get(string).getBytes(ENCODING));
									} else {
										cosString.append(string.getBytes(ENCODING));
									}
								}
							}
						}
					}
				}
				PDStream updatedStream = new PDStream(doc);
				OutputStream o = updatedStream.createOutputStream();
				ContentStreamWriter tokenWriter = new ContentStreamWriter(o);
				tokenWriter.writeTokens(tokens);
				page.setContents(updatedStream);
			}
			doc.save(out);
		} catch (IOException | COSVisitorException e) {
			throw new RuntimeException(e);
		} finally {
			if (doc != null) {
				try {
					doc.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
}
