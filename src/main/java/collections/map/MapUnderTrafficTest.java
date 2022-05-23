package collections.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapUnderTrafficTest {
	public static ConcurrentHashMap<Long, Long> map = new ConcurrentHashMap<>();
	
	public static void main(String[] args) throws InterruptedException {
		AddThread addThread = new AddThread();
		addThread.start();
		Thread.sleep(10000);
		RemoveThread removeThread = new RemoveThread();
		removeThread.start();
	}
	
	public static class AddThread extends Thread {
		
		public AddThread() {
		}
		
		@Override
		public void run() {
			long count = 0;
			try {
				while (count < 100000) {
					map.put(count, count);
					Thread.sleep(1);
					count++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static class RemoveThread extends Thread {
		
		public RemoveThread() {
		}
		
		@Override
		public void run() {
			long count = 0;
			try {
				List<Long> cleanList = new ArrayList<>();
				long begin = map.entrySet().size();
				System.out.println("Map entrySet size before crate clean list : " + begin);
				for (Map.Entry<Long, Long> entry : map.entrySet()) {
					cleanList.add(entry.getKey());
				}
				long end = map.entrySet().size();
				System.out.println("Map entrySet size after crate clean list : " + end);
				System.out.println("Clean List size : " + cleanList.size() + " real difference : " + (end - begin));
				for (Long externalIdentifier : cleanList) {
					map.remove(externalIdentifier);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
