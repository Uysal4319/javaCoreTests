package multiThread;

public class MultiThreadExample {
	public static void main(String[] args) {
		ProcessThread thread = new ProcessThread();
		thread.start();
		ProcessThread thread1 = new ProcessThread();
		thread1.start();
		ProcessThread thread2 = new ProcessThread();
		ProcessThread thread3 = new ProcessThread();
		ProcessThread thread4 = new ProcessThread();
		ProcessThread thread5 = new ProcessThread();
		ProcessThread thread6 = new ProcessThread();
		ProcessThread thread7 = new ProcessThread();
		ProcessThread thread8 = new ProcessThread();
		
		
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
		thread7.start();
		thread8.start();
	}
}
