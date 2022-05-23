package dataTypesOperations.custom;

public enum CustomDataType {
	;
	private static final int max = 10;
	private static final int min = 5;
	private static int value = min;
	
	public static synchronized int  incrementValue(){
		if (value > max){
			value = min;
		}
		return value++;
	}
	public static int getValue() {
		return value;
	}
}
