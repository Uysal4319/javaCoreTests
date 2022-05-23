package dataTypesOperations.stringOperations;

import formaters.jsonOperations.Student;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class StringWriterTest {
	public static void main(String[] args) throws FileNotFoundException, JAXBException {
		Student student = new Student();
		student.setName("ertugrul");
		student.setAge(28);
		StringWriter stringWriter= new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		Marshaller marshaller = getJAXBContext().createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
		marshaller.marshal(student, printWriter);
		System.out.println(stringWriter.getBuffer().toString());
	}
	
	private static JAXBContext getJAXBContext() {
		JAXBContext context = null;
		try {
			context = JAXBContext.newInstance("formaters.jsonOperations");
		} catch (JAXBException e) {
			System.out.println("JAXBException occurred while getting the context"+ e);
		}
		return context;
	}
}
