package oopBasics.generics;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Random random = new Random();
		Box<Integer, String> b1 = new Box<>();
		random.ints(0, 50).limit(10).forEach(x -> {
			b1.add(x);
		});
		System.out.println(b1.size());
		System.out.println(b1.get(1));
		System.out.println(b1.getFirst());
		System.out.println(b1.getSecond());
		
		Box<String, String> b2 = new Box<>();
		for (int i = 0; i < 5; i++) {
			String a = "" + i;
			b2.add(a, "adım");
		}
		
		System.out.println("---------------------------------------");
		System.out.println(b2.size());
		System.out.println(b2.get(1));
		System.out.println(b2.getFirst());
		System.out.println(b2.getSecond());
		
		System.out.println("----------------------------------------");
		
		MyMap<Integer, String> myMap = new MyMap<>();
		
		for (int i = 0; i < 5; i++) {
			String a = " in karesi = " + i * i;
			myMap.put(i, a);
		}
		
		myMap.list();
		System.out.println("----------------------------------------");
	}
}
