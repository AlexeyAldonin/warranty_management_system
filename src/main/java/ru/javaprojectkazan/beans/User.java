package ru.javaprojectkazan.beans;

import lombok.*;

import java.util.LinkedList;
import java.util.List;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User implements CommonUser {

    @Override
    public String getUserName() {
        return null;
    }

    int id;
    @NonNull private String name;
    @NonNull private String surname;
    private String login;
    private String psswd;
    @NonNull private String employer;
    @NonNull private String systemRole;
    private String email;

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
