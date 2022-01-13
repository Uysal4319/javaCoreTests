package dataTypesOperations.enums;

public class AnimalConstants {

	public static String trueString = "true";
	public static String falseString = "false";
	
	public enum AnimalTypes {
		WILD, PET; 
	}
	
	public enum AnimalTalentNames {
		roll_ball,
		follow_laser,
		catch_plate;
	}
	
	public enum AnimalFeedType {
		
		MEAT_BYPRODUCTS("1"),
		FISH_MEAL("2"),
		MILK_PRODUCTS("3");
		
		public String animalFeedType;
	    
	    private AnimalFeedType(String animalFeedType) {
	        this.animalFeedType = animalFeedType;
	    }

		public String getAnimalFeedType() {
			return animalFeedType;
		}

		public void setAnimalFeedType(String animalFeedType) {
			this.animalFeedType = animalFeedType;
		}
	}
	
	public enum TypesOfCats {
		
		ABYSSINIAN_CAT(1,"B002"),
		BENGAL_CAT(2,"B003"),
		BURMESE_CAT(3,"B001");
		
		public int catTypes;
		public String catCode;
		
		private TypesOfCats(int catTypes, String catCode) {
			this.catTypes = catTypes;
			this.catCode = catCode;
		}
		
		public int getCatTypes() {
			return catTypes;
		}
		
		public void setCatTypes(int operatorType) {
			this.catTypes = operatorType;
		}
		
		public String getCatCode() {
			return catCode;
		}
		
		public void setCatCode(String catCode) {
			this.catCode = catCode;
		}
	}
	
}
