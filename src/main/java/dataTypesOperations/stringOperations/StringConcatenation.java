package dataTypesOperations.stringOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class StringConcatenation {
	public static String concatStr =" ) OR username in ( ";
	public static void main(String[] args) {
		long start = System.nanoTime();
		concatenation();
		long end = System.nanoTime();
		System.out.println("concatenation elapsed time: "+ (start -end));
		
		start = System.nanoTime();
		stringBuilder();
		end = System.nanoTime();
		System.out.println("stringBuilder elapsed time: "+ (start -end));
		
		System.out.println(stringBuilderSqlCreate());
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
	
	public static String stringBuilderSqlCreate(){
		List<String> usernameList  = new ArrayList<>();
		usernameList.add("ertu");
		usernameList.add("ertu0");
		IntStream.range(0,496).forEach(i -> usernameList.add(String.valueOf(i)));
		usernameList.add("admin");
		usernameList.add("root");
		usernameList.add("testuser");
		StringBuilder sql = new StringBuilder("select * from user where username in ");
		
		sql.append("(");
		int count = 0 ;
		for (String userName : usernameList){
			count++;
			sql.append("'").append(userName).append("'");
			if ((count % 500) != 0){
				sql.append(",");
			} else {
				sql.append(concatStr);
			}
		}
		if (sql.toString().endsWith(",")) {
			sql = new StringBuilder(sql.substring(0, sql.toString().length()-1 ));
		} else if (sql.toString().endsWith(concatStr)){
			int index = sql.indexOf(concatStr);
			sql = new StringBuilder(sql.substring(0, index));
		}
		
		sql.append(")");
		
		return sql.toString();
	}
}
