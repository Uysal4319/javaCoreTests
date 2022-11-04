package dataTypesOperations.objectOperations;

public class NullPointer {
	
	public static void main(String[] args) {
		nullListInFor();
		
		String a =null;
		System.out.println(a.charAt(0));
		
		
		
	}
	
	public static void nullListInFor(){
		try {
			Resource resource = new Resource();
			
			for (String str : resource.getNames()){
				System.out.println(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
