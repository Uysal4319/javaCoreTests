package multiThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ExecutorTest {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(2);
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		IntStream.range(0, 1).forEach(i -> {
			executorService.execute(new SecondExecutor(latch));
			executorService.execute(new FirstExecutor(latch));
		});
		executorService.shutdown();
		latch.await();
	}
}
