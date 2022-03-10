package effectiveJava.annotations;

public class Sample2 {
	@TestWithParameter(ArithmeticException.class)
	public static void m1() {
		throw new ArithmeticException();
	}
	
	@TestWithParameter(ArrayIndexOutOfBoundsException.class)
	public static void m2() {
		throw new NullPointerException();
	}
	
	@TestWithParameter(NullPointerException.class)
	public static void m3() {
	}
}
