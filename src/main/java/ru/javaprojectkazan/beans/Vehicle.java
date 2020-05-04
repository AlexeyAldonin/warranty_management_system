package ru.javaprojectkazan.beans;

import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
public class Vehicle {
    private String vin;
    private String model;
    private Date dispatchDate;
    private Date soldDate;
    private Date warrantyExpireDate;
    private int mileageAtLastClaim;

    public Vehicle() {}

    public Vehicle(String vin, String model, Date dispatchDate, Date soldDate,
                   Date warrantyExpireDate, int mileageAtLastClaim) {
        this.vin = vin;
        this.model = model;
        this.dispatchDate = dispatchDate;
        this.soldDate = soldDate;
        this.warrantyExpireDate = warrantyExpireDate;
        this.mileageAtLastClaim = mileageAtLastClaim;
    }

    public Vehicle(String vin, String model, Date dispatchDate, Date soldDate, int mileageAtLastClaim) {
        this.vin = vin;
        this.model = model;
        this.dispatchDate = dispatchDate;
        this.soldDate = soldDate;
        this.warrantyExpireDate = getWarrantyExpireDateDate(soldDate);
        this.mileageAtLastClaim = mileageAtLastClaim;
    }

    public Vehicle(String vin, String model, Date dispatchDate) {
        this.vin = vin;
        this.model = model;
        this.dispatchDate = dispatchDate;
        this.soldDate = dispatchDate;
        this.warrantyExpireDate = getWarrantyExpireDateDate(soldDate);
        this.mileageAtLastClaim = 0;
    }

    public Date getWarrantyExpireDateDate (Date soldDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(soldDate);
        Calendar nextYear = (Calendar) calendar.clone();
        nextYear.add(Calendar.YEAR, +3);
        nextYear.add(Calendar.DAY_OF_YEAR, -1);
        return nextYear.getTime();
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vin='" + vin + '\'' +
                '}';
    }
}