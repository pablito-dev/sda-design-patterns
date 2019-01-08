package com.pablito.sdahelper.command;

public class PlayTrackCommand implements SmartHomeCommand {
    private String trackName;
    private SmartHomeRoom room;

    public PlayTrackCommand(final String trackName, final SmartHomeRoom room) {
        this.trackName = trackName;
        this.room = room;
    }

    @Override
    public void execute() {
        room.playTrack(trackName);
    }
}
