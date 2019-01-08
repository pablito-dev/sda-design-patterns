package com.pablito.sdahelper.facade;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CourseFacade {
    private AttendeeRepository attendeeRepository;

    public CourseFacade(final AttendeeRepository attendeeRepository) {
        this.attendeeRepository = attendeeRepository;
    }

    public List<String> getAttendeesWithGivenNameLength(final int length) {
        return attendeeRepository.getAttendees().stream().filter(attendee -> attendee.length() == length).collect(Collectors.toList());
    }

    public List<String> getAttendeesWithNamesStartingWith(final String prefix) {
        return attendeeRepository.getAttendees().stream().filter(attendee -> attendee.startsWith(prefix)).collect(Collectors.toList());
    }

    public List<String> getAttendeesSortByOrder() {
        return attendeeRepository.getAttendees();
    }

    public List<String> getAttendeesSortByName() {
        return attendeeRepository.getAttendees().stream().sorted().collect(Collectors.toList());
    }
}
