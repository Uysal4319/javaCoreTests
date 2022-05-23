package dataTypesOperations.enums;

public enum TestEnum {

    OPEN(-1), CLOSE(0), ONLY_FAIL(1);
    
    public static final String hello = "Hello World";

    private final int value;

    TestEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
