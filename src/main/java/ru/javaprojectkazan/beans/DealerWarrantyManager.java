package ru.javaprojectkazan.beans;

import lombok.NonNull;

public class DealerWarrantyManager extends User{

    public DealerWarrantyManager(@NonNull String name, @NonNull String surname, @NonNull String login, @NonNull String employer, @NonNull String systemRole) {
        super(name, surname, login, employer, systemRole);
    }

    public DealerWarrantyManager(int id, @NonNull String name, @NonNull String surname, @NonNull String login, String psswd, @NonNull String employer, @NonNull String systemRole, String email) {
        super(id, name, surname, login, psswd, employer, systemRole, email);
    }
}

