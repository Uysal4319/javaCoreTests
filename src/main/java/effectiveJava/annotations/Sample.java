package effectiveJava.annotations;

public class Sample implements Point{
	@Test
	public static void m1(){
	}
	@MyMarker
	public static void m2(){
	}
	@Test
	public static void m3(){
		throw new RuntimeException("explode");
	}
	
	public static void m4(){
	}
	
	@Test
	public  void m5(){
	} //INVALID USE
	
	@Test
	public static void m6(){
	}
	@Test
	public static void m7(){
		throw new RuntimeException("Crash");
	}
	public static void m8(){
	}
}
