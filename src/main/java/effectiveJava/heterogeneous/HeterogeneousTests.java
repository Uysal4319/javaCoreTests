package effectiveJava.heterogeneous;

import java.util.HashMap;
import java.util.Map;

public class HeterogeneousTests {
	static Map<Class<?>, Object> likes = new HashMap<>();
	
	public static void main(String[] args) {
		Map<Class<?>, Object> map = new HashMap<>();
		map.put(String.class, 3);
		map.put(Integer.class, 5);
		System.out.println(map.get(String.class));
		
		putLikes(String.class, "hello");
		putLikes(String.class, "world");
		putLikes(Integer.class, 5);
		
		System.out.println(getLikes(String.class));
	}
	
	public static <T> void putLikes(Class<?> key, Object value) {
		likes.put(key, value);
	}
	
	public static <T> T getLikes(Class<T> key) {
		return (T) likes.get(key);
	}
}
