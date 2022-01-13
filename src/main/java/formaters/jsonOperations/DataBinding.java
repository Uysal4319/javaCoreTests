package formaters.jsonOperations;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataBinding {
	
	public static void main(String[] args) throws IOException {
		
		Map<String, Object> studentMap = new HashMap<>();
		int[] marks = {1, 2, 3};
		
		Student s1 = new Student();
		s1.setName("Ertugrul");
		s1.setAge(15);
		
		studentMap.put("student", s1);
		studentMap.put("surname", "Uysal");
		studentMap.put("verified", Boolean.FALSE);
		studentMap.put("marks", marks);
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(new File("student.json"), studentMap);
		
		studentMap = objectMapper.readValue(new File("student.json"), Map.class);
		
		System.out.println(studentMap.get("student"));
		System.out.println(studentMap.get("name"));
		System.out.println(studentMap.get("verified"));
		System.out.println(studentMap.get("marks"));
		
	}
}
