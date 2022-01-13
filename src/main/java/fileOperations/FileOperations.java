package fileOperations;

import java.io.*;

public class FileOperations {
	
	public static void main(String[] args) throws IOException {
		File file = new File("src/main/resources/human.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String         line = null;
		StringBuilder  stringBuilder = new StringBuilder();
		String         ls = System.getProperty("line.separator");
		try {
			while((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}
			System.out.println(stringBuilder.toString());
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		} finally {
			reader.close();
		}
	}
	
	public static String loadHuman() throws IOException {
		File file = new File("./resources/simFiles/human.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String         line = null;
		StringBuilder  stringBuilder = new StringBuilder();
		String         ls = System.getProperty("line.separator");
		try {
			while((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}
			return stringBuilder.toString();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		} finally {
			reader.close();
		}
		return "";
	}
}
