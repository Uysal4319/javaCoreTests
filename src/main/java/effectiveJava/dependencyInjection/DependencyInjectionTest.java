package effectiveJava.dependencyInjection;

import java.util.function.Supplier;

public class DependencyInjectionTest {
	public static void main(String[] args) {
		Supplier<Animal> cat = () -> new Cat("pamuk");
		System.out.println(cat.get().getName());
		
		AnimalVaccineService vaccineService = new AnimalVaccineService(new Cat("minnoş"));
		System.out.println(vaccineService.vaccinated());
		
		// LAMBDA FUNCTION
		Supplier<String> supplier = () -> "Ertuğrul";
		System.out.println(supplier.get());
		
		// lambda function method lari variable gibi kullanmamizi sagliyor.
		Supplier<Integer> length = () -> UtilityClass.stringLengthSizeCalculatorMethod("Hello World");
		System.out.println(length.get());
		
		double randomNumber = Math.random();
		System.out.println(randomNumber);
		
		Supplier<Double> randomSupplier = Math::random;
		System.out.println(randomSupplier.get());
		System.out.println(randomSupplier.get());
		System.out.println(randomSupplier.get());
	}
}
