package ru.javaprojectkazan.beans;

public class RepairOperation {

    private double hourPrice;
    private int code;
    private String name;

    public RepairOperation(int code, String name, int hourPrice) {
        this.hourPrice = hourPrice;
        this.code = code;
        this.name = name;
    }

    public double getHourPrice() {
        return hourPrice;
    }

    public void setHourPrice(double hourPrice) {
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

    @Override
    public String toString() {
        return "RepairOperation{" +
                "hourPrice=" + hourPrice +
                ", code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}
