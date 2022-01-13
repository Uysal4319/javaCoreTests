package formaters.jsonOperations;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class SerializationTest {

    public static void main(String[] args) {
        SerializationTest stester = new SerializationTest();
        try {
            Student student =new Student();
            student.setAge(20);
            student.setName("Ertugrul");
            stester.writeJSON(student);

            Student student1 = stester.readJSON();
            System.out.println(student1);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void writeJSON(Student student) throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("student.json"), student);
    }

    private Student readJSON() throws JsonParseException, JsonMappingException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        Student student = mapper.readValue(new File("student.json"), Student.class);
        return student;
    }
}
