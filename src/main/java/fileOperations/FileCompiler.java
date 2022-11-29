package fileOperations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileCompiler {
	
	
	public static void main(String[] args) throws IOException {
		Path directory = Paths.get("src/main/resources/text.txt");
		List<String> wordsFile = Files.readAllLines(directory);
		
		Path directory1 = Paths.get("src/main/resources/text1.txt");
		List<String> wordsFile1 = Files.readAllLines(directory1);
		
		System.out.println("file to file1 diff : " );

		for (String element : wordsFile){
			if(! wordsFile1.contains(element)){
				System.out.println(element);
			}
		}
		
		System.out.println("file1 to file diff : " );
		
		for (String element : wordsFile1){
			if(! wordsFile.contains(element)){
				System.out.println(element);
			}
		}
	}
}
