package com.example.flipper.machine.flipperElements.visitor;

import com.example.flipper.machine.FlipperMachine;
import com.example.flipper.machine.flipperElements.targets.Bumper;
import com.example.flipper.machine.flipperElements.targets.Ramp;

public abstract class Visitor {

    public void visit(Ramp ramp){}
    public void visit(Bumper bumper){}
    public void visit(FlipperMachine flipper){}
    public void visit(Scoreboard scoreboard){}
}
