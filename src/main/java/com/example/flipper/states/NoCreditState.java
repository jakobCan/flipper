package com.example.flipper.states;

import com.example.flipper.machine.FlipperMachine;
import com.example.flipper.machine.flipperElements.factories.EndStateFactory;
import com.example.flipper.machine.flipperElements.factories.NoCrediteStateFactory;

public class NoCreditState implements FlipperState {

    FlipperMachine flipperMachine;

    public NoCreditState(FlipperMachine flipperMachine) {
        this.flipperMachine = flipperMachine;
    }

    @Override
    public void insertCoin() {
        flipperMachine.setCurrentState(flipperMachine.getReady());
    }

    @Override
    public void pressStart() {
        System.out.println(flipperMachine.getFactory().showState());
    }
}
