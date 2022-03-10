package effectiveJava.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparingInt;

public class LambdaTest {
	public static void main(String[] args) {
		String[] nameList = {"ertu","ertugrul","ali","abdulrezzak","veli"};
		List<String> list = Arrays.asList(nameList);
		
		// Anonymous class interface as a function object
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(),o2.length());
			}
		});
		System.out.println(list);
		
		Collections.shuffle(list);
		//Lambda expression as a function object
		Collections.sort(list,(item1,item2)-> Integer.compare(item1.length(),item2.length()));
		System.out.println(list);
		Collections.shuffle(list);
		
		//Comparator construction method
		Collections.sort(list, comparingInt(String::length));
		System.out.println(list);
		Collections.shuffle(list);
		
		// default method List.sort conjunction with comparator construction method
		list.sort(comparingInt(String::length));
		System.out.println(list);
	}
}
