package ru.javaprojectkazan.enums;

public enum DBProperty {

    DRIVER_NAME("driver_name"),
    URL("url"),
    USER("user"),
    PSSWD("password");

    private String property;

    DBProperty(String property) {
        this.property = property;
    }

    public String getProperty() {
        return property;
    }
}
