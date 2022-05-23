package multiThread;

import java.util.concurrent.CountDownLatch;

public class SecondExecutor implements Runnable{
	CountDownLatch latch;
	
	public SecondExecutor(CountDownLatch latch) {
		this.latch = latch;
	}
	@Override
	public void run() {
		System.out.println("Second Executor start");
		latch.countDown();
	}
}
