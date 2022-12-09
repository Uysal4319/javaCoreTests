package formaters.jsonOperations;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {
	public ObjectFactory() {
	}
	
	public Student createStudent() {
		return new Student();
	}
	
}
