package oopBasics;

import java.util.concurrent.atomic.AtomicInteger;

public class Performance {
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		AtomicInteger atomicInteger = new AtomicInteger();
		while((System.currentTimeMillis() - startTime) < 1000) {
			atomicInteger.getAndIncrement();
		}
		
		System.out.println("result1 : " + atomicInteger);
		
		startTime = System.currentTimeMillis();
		Integer integer = 0;
		while((System.currentTimeMillis() - startTime) < 1000) {
			integer++;
		}
		
		System.out.println("result2 : " + integer);
		
		startTime = System.currentTimeMillis();
		int intPrimitive = 0;
		while((System.currentTimeMillis() - startTime) < 1000) {
			intPrimitive++;
		}
		
		System.out.println("result3 : " + intPrimitive);
	}
}
