package ru.javaprojectkazan.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RepairOperation {

    private double hourPrice;
    private int code;
    private String name;

    public RepairOperation(int code, String name, int hourPrice) {
        this.hourPrice = hourPrice;
        this.code = code;
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
