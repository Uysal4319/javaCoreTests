package effectiveJava.lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class FreqTest {
	
	public static void main(String[] args) throws IOException {
		Path directory = Paths.get("src/main/resources/text.txt");
		Map<String ,Long> freq = new HashMap<>();
		// HATALI KULLANIM
		try (Stream<String> words = Files.lines(directory)) {
			words.forEach(word -> {
				System.out.println("word");
				freq.merge(word.toLowerCase(),1L,Long::sum);
				});
			
		}
		System.out.println(freq);
		
		Map<String ,Long> freq2 = new HashMap<>();
		try (Stream<String> words = Files.lines(directory)) {
			freq2 = words.collect(groupingBy(String::toLowerCase,counting()));
		}
		System.out.println(freq2);
		
		List<String> list = freq.keySet().stream().sorted(Comparator.comparing(freq::get).reversed())
				.limit(10).collect(Collectors.toList());
		System.out.println(list);
	}
}
