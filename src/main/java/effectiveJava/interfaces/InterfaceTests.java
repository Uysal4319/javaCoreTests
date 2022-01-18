package effectiveJava.interfaces;

public class InterfaceTests {
	public static void main(String[] args) {
		// default tanımlı
		Car car = new Car(4,2);
		System.out.println(car.minPassengerCount());
		
		// interface refer initialize 
		Transportation car1 = new Car(3,3);
		car1.minPassengerCount();
		
		// usage java class hierarchies
		Bmw bmw = new Bmw(4,5);
		System.out.println(bmw.fuelCostCalculate());
		
		Jcb jcb = new Jcb(1,7);
		System.out.println(jcb.fuelCostCalculate());
		
	}
}
