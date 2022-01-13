package collections.list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListDistinct {
	public static void main(String[] args) {
		List<TestObject> list = new ArrayList<>();
		TestObject testObject = new TestObject(1,"abdfd");
//		list.add(new TestObject(1,"abdfd"));
//		list.add(new TestObject(1,"abdfd"));
		list.add(testObject);
		list.add(testObject);
		
		System.out.println("list size :" + list.size());
		
		List<TestObject> distinctList = new ArrayList<>();
		distinctList = list.stream().distinct().collect(Collectors.toList());
		System.out.println("distinctList size :" + distinctList.size());
		
	}
}
