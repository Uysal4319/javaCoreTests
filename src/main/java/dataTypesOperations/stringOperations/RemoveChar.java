package dataTypesOperations.stringOperations;

public class RemoveChar {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("23asdfgasdfg45  67dsfdf  gdf  ").append("hello world").append(",");
		
		
		if (sb.toString().endsWith(",")) {
			System.out.println(", ile bitiyor");
			sb = new StringBuilder(sb.substring(0, sb.toString().length()-1 ));
		} else {
			int index = sb.indexOf("hello world");
			sb = new StringBuilder(sb.substring(0, index));
		}
		
		
		System.out.println(sb.toString());
	}
}
