package dataTypesOperations.stringOperations;

public class StringBuilderTest {
	
	public static void main(String[] args) {
		System.out.println(getDocTypeSearchStr());
	}
	public static String getDocTypeSearchStr(){
		StringBuilder docTypeStr = new StringBuilder();
		docTypeStr.append("Hello").append("^");
		docTypeStr.append("World").append("^");
		docTypeStr.append("I").append("^");
		docTypeStr.append("Am").append("^");
		docTypeStr.append("Ertugrul");
		return docTypeStr.toString();
	}
}
