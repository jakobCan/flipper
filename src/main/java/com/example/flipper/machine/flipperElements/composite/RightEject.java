package com.example.flipper.machine.flipperElements.composite;

import com.example.flipper.machine.flipperElements.command.Command;

public class RightEject extends FlipperElement{

    Command command;

    public RightEject(Command command) {
        this.hitCount = 0;
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    @Override
    public void hit(){
        command.execute();
    }
}
