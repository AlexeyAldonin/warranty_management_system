package ru.javaprojectkazan.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
public class Repair {

    private int claimNumber;
    private Date dateOfRepair;
    private Vehicle vehicle;
    private int vehicleMileage;
    private Part causalPart;
    private int partQuantity;
    private double partsTotalCost;
    private RepairOperation repairOperation;
    private double repairTime;
    private double repairOperationsTotalCost;
    private double totalRepairCost;

    public Repair(Date dateOfRepair, Vehicle vehicle, int vehicleMileage, Part causalPart, int partQuantity,
                  RepairOperation repairOperation, double repairTime) {
        this.dateOfRepair = dateOfRepair;
        this.vehicle = vehicle;
        this.vehicleMileage = vehicleMileage;
        this.causalPart = causalPart;
        this.partQuantity = partQuantity;
        this.partsTotalCost = causalPart.getPrice() * partQuantity;
        this.repairOperation = repairOperation;
        this.repairTime = repairTime;
        this.repairOperationsTotalCost = repairOperation.getHourPrice() * repairTime;
        this.totalRepairCost = partsTotalCost + repairOperationsTotalCost;
    }

    public Repair(int claimNumber, Date dateOfRepair, Vehicle vehicle, int vehicleMileage, Part causalPart,
                  int partQuantity, RepairOperation repairOperation, double repairTime) {
        this.claimNumber = claimNumber;
        this.dateOfRepair = dateOfRepair;
        this.vehicle = vehicle;
        this.vehicleMileage = vehicleMileage;
        this.causalPart = causalPart;
        this.partQuantity = partQuantity;
        this.partsTotalCost = causalPart.getPrice() * partQuantity;
        this.repairOperation = repairOperation;
        this.repairTime = repairTime;
        this.repairOperationsTotalCost = repairOperation.getHourPrice() * repairTime;
        this.totalRepairCost = partsTotalCost + repairOperationsTotalCost;
    }

    public void calculatePartsTotalCost(Part part, int partQuantity) {
        this.partsTotalCost = part.getPrice() * partQuantity;
    }

    public void calculateRepairOperationsTotalCost(RepairOperation operation, double repairTime) {
        this.repairOperationsTotalCost = operation.getHourPrice() * repairTime;
    }

    public void calculateTotalRepairCost(double partsTotalCost, double repairOperationsTotalCost) {
        this.totalRepairCost = partsTotalCost + repairOperationsTotalCost;
    }

    @Override
    public String toString() {
        return "Repair{" +
                "claimNumber=" + claimNumber +
                ", dateOfRepair=" + dateOfRepair +
                ", vehicle=" + vehicle +
                ", vehicleMileage=" + vehicleMileage +
                ", causalPart=" + causalPart +
                ", partQuantity=" + partQuantity +
                ", partsTotalCost=" + partsTotalCost +
                ", repairOperation=" + repairOperation +
                ", repairTime=" + repairTime +
                ", repairOperationsTotalCost=" + repairOperationsTotalCost +
                ", totalRepairCost=" + totalRepairCost +
                '}';
    }
}

