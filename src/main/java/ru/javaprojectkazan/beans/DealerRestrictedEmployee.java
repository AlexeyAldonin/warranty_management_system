package ru.javaprojectkazan.beans;

import lombok.NonNull;

public class DealerRestrictedEmployee extends User {

    public DealerRestrictedEmployee(@NonNull String name, @NonNull String surname, @NonNull String login, @NonNull String employer, @NonNull String systemRole) {
        super(name, surname, login, employer, systemRole);
    }

    public DealerRestrictedEmployee(int id, @NonNull String name, @NonNull String surname, @NonNull String login, String psswd, @NonNull String employer, @NonNull String systemRole, String email) {
        super(id, name, surname, login, psswd, employer, systemRole, email);
    }
}

