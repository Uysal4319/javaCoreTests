package effectiveJava.lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class AnagramsTest {
	
	public static void main(String[] args) throws IOException {
		Path directory = Paths.get("src/main/resources/text.txt");
		int minGroupSize = 1;
		try (Stream<String> words = Files.lines(directory)) {
			words.collect(groupingBy(AnagramsTest::alphabetize))
					.values().stream()
					.filter(group -> group.size() >= minGroupSize)
					.forEach(g -> System.out.println(g.size() + " : " + g));
			
		}
	}
	
	private static String alphabetize(String s) {
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
}
