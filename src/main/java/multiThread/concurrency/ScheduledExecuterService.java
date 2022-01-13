package multiThread.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecuterService {

        public static void main(final String[] arguments) throws InterruptedException {
            final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

            final ScheduledFuture<?> beepHandler =
                    scheduler.scheduleAtFixedRate(new BeepTask(), 1, 1, TimeUnit.SECONDS);

            scheduler.schedule(new Runnable() {

                @Override
                public void run() {
                    beepHandler.cancel(true);
                    scheduler.shutdown();
                }
            }, 10, TimeUnit.SECONDS);
        }

        static class BeepTask implements Runnable {

            public void run() {
                System.out.println("beep");
            }
        }

}
