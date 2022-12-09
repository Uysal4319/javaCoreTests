package oopBasics.classes;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="human")
public class Human {
	int age;
	String name;
	String country;
	
	public Human() {
		// TODO document why this constructor is empty
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return "Human{" +
				"age=" + age +
				", name='" + name + '\'' +
				", country='" + country + '\'' +
				'}';
	}
}
