package ru.javaprojectkazan.enums;

public enum RepairParameter {

    CLAIM_NUMBER("claim_number"),
    VEHICLE_VIN("vehicle_vin"),
    VEHICLE_MILEAGE("vehicle_mileage"),
    REPAIR_DATE("date_of_repair"),
    REPLACED_PART_NAME("replaced_part_name"),
    REPLACED_PART_NUMBER("replaced_part_number"),
    REPLACED_PART_QUANTITY("replaced_part_quantity"),
    PART_COST("part_cost"),
    REPAIR_OPERATION_ID("repair_operation_id"),
    REPAIR_OPERATION_NAME("repair_operation_name"),
    REPAIR_OPERATION_HOURS("repair_operation_hours"),
    REPAIR_OPERATIONS_COST("repair_operations_cost"),
    REPAIR_TOTAL_COST("total_repair_cost")
    ;


    private String name;

    RepairParameter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
