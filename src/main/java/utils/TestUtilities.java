package utils;

import org.xml.sax.InputSource;

import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;
import java.io.*;

public class TestUtilities {
	
	public static Source disabledXXESource(String xml) {
		try {
			//Disable XXE
			SAXParserFactory spf = SAXParserFactory.newInstance();
			spf.setFeature("http://xml.org/sax/features/external-general-entities", false);
			spf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
			spf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
			return new SAXSource(spf.newSAXParser().getXMLReader(), new InputSource(new StringReader(xml)));
		} catch (Exception e) {
			System.out.println("Error while create Disabled XXE source. " + e);
			return null;
		}
	}
	
	public static Source disabledXXESource(InputStream inputStream) {
		try {
			//Disable XXE
			SAXParserFactory spf = SAXParserFactory.newInstance();
			spf.setFeature("http://xml.org/sax/features/external-general-entities", false);
			spf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
			spf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
			Source xmlSource = new SAXSource(spf.newSAXParser().getXMLReader(), new InputSource(inputStream));
			return xmlSource;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static String getFileContent(File file) {
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line = null;
			StringBuilder stringBuilder = new StringBuilder();
			String ls = System.getProperty("line.separator");
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}
		return stringBuilder.toString();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static BufferedInputStream getInputStream(String filePath) throws IOException {
		BufferedInputStream stream = null;
		if (filePath != null) {
			stream = new BufferedInputStream(new FileInputStream(filePath));
		}
		return stream;
	}
	
}
