package multiThread;

import java.util.HashMap;
import java.util.Map;

public class ProcessThread extends Thread{
	@Override
	public void run() {
		System.out.println("Thread "+ Thread.currentThread().getId() + " started" );
		Map<String ,Integer> map = new HashMap<>();
		
		try {
			Process.fetchMap(map,(int) Thread.currentThread().getId()*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Thread "+ Thread.currentThread().getId() + " size = " +map.size());
	}
}
