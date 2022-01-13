package oopBasics.generics;

public class BoxErasure {
	private Number t;
	
	public void add(Number t) {
		this.t = t;
	}
	
	public Number get() {
		return t;
	}
}
