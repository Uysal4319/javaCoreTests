package dataTypesOperations.enums;

import java.util.*;

public enum Classification {
	
	VERTEBRATES(10, "vertebrates"),
	INVERTEBRATES(3, "invertebrates"),
	MOLLUSK_FAMILY(7, "mollusk"),
	SIMPLE_ANIMALS(0, "simple");
	
	private final int classificationId;
	private final String prefix;
	
	
	private static final List<Classification> classifications = Arrays.asList(values());

	private Classification(int classificationId, String prefix) {
		this.classificationId = classificationId;
		this.prefix = prefix;
	}
	
	public int getClassificationId() {
		return classificationId;
	}
	public String getPrefix() {
		return prefix;
	}
	
	public static Classification valueOf(int ClassificationId){
		for (Classification item : classifications){
			if (item.classificationId == ClassificationId) {
				return item;
			}
		}
		return null;
	}
	
	
	public static final List<Classification> classificationList =Arrays.asList(values());
	
	public static final Map<String, List<Integer>> classificationsMap = new HashMap<>();
	
	public static Map<String, List<Integer>> getClassificationsMap(){
		if (classificationsMap.isEmpty()) {
			generatePrmPdTypesMap();
		}
		
		return classificationsMap;
	}
	
	public static void generatePrmPdTypesMap(){
		
		for( Classification item : classificationList){
			List<Integer> values = new ArrayList<>();
			
			if (!classificationsMap.containsKey(item.prefix)) {
				values.add(item.classificationId);
				classificationsMap.put(item.prefix,values);
			}else {
				values = classificationsMap.get(item.prefix);
				values.add(item.classificationId);
				classificationsMap.put(item.prefix,values);
			}
		}
	}
}
