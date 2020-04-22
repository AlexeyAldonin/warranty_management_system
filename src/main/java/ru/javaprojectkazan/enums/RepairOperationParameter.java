package ru.javaprojectkazan.enums;

public enum RepairOperationParameter {
    OPERATION_NUMBER("operation_id"),
    OPERATION_NAME("operation_name"),
    OPERATION_PRICE("price")
    ;

    private String name;

    RepairOperationParameter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
