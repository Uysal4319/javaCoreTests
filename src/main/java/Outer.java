public class Outer {
	public static void main(String[] args) {
		System.out.println("begin");
		outer:
		for (int i = 0; i < 10; i++) {
			System.out.println("i = " + i);
			breakpoint:
			for (int j = 0; j < 10; j++) {
				System.out.println("i =" + i + " j =" + j);
				for (int k = 0; k < 10; k++) {
					System.out.println("i =" + i + " j =" + j + " k =" + k);
					if (System.currentTimeMillis() % 2 == 0) {
						break breakpoint;
					} else {
						break outer;
					}
				}
			}
		}
	}
}
