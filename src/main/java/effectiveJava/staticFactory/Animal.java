package effectiveJava.staticFactory;

public class Animal {
	private String name;
	
	public static Animal wild(String name){
		return new Lion(name);
	}
	
	public static Animal pet(String name){
		return new Cat(name);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
