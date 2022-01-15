package effectiveJava.overriding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OverridingTests {
	public static void main(String[] args) {
		System.out.println("10 == 20  -> " + (10 == 20));
		System.out.println("'a' == 97.0  -> " + ('a' == 97.0));
		
		ExampleClass exampleClass = new ExampleClass(1, 2);
		ExampleClass exampleClass2 = new ExampleClass(1, 2);
		System.out.println("exampleClass == exampleClass2 -> " + (exampleClass == exampleClass2));
		System.out.println("exampleClass.equals(exampleClass2) -> " + exampleClass.equals(exampleClass2));
		
		ExampleOverridingClass eOClass = new ExampleOverridingClass(1, 2);
		ExampleOverridingClass eOClass2 = new ExampleOverridingClass(1, 2);
		if (eOClass.equals(eOClass2)) {
			System.out.println("Equals");
		}
		
		Map<ExampleClass, String> hashMap = new HashMap<>();
		hashMap.put(exampleClass, "first item");
		System.out.println("example class in map :  " + hashMap.get(new ExampleClass(1, 2)));
		
		Map<ExampleOverridingClass, String> overrideHashMap = new HashMap<>();
		overrideHashMap.put(eOClass, "overriding first item");
		System.out.println("example overriding class in map : " + overrideHashMap.get(new ExampleOverridingClass(1, 2)));
		
		
		List<ExampleClass> list = new ArrayList<>();
		list.add(exampleClass);
		if(list.contains(new ExampleClass(1,2))){
			System.out.println("list contain this class");
		}else{
			System.out.println("list not contain this class");
		}
		
		List<ExampleOverridingClass> overridingList = new ArrayList<>();
		overridingList.add(eOClass);
		if(overridingList.contains(new ExampleOverridingClass(1,2))){
			System.out.println("overridingList contain this class");
		}else{
			System.out.println("overridingList not contain this class");
		}
	}
}
