package fileOperations;

import utils.TestUtilities;

import java.io.*;

public class FileOperations {
	public static void main(String[] args) throws IOException {
		File file = new File("src/main/resources/human.txt");
		System.out.println(TestUtilities.getFileContent(file));
	}
}
