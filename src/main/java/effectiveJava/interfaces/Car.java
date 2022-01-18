package effectiveJava.interfaces;

public class Car extends Vehicle implements FuelStatusMonitoring {
	
	public Car(int passengerCount, int averageFuelSpend) {
		super(passengerCount, averageFuelSpend);
	}
	
	@Override
	public int fuelCostCalculate() {
		return getAverageFuelSpend() * 6;
	}
}
