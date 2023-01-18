import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
	
	public static void main(String[] args) {
	int[] a = new int[4];
	a[0]=1;
	a[1]=7;
	a[2]=6;
	a[3]=4;
	
	returnMax(a);
	
	compareTest();
	}
	
	public static void returnMax(int[] nums) {
		List b = Arrays.asList(ArrayUtils.toObject(nums));
		System.out.println(Collections.max(b));
	}
	
	public static void compareTest(){
		String s1 = new String("hello");
		String s2 = new String("hello");
		
		if (s1.equals(s2))
			System.out.println("equal");
		else
			System.out.println("not equal");
		
		if(s1.equals(s2))
			System.out.println("equal");
		else
			System.out.println("not equal");
	}
}
