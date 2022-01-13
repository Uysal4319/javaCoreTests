package solid;

public class Cow extends BaseAnimal implements RunAble {
	public Cow(String name, int age, int foodCount) {
		super(name, age, foodCount);
	}
	
	@Override
	public int getDailyFeetCost() {
		return 5;
	}
	
	@Override
	public void run() {
		System.out.println("Cow can Run.");
	}
}
