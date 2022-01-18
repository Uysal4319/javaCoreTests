package effectiveJava.interfaces;

public class Jcb extends Vehicle implements FuelStatusMonitoring {
	private static final int generatorFuelLimit = 3;
	
	public Jcb(int passengerCount, int averageFuelSpend) {
		super(passengerCount, averageFuelSpend);
	}
	
	@Override
	public int fuelCostCalculate() {
		return (getAverageFuelSpend() + generatorFuelLimit) * 6;
	}
}
