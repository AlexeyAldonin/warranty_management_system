package ru.javaprojectkazan.enums;

public enum Page {
    HOME ("/views/appHome.jsp"),
    CREATE_CLAIM ("/views/createClaim.jsp")
    ;

    private String path;

    Page(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
