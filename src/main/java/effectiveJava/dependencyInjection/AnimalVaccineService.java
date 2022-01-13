package effectiveJava.dependencyInjection;


public class AnimalVaccineService {
	private final Animal animal;
	
	public AnimalVaccineService(Animal animal) {
		this.animal = animal;
	}
	public boolean vaccinated(){
		return true;		
	}
}
