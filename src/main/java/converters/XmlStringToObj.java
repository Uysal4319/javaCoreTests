package converters;

import oopBasics.classes.Human;
import utils.TestUtilities;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import java.io.File;

public class XmlStringToObj {
	
	public static void main(String[] args) {
		File file = new File("src/main/resources/human.txt");
		String string = TestUtilities.getFileContent(file);
		System.out.println(string);
		Human human = createHuman(string);
		System.out.println(human.toString());
	}
	
	public static Human createHuman(String human) {
		Human humanObj = null;
		if (human != null && !human.isEmpty()) {
			try {
				Source source = TestUtilities.disabledXXESource(human);
				JAXBContext jc = JAXBContext.newInstance(Human.class);
				Unmarshaller um = jc.createUnmarshaller();
				humanObj = (Human) um.unmarshal(source);

//				jaxbContext = JAXBContext.newInstance(Human.class);
//				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//				orderDetails = (Human) jaxbUnmarshaller.unmarshal(new StringReader(human));
				
				return humanObj;
			} catch (JAXBException e) {
				System.out.println("Order Details xml to object operation error." + e);
			}
		}
		return humanObj;
	}
}
