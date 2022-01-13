package oopBasics.abstractions;

public class HrPerson extends Employee{
	private String experience;
	public HrPerson(String name, int age, String positions, String experience) {
		super(name, age, positions);
		this.experience =experience;
	}
	
	public String getExperience() {
		return experience;
	}
	
	public void setExperience(String experience) {
		this.experience = experience;
	}
}
