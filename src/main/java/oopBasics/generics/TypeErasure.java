package oopBasics.generics;

public class TypeErasure {
	public static void main(String[] args) {
		BoxErasure integerBox = new BoxErasure();
		BoxErasure doubleBox = new BoxErasure();
		integerBox.add(new Integer(10));
		doubleBox.add(new Double(10.0));
		System.out.printf("Integer Value :%d\n", integerBox.get());
		System.out.printf("Double Value :%s\n", doubleBox.get());
		System.out.println("------------------------");
		
		//Unbounded Erasure
		BoxUnbounded intBox = new BoxUnbounded();
		BoxUnbounded sBox = new BoxUnbounded();
		intBox.add(new Integer(10));
		sBox.add(new String("Hello World"));
		System.out.printf("Integer Value :%d\n", intBox.get());
		System.out.printf("String Value :%s\n", sBox.get());
		
	}
	
	
	//Unbounded Erasure
	static class BoxUnbounded {
		private Object t;
		
		public void add(Object t) {
			this.t = t;
		}
		
		public Object get() {
			return t;
		}
	}
}
