package multiThread.concurrency;

public class RunnableDemo implements Runnable {
    private String threadName ;
    public Thread t;
    private boolean suspended =false ;

    RunnableDemo(String name){
        this.threadName = name;
        System.out.println("Creating " +name);


    }


    @Override
    public void run() {
        System.out.println("Running : "+ threadName );
        try {

            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);

                // Let the thread sleep for a while.
                Thread.sleep(50);

                synchronized(this) {

                    while(suspended) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");

    }

    public void start(){
        System.out.println("Starting "+ threadName);
        if (t ==null){
            t =new Thread(this,threadName);
            t.start();
        }

    }
    void suspend() {
        suspended = true;
    }

    synchronized void resume() {
        suspended = false;
        notify();
    }
}
