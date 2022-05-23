package oopBasics.classes;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Human {
	int age;
	String name;
	
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
	
	@Override
	public String toString() {
		return "Human{" +
				"age=" + age +
				", name='" + name + '\'' +
				'}';
	}
}
