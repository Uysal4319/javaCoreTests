package multiThread.concurrency;

public class SynchronizationTest {
    public static void main(String[] args) {
        PrintDemo pd =  new PrintDemo();

        ThreadDm t1 = new ThreadDm("Thread-1",pd);
        ThreadDm t2 =new ThreadDm("Thread-2",pd);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            System.out.println("Interrupted");
        }

    }

    static class ThreadDm extends Thread {
        private String threadName;
        private Thread t;
        private PrintDemo pd;

        ThreadDm(String name, PrintDemo pdg) {
            threadName = name;
            pd = pdg;
        }

        @Override
        public void run() {
            synchronized (pd){
                pd.printCount();
            }
            System.out.println("Thread " +  threadName + " exiting.");
        }

        public void start(){
            System.out.println("Starting " +  threadName );

            if (t == null) {
                t = new Thread (this, threadName);
                t.start ();
            }
        }
    }
}
