package com.example.flipper.states;

import com.example.flipper.machine.FlipperMachine;

public class PlayingState implements FlipperState {

    FlipperMachine flipperMachine;

    public PlayingState(FlipperMachine flipperMachine) {
        this.flipperMachine = flipperMachine;
    }

    @Override
    public void insertCoin() {
        flipperMachine.setCredit(flipperMachine.getCredit() + 1);
    }

    @Override
    public void pressStart() {
        System.out.println("FlipperMachine written by Jakob Can. Thanks for playing ♥♥♥");
    }

    public void loseBall() {
        flipperMachine.setBall(flipperMachine.getBall() + 1);
        if (flipperMachine.getBall() == 4){
            flipperMachine.reset();
            flipperMachine.setCurrentState(flipperMachine.getEnd());
        }
    }
}
