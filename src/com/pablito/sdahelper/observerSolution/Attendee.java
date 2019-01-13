package com.pablito.sdahelper.observerSolution;

public class Attendee {
    private String firstName;
    private String secondName;
    private String email;

    public Attendee(final String firstName, final String secondName, final String email) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return String.format("Hi my name is %s %s my email address is %s.", firstName, secondName, email);
    }
}
