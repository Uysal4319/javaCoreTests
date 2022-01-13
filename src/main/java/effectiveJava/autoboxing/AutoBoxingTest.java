package effectiveJava.autoboxing;

import java.util.ArrayList;
import java.util.List;

public class AutoBoxingTest {
	
	public static void main(String[] args) {
		String pant = new String("pantalon");
		String pantalon = "pantalon";
		
		long startTime = System.nanoTime();
		sum();
		long endTime = System.nanoTime();
		System.out.println("difference : " + (endTime - startTime));
		// 497699
		//4200
		
		// Autoboxing - Unboxing
		ArrayList<Integer> integer = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			integer.add(Integer.valueOf(i));
		}
		
		List<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(1);
		list.add(2);
		for (Integer i : list) {
			if ((i.intValue() % 3) != 0) {
				System.out.println(i);
			}
		}
	}
	
	private static long sum() {
		long sum = 0;
		
		for (int i = 0; i < 150; i++) {
			sum += i;
		}
		return sum;
	}
}
