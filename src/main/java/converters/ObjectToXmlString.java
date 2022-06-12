package converters;

import oopBasics.classes.Human;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.StringWriter;

public class ObjectToXmlString {
	public static void main(String[] args) {
		Human human = new Human();
		human.setName("ertugrul");
		human.setAge(20);
		System.out.println(convertObjToXmlString(human));
	}
	public static String convertObjToXmlString(Object res) {
		System.out.println("<convertHumanObjToXmlString> xml preparation started.");
		String xmlString = "";
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Human.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter sw = new StringWriter();
			jaxbMarshaller.marshal(res, sw);
			xmlString = sw.toString();
		} catch (PropertyException e) {
			System.out.println("convertHumanObjToXmlString, property exception "+ e);
		} catch (JAXBException e) {
			System.out.println("convertHumanObjToXmlString, JAXB exception " + e);
		}
		return xmlString;
	}
}
