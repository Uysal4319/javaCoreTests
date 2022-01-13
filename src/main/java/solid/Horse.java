package solid;

public class Horse extends BaseAnimal implements RideAble, RunAble{
	public Horse(String name, int age, int foodCount) {
		super(name, age, foodCount);
	}
	
	@Override
	public int getDailyFeetCost() {
		return 5;
	}
	
	@Override
	public void ride() {
		System.out.println("Horse can ridding.");
	}
	
	@Override
	public void run() {
		System.out.println("Horse can run.");
	}
}
