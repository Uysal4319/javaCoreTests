package effectiveJava.annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTest {
	public static void main(String[] args) throws ClassNotFoundException {
		int test = 0;
		int passed = 0;
		
		Class<?> testClass = Class.forName("effectiveJava.annotations.Sample");
		for (Method method : testClass.getDeclaredMethods()) {
			if (method.isAnnotationPresent(Test.class)) {
				test++;
				try {
					method.invoke(null);
					passed++;
				} catch (InvocationTargetException e) {
					Throwable exc = e.getCause();
					System.out.println(method + " failed: " + exc);
				} catch (Exception e) {
					System.out.println("Invalid @Test" + e);
				}
			}
		}
		System.out.println("passed: " + passed + " failed: " + (test - passed));
	}
}
