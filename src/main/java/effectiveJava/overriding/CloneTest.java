package effectiveJava.overriding;

import effectiveJava.memoryManagement.Stack;

public class CloneTest {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		// Shallow Copy
		Cat cat = new Cat("minnoş");
		Cat copyCat = cat;
		System.out.println(cat == copyCat);
		
		//Deep Copy 
		Cat cat1 = new Cat("boncuk");
		Cat cat2 = new Cat("mırmır");
		cat1.name = cat2.name;
		System.out.println(cat1 == cat2);
		
		
		Stack stack = new Stack();
		String[] elements = {"1","2","3","4"};
		for (String element : elements){
			stack.push(element);
		}
		Stack copyStack = stack.clone();
		
		while (!stack.isEmpty())
			stack.popWell();
		
		while (!copyStack.isEmpty())
			copyStack.popWell();
		
	}
}
