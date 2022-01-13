package solid;

public abstract class BaseAnimal {
	public String name;
	public int foodCount;
	public int age;
	
	public BaseAnimal(String name, int age, int foodCount) {
		this.name = name;
		this.age = age;
		this.foodCount = foodCount;
	}
	
	public abstract int getDailyFeetCost();
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getFoodCount() {
		return foodCount;
	}
	
	public void setFoodCount(int foodCount) {
		this.foodCount = foodCount;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}
