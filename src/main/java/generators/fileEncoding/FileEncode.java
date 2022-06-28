package generators.fileEncoding;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileEncode {
	
	public static void main(String[] args) throws IOException {
		encode();
		decode();
	}
	
	public static void encode() throws IOException {
		String text = "ErtuĞrul ün türkçe karakter testı yapışı";
		File createdFile = new File("src/main/java/generators/fileEncoding/employee.dat");
		FileOutputStream writer = null;
		try {
			writer = new FileOutputStream(createdFile, true);
			writer.write(text.getBytes("UTF-8"));
			System.out.println("File write process finish.");
		} catch (Throwable e) {
			e.printStackTrace();
			
		} finally {
			if (writer != null) {
				writer.flush();
				writer.close();
			}
		}
	}
	
	public static void decode() throws IOException {
		try (FileInputStream fis = new FileInputStream(new File("src/main/java/generators/fileEncoding/employee.dat"));
			 InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
			 BufferedReader reader = new BufferedReader(isr)
		) {
			String str;
			while ((str = reader.readLine()) != null) {
				System.out.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
