package oopBasics.abstractions;

public abstract class Employee {
	
	private String name;
	private int age;
	private String positions;
	
	public Employee(String name, int age, String positions) {
		this.name = name;
		this.age = age;
		this.positions = positions;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getPositions() {
		return positions;
	}
	
	public void setPositions(String positions) {
		this.positions = positions;
	}
}
