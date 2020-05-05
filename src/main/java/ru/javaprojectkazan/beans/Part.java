package ru.javaprojectkazan.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Part {
    private int catalogueNumber;
    private String partName;
    private double price;

    public Part(String partName, int catalogueNumber, double price) {
        this.partName = partName;
        this.catalogueNumber = catalogueNumber;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Part{" +
                "catalogueNumber=" + catalogueNumber +
                ", partName='" + partName + '\'' +
                ", price=" + price +
                '}';
    }
}
