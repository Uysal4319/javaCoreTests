package oopBasics.abstractions;

public class ItPerson extends Employee {
	private int salary;
	public ItPerson(String name, int age, String positions,int salary) {
		super(name, age, positions);
		this.salary = salary;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
}
