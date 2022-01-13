package solid;

public class Bird extends BaseAnimal implements FlyAble, RunAble {
	public Bird(String name, int age, int foodCount) {
		super(name, age, foodCount);
	}
	
	@Override
	public int getDailyFeetCost() {
		return 1;
	}
	
	@Override
	public void fly() {
		System.out.println("Bird Can Fly.");
	}
	
	@Override
	public void run() {
		System.out.println("Bird Can Run.");
	}
}
