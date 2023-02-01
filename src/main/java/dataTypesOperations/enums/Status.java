package dataTypesOperations.enums;

public enum Status {

    OPEN(-1), CLOSE(0), ONLY_FAIL(1);
    
    public static final String hello = "Hello World";

    private final int value;

    Status(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
	
	public static Status getByName(String name) {
		Status[] test = Status.values();
		for (Status status : test) {
			if (name.equals(status.name())) {
				return status;
			}
		}
		return null;
	}
}
