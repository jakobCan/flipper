package com.example.flipper.machine.flipperElements.targets;

import com.example.flipper.machine.FlipperMachine;
import com.example.flipper.machine.flipperElements.command.Command;

public class TheVoid extends FlipperElement {

    Command command;
    FlipperMachine flipperMachine;

    public TheVoid(Command command, FlipperMachine flipperMachine) {
        this.command = command;
        this.flipperMachine = flipperMachine;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    @Override
    public void hit() {
        command.execute();
    }
}
