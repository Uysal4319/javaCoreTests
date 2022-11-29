package effectiveJava.varargs;

public class ArrayInVarargs {
	public static void main(String[] args) {
		String[] array = new String[4];
		array[0] = "hello";
		array[1] = "user";
		array[2] = "wellCome";
		array[3] = "java";
		
		printAll(array);
		
		printAll("hello", "world");
	}
	
	public static void printAll(String... args) {
		
		for(String val : args){
			System.out.println(val);
		}
	}
}

