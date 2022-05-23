package collections.map;

import java.util.HashMap;
import java.util.Map;

public class MapForEach {
	public static void main(String[] args) {
		
		Map<Integer, String> map = new HashMap<>();
		
		map.forEach((key, value) -> {
			System.out.println(key);
		});
		
		Map<Integer, String> copyMap = new HashMap<>();
		
		map.put(1, "birinci");
		map.put(2, "ikinci");
		map.put(3, "ücüncü");
		
		copyMap.putAll(map);
		for (Integer key : copyMap.keySet()) {
			
			if (key == 2) {
				map.remove(key);
			}
		}
		
		System.out.println(map.size());
	}
}
