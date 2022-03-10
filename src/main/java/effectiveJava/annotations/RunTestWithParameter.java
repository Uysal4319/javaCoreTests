package effectiveJava.annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTestWithParameter {
	
	public static void main(String[] args) throws ClassNotFoundException {
		int test = 0;
		int passed = 0;
		
		Class<?> testClass = Class.forName("effectiveJava.annotations.Sample2");
		for (Method method : testClass.getDeclaredMethods()) {
			if (method.isAnnotationPresent(TestWithParameter.class)) {
				test++;
				try {
					method.invoke(null);
				} catch (InvocationTargetException e) {
					Throwable exc = e.getCause();
					Class<? extends Throwable> exType = method.getAnnotation(TestWithParameter.class).value();
					if (exType.isInstance(exc)) {
						passed++;
					} else {
						System.out.println("Test " + exc.getCause() + " failed. expected" + exType.getName());
					}
				} catch (Exception e) {
					System.out.println("Invalid @Test" + e);
				}
			}
		}
		System.out.println("passed: " + passed + " failed: " + (test - passed));
	}
}
