package com.pablito.sdahelper.command;

import java.util.LinkedList;
import java.util.List;

public class RoomExecutor {
    private final List<SmartHomeCommand> commands;

    public RoomExecutor() {
        commands = new LinkedList<>();
    }

    public void executeOperation(SmartHomeCommand command) {
        commands.add(command);
        command.execute();
    }
}
