package formaters.jsonOperations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class Main {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";

        //map json to student
        try{
            Student student = mapper.readValue(jsonString, Student.class);

            System.out.println(student);

            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);

            System.out.println(jsonString);
	
            Gson gson = new Gson();
			System.out.println("gson to json "+ gson.toJson(student));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
