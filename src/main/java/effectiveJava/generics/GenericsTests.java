package effectiveJava.generics;

import java.util.*;

public class GenericsTests {
	public static void main(String[] args) {
		//	List list = new ArrayList(); Cast exception case
		List<String> list = new ArrayList();
//		list.add(10);
		list.add("hello");
		System.out.println((String) list.get(0));
		
		List<Object> objects = new ArrayList<>();
		objects.add("fdsghdf");
		System.out.println(getInlist(objects));
		
		
		try {
			Object[] objectArray = new Long[1];
			objectArray[0] = "hello";
		} catch (Exception e) {
			System.out.println("Long array e string atadim bu hata runtime da gorunur");
		}
		
		List<Object> objectList = new ArrayList<Object>();
		objectList.add(1L);
		
		
		StackWithGenerics<String> stack = new StackWithGenerics<>();
		stack.push("sdfasdf");
//		stack.push(23);
		System.out.println(stack.pop());
		
		Set<String> set1 = new HashSet<>();
		set1.add("efsadf");
		set1.add("dfsgds");
		Set<String> set2 = new HashSet<>();
		set2.add("efsadf");
		set2.add("ddsfgdsgfsgds");
		
		Set<String> concat = concat(set1,set2);
		System.out.println(concat);
		
		System.out.println(sum(22,44));
//		System.out.println(sum(22,"44"));
		
	}
	
	// Generic Methods
	public static <E> Set<E> concat(Set<E> set1, Set<E> set2) {
		Set<E> result = new HashSet<>(set1);
		result.addAll(set2);
		return result;
	}
	
	public static <T extends Number> int sum(T a, T b) {
		return a.intValue() + b.intValue();
	}
	
	@SuppressWarnings("unchecked")
	public static String getInlist(List<Object> list) {
		return (String) list.get(0);
	}
}
