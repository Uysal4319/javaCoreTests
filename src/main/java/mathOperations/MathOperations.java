package mathOperations;

public class MathOperations {
	
	public static void main(String[] args) {
		
		int accumulatedDuration = 120;
		
		int accumulatedDurationRoundedToSec = Math.round(((float) (int) accumulatedDuration) / 10);
		System.out.println(accumulatedDurationRoundedToSec);
		
		System.out.println((((10 - 20) - 5) * 100) / 10);
	}
}
