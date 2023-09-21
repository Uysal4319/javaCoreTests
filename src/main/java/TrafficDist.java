import java.util.HashMap;
import java.util.Map;

public class TrafficDist {
	private static final Map<Integer, Boolean> map = new HashMap<>();
	public static void main(String[] args) {
		int count = 20;
		for (int i = 0; i < count; i++) {
			map.put(i, true);
		}
		map.put(4,false);
		System.out.println(findAvailablePartition(map, 3));
	}
	
	public static int findAvailablePartition(Map<Integer, Boolean> lagAvailableMap, int start) {
		int partition = start;
		do {
			if (Boolean.TRUE.equals(lagAvailableMap.get(partition))) {
				return partition;
			}
			partition++;
			partition = partition % lagAvailableMap.size();
		} while (partition != start);
		return start;
	}
}
