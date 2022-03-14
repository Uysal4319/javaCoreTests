package dataTypesOperations.stringOperations;

public class StringConcatenation {
	public static void main(String[] args) {
		long start = System.nanoTime();
		concatenation();
		long end = System.nanoTime();
		System.out.println("concatenation elapsed time: "+ (start -end));
		
		start = System.nanoTime();
		stringBuilder();
		end = System.nanoTime();
		System.out.println("stringBuilder elapsed time: "+ (start -end));
	}
	
	public static String concatenation(){
		String[] arr = {"veli","ali","adil","ali","world","and","concatenation","string","hello","adem","ertugrul","mehmet","ahmet",};
		String result="";
		for (String item : arr){
			result += item;
		}
		return result;
	}
	
	public static String stringBuilder(){
		String[] arr = {"veli","ali","adil","ali","world","and","concatenation","string","hello","adem","ertugrul","mehmet","ahmet",};
		StringBuilder sb=new StringBuilder();
		for (String item : arr){
			sb.append(item);
		}
		return sb.toString();
	}
}
