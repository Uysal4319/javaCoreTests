package multiThread;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskTest {
	public static long previousTime = 0 ;
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				long newTime = System.currentTimeMillis();
				System.out.println( "Hello World "+ newTime +" elapsedTime: " + (newTime-previousTime));
				previousTime = newTime;
			}
		}, 0, 5000);
	}
}
