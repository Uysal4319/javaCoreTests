package effectiveJava.interfaces;

public class Vehicle implements Transportation {
	private int passengerCount;
	private int averageFuelSpend;
	
	public Vehicle(int passengerCount, int averageFuelSpend) {
		this.passengerCount = passengerCount;
		this.averageFuelSpend = averageFuelSpend;
	}
	
	public int getPassengerCount() {
		return passengerCount;
	}
	
	public void setPassengerCount(int passengerCount) {
		this.passengerCount = passengerCount;
	}
	
	public int getAverageFuelSpend() {
		return averageFuelSpend;
	}
	
	public void setAverageFuelSpend(int averageFuelSpend) {
		this.averageFuelSpend = averageFuelSpend;
	}
}
