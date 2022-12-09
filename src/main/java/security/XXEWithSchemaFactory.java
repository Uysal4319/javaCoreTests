package security;

import generators.fileEncoding.Employee;
import org.xml.sax.SAXException;
import utils.TestUtilities;

import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.transform.Source;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

public class XXEWithSchemaFactory {
	public static void main(String[] args) {
		try {
			// Create a SchemaFactory instance for the XML schema language
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			File schemaFile = new File("src/main/resources/employee.xsd");
			Schema schema = factory.newSchema(schemaFile);
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			unmarshaller.setSchema(schema);
			unmarshaller.setEventHandler(new ValidationEventHandler() {
				
				public boolean handleEvent(ValidationEvent validationevent) {
					if (validationevent.getMessage().equals("cvc-elt.4.2: Cannot resolve 'Employee' to a type definition for element 'NPCData'.")) {
						System.out.println("a possible namespace conflict will be ignored at validation");
						return true;
					} else {
						return false;
					}
				}
			});
			
			File xmlFile = new File("src/main/resources/employee.xml");
			
			Employee employee = (Employee) unmarshaller.unmarshal(xmlFile);
			
			// For disable XXE
			String fileContent = TestUtilities.getFileContent(xmlFile);
			Source xmlSource = TestUtilities.disabledXXESource(fileContent);
			Employee employee1 = (Employee) unmarshaller.unmarshal(xmlSource);
			
			System.out.println(employee);
			System.out.println(employee1);
			
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
