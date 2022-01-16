package effectiveJava.classesAndInterfaces;

public class AccessModifiersTests {
	public static void main(String[] args) {
		NotSecuredClass.array[0] = "I hack your array.";
		
//		SecuredClass.array[0] = "I can not hack your array.";
	}
}
