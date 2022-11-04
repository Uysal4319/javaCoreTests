package dataTypesOperations.objectOperations;

public class EqualMethodTest {
	
	public static void main(String[] args) {
		String hello = "hello";
		equalIgnoreTest(hello);
		
	}
	
	public static void equalIgnoreTest(String text){
		if (text.equalsIgnoreCase(null)){
			System.out.println("equal");
		} else {
			System.out.println("not equal");
		}
	}
}
