package dataTypesOperations.stringOperations;

public class TextCompare {
	public static void main(String[] args) {
		String a = "false";
		toLowerCase(a);
		equalsIgnoreCase(a);
	}
	
	public static void toLowerCase(String a){
		long startTime = System.nanoTime();
		if(a.toLowerCase() == "true"){
			System.out.println("a = true");
		} else if (a.toLowerCase() == "false"){
			System.out.println("a = false");
		}
		long endTime = System.nanoTime();
		System.out.println("toLowerCase elapsed Time: " + (endTime - startTime));
	}
	
	public static void equalsIgnoreCase(String a){
		long startTime = System.nanoTime();
		if(a.equalsIgnoreCase("true")){
			System.out.println("a = true");
		} else if (a.equalsIgnoreCase("false")){
			System.out.println("a = false");
		}
		long endTime = System.nanoTime();
		System.out.println("equalsIgnoreCase elapsed Time: " + (endTime - startTime));
	}
}
