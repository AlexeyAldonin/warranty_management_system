package ru.javaprojectkazan.enums;

public enum DBCommand {
    //language=sql
    INSERT_INTO_USERS_VALUES ("INSERT INTO WARRANTY_MANAGEMENT_SYSTEM.WARRANTY_MANAGEMENT_SYSTEM.USER " +
            "(LOGIN, PSSWD, NAME, SURNAME) VALUES (?,?,?,?)"),
    //language=sql
    SELECT_PART_BY_NUMBER ("SELECT * FROM WARRANTY_MANAGEMENT_SYSTEM.WARRANTY_MANAGEMENT_SYSTEM.SPARE_PARTS WHERE " +
            "PART_NUMBER = ?"),
    //language=sql
    SELECT_ALL_PARTS ("SELECT * FROM WARRANTY_MANAGEMENT_SYSTEM.WARRANTY_MANAGEMENT_SYSTEM.SPARE_PARTS"),
    //language=sql
    SELECT_OPERATION_BY_NUMBER ("SELECT * FROM WARRANTY_MANAGEMENT_SYSTEM.WARRANTY_MANAGEMENT_SYSTEM.REPAIR_OPERATIONS " +
            "WHERE OPERATION_ID = ?"),
    //language=sql
    SELECT_REPAIR_BY_VIN ("SELECT * FROM WARRANTY_MANAGEMENT_SYSTEM.WARRANTY_MANAGEMENT_SYSTEM.REPAIRS " +
            "WHERE VEHICLE_VIN = ?"),
    //language=sql
    INSERT_INTO_REPAIRS_REPAIR_VALUES ("INSERT INTO WARRANTY_MANAGEMENT_SYSTEM.WARRANTY_MANAGEMENT_SYSTEM.REPAIRS " +
            "(VEHICLE_VIN, VEHICLE_MILEAGE, REPAIR_DATE, PART_NUMBER, PART_NAME, PART_QUANTITY," +
            "PARTS_COST, REPAIR_OPERATION_ID, REPAIR_OPERATION_NAME, REPAIR_HOURS, REPAIR_OPERATIONS_COST, REPAIR_TOTAL_COST) " +
            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)"),
    //language=sql
    SELECT_VEHICLE_BY_VIN ("SELECT * FROM WARRANTY_MANAGEMENT_SYSTEM.WARRANTY_MANAGEMENT_SYSTEM.VEHICLES " +
                                  "WHERE VIN = ?"),
    //language=sql
    SELECT_USER_BY_LOGIN_AND_PSSWD ("SELECT * FROM warranty_management_system.warranty_management_system.user " +
            "WHERE login = ? AND password = ?"),
    //language=sql
    UPDATE_VEHICLE_MILEAGE ("UPDATE warranty_management_system.warranty_management_system.vehicles " +
            "SET mileage_at_last_claim = ? WHERE vin = ?")
    ;

    String command;

    DBCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
