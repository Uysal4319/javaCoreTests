package effectiveJava.varargs;

import java.util.ArrayList;
import java.util.List;

public class GenericsAndVarargsTests {
	public static void main(String[] args) {
		List<Integer> integers = new ArrayList<>();
		integers.add(232);
		integers.add(232);
		List<Double> doubles = new ArrayList<>();
		doubles.add(1.5);
		doubles.add(1.6);
		
		System.out.println(listConcat(integers, doubles).size());
	}
	
	@SafeVarargs
	public static <T> List<T> listConcat(List<? extends T>... lists) {
		List<T> result = new ArrayList<>();
		for (List<? extends T> list : lists) {
			result.addAll(list);
		}
		return result;
	}
}
