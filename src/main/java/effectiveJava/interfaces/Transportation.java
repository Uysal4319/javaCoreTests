package effectiveJava.interfaces;

public interface Transportation {
	default int minPassengerCount() {
		return 1;
	}
	
}
