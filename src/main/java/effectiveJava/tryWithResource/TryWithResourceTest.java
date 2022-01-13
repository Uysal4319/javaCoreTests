package effectiveJava.tryWithResource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TryWithResourceTest {
	
	public static void main(String[] args) {
		
		try {
			String[] array = new String[2];
			array[3] = "sfasdf";
		} catch (NullPointerException e) {
			System.out.println("catch");
		} finally {
			String[] array = new String[2];
			array[3] = "sfasdf";
			System.out.println("finally");
		}
		
		try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources/human.txt")))) {
			System.out.println("reader running ");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("finally");
		}
	}
}
