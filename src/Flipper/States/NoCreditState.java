package src.Flipper.States;

import src.Flipper.FlipperMachine;

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
        System.out.println("No credit! Please insert coin(s).");
    }
}
