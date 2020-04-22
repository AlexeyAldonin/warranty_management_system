package ru.javaprojectkazan.enums;

public enum PartParameter {

    PART_NUMBER("part_number"),
    PART_NAME("part_name"),
    PART_PRICE("part_price")
    ;

    private String name;

    PartParameter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
