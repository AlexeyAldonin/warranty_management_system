package ru.javaprojectkazan.enums;

public enum Page {
    HOME ("/views/appHome.jsp"),
    CREATE_CLAIM ("/views/createClaim.jsp"),
    LOGIN_PAGE ("/views/loginPage.jsp"),
    INDEX_PAGE ("/index.jsp"),
    VEHICLE_DETAILS ("/views/vehicleDetails.jsp"),
    FIND_VEHICLE ("/views/findVehicle.jsp"),
    CLAIM_HISTORY ("/views/claimHistory.jsp")
    ;

    private String path;

    Page(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
