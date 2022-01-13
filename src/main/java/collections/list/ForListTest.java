package collections.list;

import java.util.ArrayList;
import java.util.List;

public class ForListTest {
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(1);
		list.add(10);
		System.out.println(list);
		
		List<String> list1 = new ArrayList<>();
		for(String addr: list1 ){
			System.out.println("");
		}
	}
}
