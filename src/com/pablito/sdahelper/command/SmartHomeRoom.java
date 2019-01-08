package com.pablito.sdahelper.command;

public class SmartHomeRoom {
    private String roomName;
    private boolean lightsOn;
    private String trackPlaying;

    public SmartHomeRoom(final String roomName) {
        this.roomName = roomName;
        this.lightsOn = false;
        this.trackPlaying = "";
    }

    public void lightsOn() {
        lightsOn = true;
    }

    public void lightsOff() {
        lightsOn = false;
    }

    public void playTrack(final String track) {
        trackPlaying = track;
    }

    public String status() {
        final String lights = lightsOn ? "on" : "off";
        return String.format("Lights in the room %s are: %s, music playing: %s", roomName, lights, trackPlaying);
    }
}
