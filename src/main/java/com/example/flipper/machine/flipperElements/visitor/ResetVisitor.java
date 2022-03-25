package com.example.flipper.machine.flipperElements.visitor;

import com.example.flipper.machine.FlipperMachine;
import com.example.flipper.machine.flipperElements.targets.Bumper;
import com.example.flipper.machine.flipperElements.targets.Ramp;

public class ResetVisitor extends Visitor{

    @Override
    public void visit(Bumper bumper) {
        bumper.hitCount = 0;
    }

    @Override
    public void visit(Ramp ramp) {
        ramp.hitCount = 0;
        ramp.isOpen = false;
    }

    @Override
    public void visit(FlipperMachine flipper){
        flipper.setBall(1);
    }

    @Override
    public void visit(Scoreboard scoreboard){
        scoreboard.setScore(0);
    }
}
