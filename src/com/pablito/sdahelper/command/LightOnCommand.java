package com.pablito.sdahelper.command;

public class LightOnCommand implements SmartHomeCommand {
    private SmartHomeRoom room;

    public LightOnCommand(final SmartHomeRoom room) {
        this.room = room;
    }

    @Override
    public void execute() {
        room.lightsOn();
    }
}
