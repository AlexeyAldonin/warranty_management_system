package ru.javaprojectkazan.beans;

public class Part {
    private int catalogueNumber;
    private String partName;
    private double price;

    // TODO getter & setter for partCost, catalogueNumber, partName...

    public Part(String partName, int catalogueNumber, double price) {
        this.partName = partName;
        this.catalogueNumber = catalogueNumber;
        this.price = price;
    }

    public int getCatalogueNumber() {
        return catalogueNumber;
    }

    public void setCatalogueNumber(int catalogueNumber) {
        this.catalogueNumber = catalogueNumber;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
