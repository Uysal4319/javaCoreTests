package dataTypesOperations.enums;

public enum TestEnum {

    OPEN(-1), CLOSE(0), ONLY_FAIL(1);

    private final int value;

    TestEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
