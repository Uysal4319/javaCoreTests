package effectiveJava.compositions;

import java.util.ArrayList;
import java.util.List;

public class AutoGallery {
	private List<Car> cars = new ArrayList<>();
	
	public AutoGallery(List<Car> cars) {
		this.cars = cars;
	}
	
	public List<Car> getCars() {
		return cars;
	}
}
