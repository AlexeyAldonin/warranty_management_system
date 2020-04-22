package ru.javaprojectkazan.enums;

public enum VehicleParameter {

    VIN("vin"),
    MODEL("model"),
    DISPATCH_DATE("dispatch_date"),
    DATE_OF_SALE("date_of_sale"),
    WARRANTY_EXPIRE_DATE("warranty_expire_date"),
    MILEAGE_AT_LAST_CLAIM("mileage_at_last_claim")
    ;


    private String name;

    VehicleParameter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
