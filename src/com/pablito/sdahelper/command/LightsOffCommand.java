package com.pablito.sdahelper.command;

public class LightsOffCommand implements SmartHomeCommand {
    private SmartHomeRoom room;

    public LightsOffCommand(final SmartHomeRoom room) {
        this.room = room;
    }

    @Override
    public void execute() {
        room.lightsOff();
    }
}
