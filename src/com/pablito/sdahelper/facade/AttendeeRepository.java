package com.pablito.sdahelper.facade;

import java.util.List;

public class AttendeeRepository {
    private final List<String> attendees;

    public AttendeeRepository(final List<String> attendees) {
        this.attendees = attendees;
    }

    public void addAttendee(final String name) {
        this.attendees.add(name);
    }

    public List<String> getAttendees() {
        return attendees;
    }
}
