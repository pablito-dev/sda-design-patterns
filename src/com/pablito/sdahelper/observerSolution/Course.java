package com.pablito.sdahelper.observerSolution;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

public class Course extends Observable {
    List<Attendee> attendees;

    public Course() {
        attendees = new LinkedList<>();
    }

    public void addAttendee(final Attendee attendee) {
        attendees.add(attendee);
        setChanged();
        notifyObservers(attendee);
    }

    public List<Attendee> getAttendees() {
        return attendees;
    }
}
