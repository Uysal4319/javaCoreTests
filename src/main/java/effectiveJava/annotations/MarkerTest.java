package effectiveJava.annotations;

import java.lang.reflect.Method;

public class MarkerTest {
	public static void main(String[] args) throws ClassNotFoundException {
		// interface marker
		Sample sample = new Sample();
		Sample2 sample2 = new Sample2();
		System.out.println("sample isPointed: " + isPointed(sample));
		System.out.println("sample2 isPointed: " + isPointed(sample2));
	
		// annotation marker
		int markedMethodCount = 0;
		
		Class<?> testClass = Class.forName("effectiveJava.annotations.Sample");
		for (Method method : testClass.getDeclaredMethods()) {
			if (method.isAnnotationPresent(MyMarker.class)) {
				markedMethodCount++;
			}
		}
		System.out.println("markedMethodCount: " + markedMethodCount);
		
		
	}
	
	public static boolean isPointed(Object obj) {
		if (obj instanceof Point) {
			return true;
		}
		return false;
	}
}
