package effectiveJava.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ScheduledExecutor {
	public static class MyExecutor implements Runnable {
		CountDownLatch latch;
		public MyExecutor(CountDownLatch latch) {
			this.latch = latch;
		}
		
		@Override
		public void run() {
			System.out.println("Thread name : " + Thread.currentThread().getName());
			IntStream.range(0, 1000).forEach(i -> {
				System.out.println("process: " + i);
			});
			latch.countDown();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		long start = System.nanoTime();
		CountDownLatch latch = new CountDownLatch(3);
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		IntStream.range(0, 3).forEach(i -> {
			executorService.execute(new SingleThreadExecutor.MyExecutor(latch));
		});
		executorService.shutdown();
		latch.await();
		long end = System.nanoTime();
		System.out.println("SingleThreadExecutor elapsed time : " + (end - start));
	}
}
