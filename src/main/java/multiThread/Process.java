package multiThread;

import java.util.Map;

public class Process {
	
	public static void fetchMap(Map<String ,Integer> map , int limit) throws InterruptedException {
		
		for (int i = 0; i<limit;i++ ){
			Thread.sleep(1);
			map.put(i +" = ",i);
		}
		
	}
}
