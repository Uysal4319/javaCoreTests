package multiThread;

import java.util.concurrent.CountDownLatch;

public class FirstExecutor implements Runnable {
	CountDownLatch latch;
	
	public FirstExecutor(CountDownLatch latch) {
		this.latch = latch;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(150000);
			latch.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
