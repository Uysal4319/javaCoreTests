public class TryCatch {
	
	public static void main(String[] args) {
//        whileTrue();
//		catchOperation();
		finallyScopeTest();
	}
	
	public static void finallyScopeTest() {
		try {
			boolean flag = false;
			if (flag) {
				System.out.println("flag true");
			} else {
				throw new NullPointerException();
			}
		} finally {
			System.out.println("finally trigger");
		}
	}
	
	public static void catchOperation() {
		String string = null;
		try {
			string.startsWith("123");
			String[] split = string.split(",");
			System.out.println(split[6]);
		} catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
			System.out.println("karisik" + e);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void whileTrue() {
		boolean killThread = false;
		int i = 0;
		while (true) {
			i++;
			try {
				if (killThread) {
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (i == 5) {
				killThread = true;
			}
		}
	}
}
