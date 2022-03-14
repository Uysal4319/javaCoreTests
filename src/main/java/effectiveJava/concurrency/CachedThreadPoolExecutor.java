package effectiveJava.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class CachedThreadPoolExecutor {
	public static class MyExecutor implements Runnable {
		CountDownLatch latch;
		
		public MyExecutor(CountDownLatch latch) {
			this.latch = latch;
		}
		
		@Override
		public void run() {
			System.out.println("Thread name : " + Thread.currentThread().getName() + " - " + (System.currentTimeMillis()/1000));
//			IntStream.range(0, 5).forEach(i -> {
////				System.out.println("process: " + i);
//			});
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			latch.countDown();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		long start = System.nanoTime();
		CountDownLatch latch = new CountDownLatch(3);
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
		IntStream.range(0, 15).forEach(i -> {
//			executorService.scheduleWithFixedDelay(new MyExecutor(latch), 100, 10000, TimeUnit.MILLISECONDS);
 			executorService.scheduleAtFixedRate(new MyExecutor(latch), 100, 10000, TimeUnit.MILLISECONDS);
		});
		TimeUnit.SECONDS.sleep(15);
		executorService.shutdown();
		latch.await();
		long end = System.nanoTime();
		System.out.println("CachedThreadPoolExecutor elapsed time : " + (end - start));
	}
}
