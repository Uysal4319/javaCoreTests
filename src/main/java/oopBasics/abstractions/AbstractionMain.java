package oopBasics.abstractions;

public class AbstractionMain {
	public static void main(String[] args) {
		HrPerson hrPerson = new HrPerson("ert",23,"HumanResource","Person Issues");
		ItPerson itPerson = new ItPerson("ertugrul",25,"Software Developer",2000);
		
		printSalary(itPerson);
		printAge(itPerson);
		printAge(hrPerson);
		
	}
	
	public static void printSalary(Employee employee){
		if (employee instanceof ItPerson) {
			System.out.println(((ItPerson) employee).getSalary());
		} else if (employee instanceof HrPerson) {
			System.out.println("Salary info not found !");
		}
	}
	
	public static void printAge(Employee employee){
		System.out.println(employee.getAge());
	}
}
