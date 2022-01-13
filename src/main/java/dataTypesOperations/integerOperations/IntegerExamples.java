package dataTypesOperations.integerOperations;

public class IntegerExamples {
	
	public static void main(String[] args) {
		
		nullCast();
	
	}
	
	public static void nullCast(){
		int a = 0;
		a = (int) getNullObject();
	}
	
	public static Object getNullObject(){
		return null;
	}
}
