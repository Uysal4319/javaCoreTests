package converters;

import oopBasics.classes.Human;
import utils.TestUtilities;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import java.io.ByteArrayInputStream;
import java.io.File;

public class FileToObject {
	public static void main(String[] args) {
		File file = new File("src/main/resources/human.txt");
		try {
			String content = TestUtilities.getFileContent(file);
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(content.getBytes("ISO-8859-9"));
			Source source = TestUtilities.disabledXXESource(byteArrayInputStream);
			JAXBContext context = JAXBContext.newInstance(Human.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Human human = (Human) unmarshaller.unmarshal(source);
			System.out.println(human);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
