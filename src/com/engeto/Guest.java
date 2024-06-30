package com.engeto;

import java.time.LocalDate;

public class Guest {
    private String name;
    private String surName;
    private LocalDate birthDate;

    public Guest(String firstName, String lastName, LocalDate birthDate) {
        this.name = firstName;
        this.surName = lastName;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return name;
    }

    public String getSureName() {
        return surName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }


    @Override
    public String toString() {
        return name + " " + surName + " (" + birthDate + ")";
    }

}