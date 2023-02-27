package oopBasics;

import java.util.stream.IntStream;

public class SequenceHolder {
	private static int sequence = 1;
	
	public static void main(String[] args) {
		IntStream.range(0, 5000).forEach(i -> {
//			System.out.println(sequence++);
			String formattedNum = String.format("%010d", sequence++);
			System.out.println(formattedNum);
		});
	}
}
