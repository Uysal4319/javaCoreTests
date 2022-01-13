package dataTypesOperations.stringOperations;

public class IndexOperations {
	
	public static void main(String[] args) {
		System.out.println(getDocTypeValue("Hello World"));	
	}
	public static String getDocTypeValue(String MNPBundle) {
		String docTypeValue = null;
		if (MNPBundle.lastIndexOf("orl") != -1) {
			docTypeValue = "1";
		}
		if (MNPBundle.lastIndexOf("sdef") != -1) {
			docTypeValue = "2";
		}
		if (MNPBundle.lastIndexOf("aer") != -1) {
			docTypeValue = "3";
		}
		if (MNPBundle.lastIndexOf("hjukl") != -1) {
			docTypeValue = "4";
		}
		return docTypeValue;
	}
}
