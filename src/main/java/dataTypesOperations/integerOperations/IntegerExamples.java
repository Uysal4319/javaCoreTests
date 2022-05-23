package dataTypesOperations.integerOperations;

public class IntegerExamples {
	
	public static void main(String[] args) {
		
//		nullCast();
		String eksi = "-1";
		int a = Integer.parseInt(eksi);
		System.out.println(a*1024);
	
	}
	
	public static void nullCast(){
		int a = 0;
		a = (int) getNullObject();
	}
	
	public static Object getNullObject(){
		return null;
	}
}
