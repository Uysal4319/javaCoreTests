package dataTypesOperations.stringOperations;

import java.util.HashMap;
import java.util.Map;

public class NullString {
	
	public static void main(String[] args) {
		
		Map<String ,String> map = new HashMap<>();
		
		String s = map.get("hello");
		
		if(s.equalsIgnoreCase("true")){
			System.out.println("sucuess");
		}
	}
}
