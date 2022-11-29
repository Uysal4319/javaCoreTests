import java.util.Arrays;

public class HeapInspection {
	
	private static String pass = "password";
	public static void main(String[] args) {
		final char[] password = pass.toCharArray();
		System.out.println(password);
		String passwordAsString = new String(password);
		Arrays.fill(password, ' ');
		System.out.println(password);
		System.out.println("to String " + passwordAsString);
	}
}
