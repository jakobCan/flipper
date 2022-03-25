package com.example.flipper.states;

import com.example.flipper.machine.FlipperMachine;
import com.example.flipper.machine.flipperElements.factories.PlayingStateFactory;
import com.example.flipper.machine.flipperElements.factories.ReadyStateFactory;

public class ReadyState implements FlipperState {

    FlipperMachine flipperMachine;

    public ReadyState(FlipperMachine flipperMachine) {
        this.flipperMachine = flipperMachine;
    }

    @Override
    public void insertCoin() {
        flipperMachine.setCredit(flipperMachine.getCredit() + 1);
    }

    @Override
    public void pressStart() {
        flipperMachine.setBall(1);
        flipperMachine.setFactory(new PlayingStateFactory());
        flipperMachine.setCurrentState(flipperMachine.getPlaying());
    }
}
