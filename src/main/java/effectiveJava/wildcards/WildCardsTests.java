package effectiveJava.wildcards;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WildCardsTests {
	public static void main(String[] args) {
//		List<A> list = new ArrayList<B>();
		List<? extends A> list1 = new ArrayList<B>();
		List<? extends A> list2 = new ArrayList<C>();

//		List<B> list3 = new ArrayList<A>();
		List<? super B> list4 = new ArrayList<A>();
		List<? super D> list5 = new ArrayList<A>();
		
		Set<Integer> integers = new HashSet<Integer>();
		integers.add(565);
		integers.add(524);
		
		Set<Double> doubles = new HashSet<Double>();
		doubles.add(3.4);
		doubles.add(3.9);
		
		System.out.println(concat(integers, doubles));
	}
	
	public static <E> Set<? super E> concat(Set<? extends E> set1, Set<? extends E> set2) {
		Set<E> result = new HashSet<>(set1);
		result.addAll(set2);
		return result;
	}
	
	public class A {
		
	}
	
	public class B extends A {
		
	}
	
	public class C extends B {
		
	}
	
	public class D extends B {
		
	}
}
