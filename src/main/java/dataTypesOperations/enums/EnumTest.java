package dataTypesOperations.enums;

import java.util.HashMap;
import java.util.Map;

public class EnumTest {
	
	public static void main(String[] args) {
//		printEnumAttributes();
//		testEnumMapOperation();
//		performanceCauses();
		enumGetName();
		
	}
	
	public static void enumGetName(){
		System.out.println(Status.getByName("OPEN"));
	}
	public static void printEnumAttributes() {
		System.out.println(Status.hello);
		System.out.println(Status.OPEN.getValue());
		System.out.println(Status.OPEN.toString());
		System.out.println("ordinal: " + Status.OPEN.ordinal());
		System.out.println("Operator : " + getOperatorCode(1));
		System.out.println(AnimalConstants.AnimalFeedType.MEAT_BYPRODUCTS.toString());
		
		System.out.println(AnimalConstants.TypesOfCats.BENGAL_CAT.toString());
	}
	
	public static void testEnumMapOperation(){
		Map<String,String> map = new HashMap<>();
		map.put("follow_laser","PET");
		map.put("catch_plate","true");
		
		if (map.get(AnimalConstants.AnimalTalentNames.follow_laser.toString()).equals(AnimalConstants.AnimalTypes.PET.toString())) {
			System.out.println("True map enum");
		}
		if (map.get(AnimalConstants.AnimalTalentNames.catch_plate.name()).equalsIgnoreCase(AnimalConstants.trueString)){
			System.out.println("catch_plate : true");
		}
		
		Classification.getClassificationsMap();
		Classification.getClassificationsMap();
		System.out.println("catch_plate : " + AnimalConstants.AnimalTalentNames.catch_plate);
	}
	public static void performanceCauses() {
		long startTimeFetchMap = System.currentTimeMillis();
		Kpi.fetchCauseKpiIdMap();
		long endTimeFetchMap = System.currentTimeMillis();
		
		System.out.println("Map generate time: " + (endTimeFetchMap - startTimeFetchMap) + "ms");
		
		long startTime = System.currentTimeMillis();
		System.out.println(Classification.valueOf(0).getPrefix());
		long endTime = System.currentTimeMillis();
		System.out.println(Kpi.getKpiID(7, 6));
		
		System.out.println(Kpi.getKpiIdFromMap("7_6"));
		
		 endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime) + "ms");
	}
	
		
	public static String getOperatorCode(int operatorId){
		if (operatorId == AnimalConstants.TypesOfCats.ABYSSINIAN_CAT.getCatTypes()){
			return AnimalConstants.TypesOfCats.ABYSSINIAN_CAT.getCatCode();
		} else if (operatorId == AnimalConstants.TypesOfCats.BENGAL_CAT.getCatTypes()) {
			return AnimalConstants.TypesOfCats.BENGAL_CAT.getCatCode();
		} else if (operatorId == AnimalConstants.TypesOfCats.BURMESE_CAT.getCatTypes()) {
			return AnimalConstants.TypesOfCats.BURMESE_CAT.getCatCode();
		}
		return null;
	}
}


