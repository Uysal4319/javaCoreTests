package dataTypesOperations.stringOperations;

public class StringBuilderTest {
	
	public static void main(String[] args) {
		System.out.println(getMnpDocTypeSearchStr());
	}
	public static String getMnpDocTypeSearchStr(){
		StringBuilder mnpDocTypeStr = new StringBuilder();
		mnpDocTypeStr.append("Hello").append("^");
		mnpDocTypeStr.append("World").append("^");
		mnpDocTypeStr.append("I").append("^");
		mnpDocTypeStr.append("Am").append("^");
		mnpDocTypeStr.append("Ertugrul");
		return mnpDocTypeStr.toString();
	}
}
