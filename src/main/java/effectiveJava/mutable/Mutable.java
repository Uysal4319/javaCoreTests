package effectiveJava.mutable;

public class Mutable {
	private int realValue;
	
	public Mutable(int value) {
		realValue = value; 
	}
	
	public int getRealValue() {
		return realValue;
	}
	
	public void setValue(int newValue) {
		realValue = newValue;
	}
	
}
