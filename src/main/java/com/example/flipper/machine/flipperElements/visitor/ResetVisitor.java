package com.example.flipper.machine.flipperElements.visitor;

import com.example.flipper.machine.flipperElements.targets.Bumper;
import com.example.flipper.machine.flipperElements.targets.Ramp;

public class ResetVisitor extends Visitor{

    public void visit(Bumper bumper) {
        bumper.hitCount = 0;
    }

    public void visit(Ramp ramp) {
        ramp.hitCount = 0;
        ramp.isOpen = false;
    }
}
