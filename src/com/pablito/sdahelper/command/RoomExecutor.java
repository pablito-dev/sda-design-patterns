package com.pablito.sdahelper.command;

import java.util.ArrayList;
import java.util.List;

public class RoomExecutor {
    private final List<SmartHomeCommand> commands;

    public RoomExecutor() {
        commands = new ArrayList<>();
    }

    public void executeOperation(SmartHomeCommand command) {
        commands.add(command);
        command.execute();
    }
}
