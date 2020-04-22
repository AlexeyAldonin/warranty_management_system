package ru.javaprojectkazan.beans;

import java.util.LinkedList;
import java.util.List;

public class User implements CommonUser {

    @Override
    public String getUserName() {
        return null;
    }

    private String name;
    private String surname;
    private String login;
    private String psswd;
    private String employer;
    private String systemRole;

    public List<Repair> searchRepairByVIN(Vehicle vehicle, List<Repair> repairsList) {

        List<Repair> repairs= new LinkedList<>();
        for(Repair repair : repairsList) {
            if (repair.getVehicle().getVin().equals(vehicle.getVin())) {
                repairs.add(repair);
            }
        }
        return repairs;
    }

    public List<Vehicle> searchVehicleByVIN(List<Vehicle> totalVehiclesList, String vin) {

        List<Vehicle> vehicles = new LinkedList<>();
        for (Vehicle vehicle : totalVehiclesList) {
            if(vehicle.getVin().endsWith(vin) || vehicle.getVin().equals(vin)) {
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }
}
