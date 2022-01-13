package java8tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class AtomicTest {

    public static void main(String[] args) throws IOException, InterruptedException {

        Globals.getInstance().initialize();
        CountDownLatch latch = new CountDownLatch(5);
        ArrayList<Filter> threads =new ArrayList<>();

        threads.add(new Filter("Thread-1",latch));
        threads.add(new Filter("Thread-2",latch));
        threads.add(new Filter("Thread-3",latch));
        threads.add(new Filter("Thread-4",latch));
        threads.add(new Filter("Thread-5",latch));

        for (Filter filter : threads){
            filter.start();
        }
        latch.await();
        System.out.println(Globals.counter);
        System.out.println(Globals.atomicCounter);
    }
}
