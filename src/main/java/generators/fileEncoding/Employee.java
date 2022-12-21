package generators.fileEncoding;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class Employee {
	private int id;
	private String name;
	private String surName;
	private int age;
	private Date birthDay;
	private String department;
	private PriceType priceHeader;
	
	public Employee() {
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurName() {
		return surName;
	}
	
	public void setSurName(String surName) {
		this.surName = surName;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public Date getBirthDay() {
		return birthDay;
	}
	
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public PriceType getPriceHeader() {
		return priceHeader;
	}
	
	public void setPriceHeader(PriceType priceHeader) {
		this.priceHeader = priceHeader;
	}
	
	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", name='" + name + '\'' +
				", surName='" + surName + '\'' +
				", age=" + age +
				", birthDay=" + birthDay +
				", department='" + department + '\'' +
				", priceType=" + priceHeader +
				'}';
	}
}
