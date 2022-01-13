package multiThread.concurrency;

public class ThreadDemo extends Thread {
    private String threadName;
    private Thread thread;

    ThreadDemo(String name){
        threadName = name;
        System.out.println("crating "+ threadName);
    }

    public void run(){
        System.out.println("running "+ threadName);

        try {

            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);

                // Let the thread sleep for a while.
                Thread.sleep(50);


            }
        } catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }

        System.out.println("Thread "+threadName+" existing");
    }

    public void start(){
        System.out.println("Starting "+ threadName);
        if (thread == null){
            thread = new Thread(this,threadName);
            thread.start();
        }

    }

}
