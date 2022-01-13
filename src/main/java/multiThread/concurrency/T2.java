package multiThread.concurrency;

public class T2 implements Runnable {
    private Chat m;
    private String[] s = {"Hi", "I am good, what about you?", "Great!"};

    public T2(Chat m1) {
        this.m = m1;
        new Thread(this, "Answer").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < s.length; i++) {
            m.Answer(s[i]);
        }
    }
}
