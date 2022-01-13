package collections;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

    public static Set<Integer> hashSet = new HashSet<>();

    public static void main(String[] args) {
    	
        hashSet.add(1);
        hashSet.add(null);

        System.out.println(hashSet.contains(null));
    }
    
    public static void getir(){
		System.out.println("bla bla bla");
	}
	
}
