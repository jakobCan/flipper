package com.example.flipper.states;

import com.example.flipper.machine.FlipperMachine;
import com.example.flipper.machine.flipperElements.factories.EndStateFactory;

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
        System.out.println("FlipperMachine written by Group C. Thanks for playing ♥♥♥");
    }

    public void loseBall() {
        flipperMachine.setBall(flipperMachine.getBall() + 1);
        if (flipperMachine.getBall() == 4){
            System.out.println("Total score: " + flipperMachine.getScoreboard().getScore());
            flipperMachine.reset();
            flipperMachine.setFactory(new EndStateFactory());
            flipperMachine.setCurrentState(flipperMachine.getEnd());
        }
        if (flipperMachine.getBall() < 4){
            System.out.println("Current score: " + flipperMachine.getScoreboard().getScore());
        }
    }
}
