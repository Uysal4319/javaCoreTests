package effectiveJava.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StreamsTests {
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("hello","world","and","streams");
		
		list.stream().filter(s-> s.startsWith("s"))
				.map(String::toUpperCase).forEach(System.out::println );
		
		Arrays.stream(new int[] {1,2}).map(n -> 4*n +1).average().ifPresent(System.out::println);
		
		// for ile aynı islemi 
		IntStream.range(0,5).forEach(System.out::println);
		
		System.out.println(IntStream.range(0,11).max().getAsInt());
	}
}
