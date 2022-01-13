package oopBasics.methods;

import java.util.Date;

public class MethodLifeCycle {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("start : " + new Date());
		waitSleep();
		System.out.println("finish : " + new Date());
	}
	
	public static void waitSleep() throws InterruptedException {
		int result = 0;
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			result = i + result;
		}
		System.out.println(result);
		for (int i = result; i < Integer.MAX_VALUE; i--) {
			result = result-i;
		}
		System.out.println(result);
	}
}
