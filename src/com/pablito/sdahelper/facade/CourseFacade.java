package com.pablito.sdahelper.facade;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CourseFacade {
    private final List<String> attendees;

    public CourseFacade() {
        this.attendees = new LinkedList<>();
    }

    public void addAttendee(final String name) {
        this.attendees.add(name);
    }

    public List<String> getAttendeesWithGivenNameLength(final int length) {
        return attendees.stream().filter(attendee -> attendee.length() == length).collect(Collectors.toList());
    }

    public List<String> getAttendeesWithNamesStartingWith(final String prefix) {
        return attendees.stream().filter(attendee -> attendee.startsWith(prefix)).collect(Collectors.toList());
    }

    public List<String> getAttendeesSortByOrder() {
        return attendees;
    }

    public List<String> getAttendeesSortByName() {
        return attendees.stream().sorted().collect(Collectors.toList());
    }
}
