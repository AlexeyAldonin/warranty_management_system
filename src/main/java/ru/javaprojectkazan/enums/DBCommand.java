package ru.javaprojectkazan.enums;

public enum DBCommand {

    INSERT_INTO_USERS_VALUES("INSERT INTO WARRANTY_MANAGEMENT_SYSTEM.WARRANTY_MANAGEMENT_SYSTEM.USER " +
            "(LOGIN, PSSWD, NAME, SURNAME) VALUES (?,?,?,?)"),
    SELECT_CLIENT_BY_LGN_AND_PSSWD("SELECT * FROM WARRANTY_MANAGEMENT_SYSTEM." +
            "WARRANTY_MANAGEMENT_SYSTEM.USER WHERE LOGIN = ? AND PSSWD = ?"),
    SELECT_PART_BY_NUMBER("SELECT * FROM WARRANTY_MANAGEMENT_SYSTEM.WARRANTY_MANAGEMENT_SYSTEM.PARTS WHERE " +
            "PART_NUMBER = ?"),
    SELECT_ALL_PARTS("SELECT * FROM WARRANTY_MANAGEMENT_SYSTEM.WARRANTY_MANAGEMENT_SYSTEM.PARTS"),
    SELECT_OPERATION_BY_NUMBER("SELECT * FROM WARRANTY_MANAGEMENT_SYSTEM.WARRANTY_MANAGEMENT_SYSTEM.REPAIR_OPERATIONS " +
            "WHERE OPERATION_ID = ?"),
    SELECT_REPAIR_BY_VIN("SELECT * FROM WARRANTY_MANAGEMENT_SYSTEM.WARRANTY_MANAGEMENT_SYSTEM.REPAIRS " +
            "WHERE VEHICLE_VIN = ?"),
    INSERT_INTO_REPAIRS_REPAIR_VALUES("INSERT INTO WARRANTY_MANAGEMENT_SYSTEM.WARRANTY_MANAGEMENT_SYSTEM.REPAIRS " +
            "(CLAIM_NUMBER, VEHICLE_VIN, DATE_OF_REPAIR, REPLACED_PART_NUMBER, REPLACED_PART_NAME, REPLACED_PART_QUANTITY," +
            "REPAIR_OPERATION_ID, REPAIR_OPERATION_NAME, REPAIR_OPERATION_HOURS, REPAIR_OPERATIONS_COST, REPAIR_TOTAL_COST) " +
            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)"),
    SELECT_VEHICLE_BY_VIN("SELECT * FROM WARRANTY_MANAGEMENT_SYSTEM.WARRANTY_MANAGEMENT_SYSTEM.VEHICLES " +
                                  "WHERE VEHICLE_VIN = ?")
    ;

    String command;

    DBCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
