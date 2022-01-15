package effectiveJava.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableTest {
	
	public static void main(String[] args) {
		List<Book> bookList = new ArrayList<>();
		bookList.add(new Book("asdfasdf",1211));
		bookList.add(new Book("asd",122));
		bookList.add(new Book("qwweew",121));
		
		Collections.sort(bookList);
		
		bookList.forEach((item)-> System.out.println(item.toString()));
		
		System.out.println("--------------------------------------------------------------");
		NameComparator nameComparator = new NameComparator();
		
		Collections.sort(bookList,nameComparator);
		
		bookList.forEach((item)-> System.out.println(item.toString()));
	}
}
