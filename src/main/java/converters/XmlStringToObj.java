package converters;

import oopBasics.classes.Human;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class XmlStringToObj {
	
	public static void main(String[] args) {
		File file = new File("src/main/resources/human.txt");
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line = null;
			StringBuilder stringBuilder = new StringBuilder();
			String ls = System.getProperty("line.separator");
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}
			System.out.println(stringBuilder.toString());
			Human human = createHuman(stringBuilder.toString());
			
			System.out.println(human.toString());		
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
	}
	
	public static Human createHuman(String human) {
		JAXBContext jaxbContext;
		Human orderDetails = null;
		if (human != null && !human.isEmpty()) {
			try {
				jaxbContext = JAXBContext.newInstance(Human.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				orderDetails = (Human) jaxbUnmarshaller.unmarshal(new StringReader(human));
				return orderDetails;
			} catch (JAXBException e) {
				System.out.println("Order Details xml to object operation error." + e);
			}
		}
		return orderDetails;
	}
}
