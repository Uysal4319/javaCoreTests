package effectiveJava.compositions;

import java.util.ArrayList;
import java.util.List;

public class CompositionTest {
	public static void main(String[] args) {
		List<Car> carList = new ArrayList<>();
		carList.add(new Car("BMW"));
		carList.add(new Car("Mercedes"));
		
		AutoGallery autoGallery = new AutoGallery(carList);
		autoGallery.getCars().forEach((item)-> System.out.println(item.getModel()));
	}
}
