package fileOperations;

import fileOperations.zipper.Zipper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class FileCreator {
	
	public static void main(String[] args) throws Exception {
		List<String> list = Arrays.asList("args", "hello", "world", "java", "stream");
		try {
			FileWriter fl = new FileWriter("src/main/resources/report.txt", false);
			BufferedWriter bw = new BufferedWriter(fl);
			IntStream.range(1, 1000).forEach(i -> {
				try {
					bw.append(String.valueOf(i));
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			bw.close();
			
			Zipper.tarGZip("src/main/resources/report.txt");
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
