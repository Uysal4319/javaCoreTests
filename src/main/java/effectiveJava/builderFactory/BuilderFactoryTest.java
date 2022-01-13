package effectiveJava.builderFactory;

public class BuilderFactoryTest {
	public static void main(String[] args) {
		SaladShop saladShop = new SaladShop.Builder(1,"small")
				.oilType("olive")
				.tomato(false)
				.paper(true).build();
		
		System.out.println(saladShop.getOrderID());
		System.out.println(saladShop.getSize());
		System.out.println(saladShop.getOilType());
		System.out.println(saladShop.isTomato());
		System.out.println(saladShop.isPaper());
	}
}
