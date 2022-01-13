package effectiveJava.staticFactory;

public class StaticFactoryTest {
	public static void main(String[] args) {
		Animal pet = Animal.pet("boncuk");
		Animal wild = Animal.wild("lion");
		
		System.out.println(pet.getName());
		System.out.println(wild.getName());
		
	}
}
