package src.Flipper.States;

import src.Flipper.FlipperMachine;

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
        flipperMachine.setCurrentState(flipperMachine.getPlaying());
    }

    @Override
    public void loseBall() {
        System.out.println("You shouldn't be able to lose a ball while in ReadyState! How did you do this!?");
    }
}
