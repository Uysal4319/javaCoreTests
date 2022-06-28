import java.util.Scanner;

public class WhileFor {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		forFor(n);
		forWhile(n);
	}
	
	public static void forFor(int n) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			count ++;
		}
		System.out.println("for count:" + count);
	}
	
	public static void forWhile(int n) {
		int count = 0;
		while (0 < n--) {
			count++;
		}
		System.out.println("while count:" + count);
	}
}
