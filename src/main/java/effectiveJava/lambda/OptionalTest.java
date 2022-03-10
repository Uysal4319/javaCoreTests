package effectiveJava.lambda;

import effectiveJava.annotations.Sample;

import java.util.Optional;

public class OptionalTest {
	
	/**
	 * Bu class optional kullanımının önemini göstermek için yazılmı
	 * @param args
	 */
	public static void main(String[] args) {
		Optional<Sample> sample = Optional.empty();
//		Optional<Sample> sample2 = Optional.of(null);
		Optional<Sample> sample3 = Optional.ofNullable(new Sample());
	
		sample3.ifPresent(System.out::println);
	}
}
