package dataTypesOperations.stringOperations;

public class IndexOperations {
	
	public static void main(String[] args) {
		System.out.println(getDocTypeValue("Hello World"));	
		getNotExistIndex();
	}
	public static String getDocTypeValue(String Bundle) {
		String docTypeValue = null;
		if (Bundle.lastIndexOf("orl") != -1) {
			docTypeValue = "1";
		}
		if (Bundle.lastIndexOf("sdef") != -1) {
			docTypeValue = "2";
		}
		if (Bundle.lastIndexOf("aer") != -1) {
			docTypeValue = "3";
		}
		if (Bundle.lastIndexOf("hjukl") != -1) {
			docTypeValue = "4";
		}
		return docTypeValue;
	}
	
	public static void getNotExistIndex(){
		String string= "5";
		System.out.println(string.indexOf("o"));
	}
}
