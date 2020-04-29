package ru.javaprojectkazan.attempts;

import ru.javaprojectkazan.beans.Part;
import ru.javaprojectkazan.beans.Repair;
import ru.javaprojectkazan.beans.RepairOperation;
import ru.javaprojectkazan.beans.Vehicle;
import ru.javaprojectkazan.dao.PartDAO;
import ru.javaprojectkazan.dao.RepairDAO;
import ru.javaprojectkazan.dao.RepairOperationDAO;
import ru.javaprojectkazan.dao.VehicleDAO;

import java.sql.Date;

public class DBAttempt2 {
    public static void main(String[] args) {

        String vin = "123456";
        String mileage = "200";
        Date repairDate = java.sql.Date.valueOf("2020-04-20");
        String partNumber = "1";
        String partQuantity = "2";
        String repairOperationId = "1";
        String hours = "2";

        PartDAO replacedPart = new PartDAO();
        Part part = replacedPart.get(Integer.parseInt(partNumber));

        VehicleDAO repairedVehicle = new VehicleDAO();
        Vehicle vehicle = repairedVehicle.get(vin);

        RepairOperationDAO operation = new RepairOperationDAO();
        RepairOperation repairOperation = operation.get(Integer.parseInt(repairOperationId));


        Repair newRepair = new Repair(repairDate, vehicle, Integer.parseInt(mileage), part, Integer.parseInt(partQuantity),
                repairOperation, Integer.parseInt(hours));

        RepairDAO currentRepair = new RepairDAO();
        currentRepair.insert(newRepair);
    }


}
