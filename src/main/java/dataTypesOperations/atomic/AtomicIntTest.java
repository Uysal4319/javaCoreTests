package dataTypesOperations.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class AtomicIntTest {
	public static void main(String[] args) {
		AtomicInteger atomicInteger = new AtomicInteger(Integer.MAX_VALUE);
		System.out.println(atomicInteger);
		IntStream.range(0,100).forEach(i -> {	
			System.out.println(Math.abs((atomicInteger.incrementAndGet() % 20)));
		});
	}
}
