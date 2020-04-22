package ru.javaprojectkazan.beans;

public class RepairOperation {

    private int hourPrice;
    private int code;
    private String name;

    public RepairOperation(int code, String name, int hourPrice) {
        this.hourPrice = hourPrice;
        this.code = code;
        this.name = name;
    }

    public int getHourPrice() {
        return hourPrice;
    }

    public void setHourPrice(int hourPrice) {
        this.hourPrice = hourPrice;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
