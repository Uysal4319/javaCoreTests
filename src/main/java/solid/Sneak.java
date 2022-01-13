package solid;

public class Sneak extends BaseAnimal implements CrawlAble{
	public Sneak(String name, int age, int foodCount) {
		super(name, age, foodCount);
	}
	
	@Override
	public int getDailyFeetCost() {
		return 2;
	}
	
	@Override
	public void crawl() {
		System.out.println("Sneak can Crawl");
	}
}
