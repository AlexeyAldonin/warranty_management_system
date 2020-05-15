package ru.javaprojectkazan.enums;

public enum DBCommand {
    //language=sql
    INSERT_INTO_USERS_VALUES ("INSERT INTO warranty_management_system.warranty_management_system.user " +
            "(login, password, name, surname) VALUES (?,?,?,?)"),
    //language=sql
    SELECT_PART_BY_NUMBER ("SELECT * FROM warranty_management_system.warranty_management_system.spare_parts WHERE " +
            "part_number = ?"),
    //language=sql
    SELECT_ALL_PARTS ("SELECT * FROM warranty_management_system.warranty_management_system.spare_parts"),
    //language=sql
    SELECT_OPERATION_BY_NUMBER ("SELECT * FROM warranty_management_system.warranty_management_system.repair_operations " +
            "WHERE operation_id = ?"),

    //language=sql
    SELECT_REPAIR_BY_VIN ("SELECT * FROM warranty_management_system.warranty_management_system.repairs " +
            "WHERE VEHICLE_VIN = ?"),
    //language=sql
    SELECT_REPAIR_BY_NUMBER ("SELECT * FROM warranty_management_system.warranty_management_system.repairs WHERE claim_number = ?"),
    //language=sql
    INSERT_INTO_REPAIRS_REPAIR_VALUES ("INSERT INTO warranty_management_system.warranty_management_system.repairs " +
            "(vehicle_vin, vehicle_mileage, repair_date, part_number, part_name, part_quantity," +
            "parts_cost, repair_operation_id, repair_operation_name, repair_hours, repair_operations_cost, repair_total_cost) " +
            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)"),
    //language=sql

    SELECT_VEHICLE_BY_VIN ("SELECT * FROM warranty_management_system.warranty_management_system.vehicles " +
                                  "WHERE vin = ?"),
    //language=sql
    UPDATE_VEHICLE_MILEAGE ("UPDATE warranty_management_system.warranty_management_system.vehicles " +
            "SET mileage_at_last_claim = ? WHERE vin = ?"),

    //language=sql
    SELECT_USER_BY_LOGIN_AND_PSSWD ("SELECT * FROM warranty_management_system.warranty_management_system.user " +
            "WHERE login = ? AND password = ?")
    ;

    String command;

    DBCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
