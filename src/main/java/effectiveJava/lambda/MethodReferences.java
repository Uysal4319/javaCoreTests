package effectiveJava.lambda;

import java.util.Map;
import java.util.TreeMap;

public class MethodReferences {
	
	public static void main(String[] args) {
		Map<String,Integer> map = new TreeMap<>();
		String[] string = {"Hello","World","Hello","Lambda"};
		for (String s : string)
			map.merge(s,1,(count,incr) -> count + incr);
		System.out.println(map);
		
		for (String s : string)
			map.merge(s,1,Integer::sum);
		System.out.println(map);
	}
}
