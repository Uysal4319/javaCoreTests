package oopBasics.generics;

import java.util.HashMap;
import java.util.Map;

public class MyMap<K, V> {
	private Map<K, V> map = new HashMap<>();
	
	public void list() {
		this.map.entrySet().stream().forEach(kvEntry -> {
			System.out.println(kvEntry.getKey() + "----" + kvEntry.getValue());
		});
	}
	public void put(K k, V v) {
		this.map.put(k, v);
	}
}
