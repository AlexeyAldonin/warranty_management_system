package ru.javaprojectkazan.enums;

public enum UserCredential {

    ID ("id"),
    NAME ("name"),
    SURNAME ("surname"),
    LOGIN ("login"),
    PSSWD ("psswd"),
    EMPLOYER ("employer"),
    SYSTEM_ROLE ("systemRole"),
    EMAIL ("email")
    ;


    private String name;

    UserCredential(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
