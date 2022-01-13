package formaters.jsonOperations;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class StreamingApi {
	
	public static void main(String[] args) throws IOException {
		
		JsonFactory jsonFactory = new JsonFactory();
		JsonGenerator jsonGenerator = jsonFactory.createGenerator(new File("student.json"), JsonEncoding.UTF8);
		
		jsonGenerator.writeStartObject();
		jsonGenerator.writeStringField("name", "Ertugrul");
		jsonGenerator.writeNumberField("age", 25);
		jsonGenerator.writeBooleanField("verified", true);
		
		
		jsonGenerator.writeFieldName("marks");
		jsonGenerator.writeStartArray();
		jsonGenerator.writeNumber(100);
		jsonGenerator.writeNumber(65);
		jsonGenerator.writeNumber(55);
		jsonGenerator.writeEndArray();
		
		jsonGenerator.writeEndObject();
		
		jsonGenerator.close();
		
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> map = objectMapper.readValue(new File("student.json"), Map.class);
		
		System.out.println(map.get("name"));
		System.out.println(map.get("age"));
		System.out.println(map.get("verified"));
		System.out.println(map.get("marks"));
		
		// Read Json
		JsonParser jsonParser = jsonFactory.createParser(new File("student.json"));
		while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
			//get the current token
			String fieldname = jsonParser.getCurrentName();
			if ("name".equals(fieldname)) {
				//move to next token
				jsonParser.nextToken();
				System.out.println(jsonParser.getText());
			}
			if ("age".equals(fieldname)) {
				//move to next token
				jsonParser.nextToken();
				System.out.println(jsonParser.getNumberValue());
			}
			if ("verified".equals(fieldname)) {
				//move to next token
				jsonParser.nextToken();
				System.out.println(jsonParser.getBooleanValue());
			}
			if ("marks".equals(fieldname)) {
				//move to [
				jsonParser.nextToken();
				// loop till token equal to "]"
				while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
					System.out.println(jsonParser.getNumberValue());
				}
			}
		}
	}
}
