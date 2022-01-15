package effectiveJava.overriding;

public class ExampleOverridingClass {
	private int a,b;
	
	public ExampleOverridingClass(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public int getA() {
		return a;
	}
	
	public void setA(int a) {
		this.a = a;
	}
	
	public int getB() {
		return b;
	}
	
	public void setB(int b) {
		this.b = b;
	}
	
	@Override
	public boolean equals(Object o){
		if(o == this){
			return true;
		}
		
		if(!(o instanceof ExampleOverridingClass)){
			return false;
		}
		
		return Integer.compare(a,((ExampleOverridingClass) o).a) == 0
				&& Integer.compare(b,((ExampleOverridingClass) o).b) == 0;
	}
	
	@Override
	public int hashCode(){
		int result = Integer.hashCode(b);
		result = 41 * result + Integer.hashCode(b);
		return result;
	}
}
