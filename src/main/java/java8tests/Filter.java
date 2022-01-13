package java8tests;

import java.util.concurrent.CountDownLatch;

public class Filter extends Thread {
    private String threadName;
    public Thread t ;
    private CountDownLatch latch;

    Filter(String name, CountDownLatch latch){
        this.threadName =name;
       this.latch =latch;
    }

    @Override
    public void run() {

        System.out.println("running "+ threadName);
        Operations.count(Globals.persons);
        System.out.println("Thread "+threadName+" existing");
        latch.countDown();
    }
    public void start(){
        System.out.println("Starting "+ threadName);
        if (t == null){
            t = new Thread(this,threadName);
            t.start();
        }

    }
}
