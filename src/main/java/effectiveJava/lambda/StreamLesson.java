package effectiveJava.lambda;

import java.util.Arrays;
import java.util.List;

public class StreamLesson {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("args", "hello","world","java","stream");
		list.stream().filter(item ->item.startsWith("s")).forEach(System.out::println);
	}
}
