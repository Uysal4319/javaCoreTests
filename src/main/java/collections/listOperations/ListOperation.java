package collections.listOperations;

import java.util.ArrayList;
import java.util.List;

public class ListOperation {
	
	public static void main(String[] args) {
		List<Item> list = new ArrayList<Item>();
		list.add(new Item("abcd" ,1));
		list.add(new Item("efg", 2));
		list.add(new Item("sadfsd",3));
		list.add(new Item("asdgf",4));
		removeIfExistItem(list);
		
		System.out.println(list.size());
 	}
	
	public static void removeIfExistItem(List<Item> list){
		for (Item item : list){
			if(item.getName().equalsIgnoreCase("abcd")){
				list.remove(item);
				break;
			}
		}
	}
}
