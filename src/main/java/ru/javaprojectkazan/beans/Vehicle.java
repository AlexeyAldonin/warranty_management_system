package ru.javaprojectkazan.beans;

import java.util.Calendar;
import java.util.Date;

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


    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getDispatchDate() {
        return dispatchDate;
    }

    public void setDispatchDate(Date dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    public Date getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(Date soldDate) {
        this.soldDate = soldDate;
    }

    public int getMileageAtLastClaim() {
        return mileageAtLastClaim;
    }

    public void setMileageAtLastClaim(int mileageAtLastClaim) {
        this.mileageAtLastClaim = mileageAtLastClaim;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vin='" + vin + '\'' +
                '}';
    }
}