package collections.list;

import java.util.ArrayList;
import java.util.List;

public class ListOperations {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		String[] array = null;
		boolean empty = list.isEmpty();
		if (!empty) {
			array = list.toArray(new String[0]);
			System.out.println(array[0] + " " + array[1] + " " + array[2]);
		}
		
	}
}
