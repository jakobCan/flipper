package com.example.flipper.machine.flipperElements.targets;

import com.example.flipper.machine.flipperElements.command.Command;
import com.example.flipper.machine.flipperElements.visitor.Visitor;

public class Ramp extends FlipperElement{

    Command command;
    public boolean isOpen = false;

    public Ramp(Command command) {
        this.hitCount = 0;
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public void hit(){
        command.execute();
    }

    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visit(this);
    }
}
