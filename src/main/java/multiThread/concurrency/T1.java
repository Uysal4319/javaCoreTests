package multiThread.concurrency;

public class T1 implements Runnable {
    private Chat m;
    private String[] s1 = {"Hi", "How are you ?", "I am also doing fine!"};

    public T1(Chat m1) {
        this.m = m1;
        new Thread(this, "Question").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < s1.length; i++) {
            m.Question(s1[i]);
        }
    }
}
