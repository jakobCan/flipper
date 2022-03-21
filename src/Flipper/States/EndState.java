package src.Flipper.States;

import src.Flipper.FlipperMachine;

public class EndState implements FlipperState {

    // TODO: 07.03.2022 Wenn ein Spiel beendet wird, soll es die Möglichkeit geben, ein gratis Spiel zu gewinnen.
    //  Dafür müsste ich eine Methode automatisch aufrufen, wenn auf EndState gewechselt wird. Wie mach ich das?
    //  Vermittler-Pattern? Macht es Sinn, dass EndState ein eigener Zustand ist? -> Observer-Pattern

    FlipperMachine flipperMachine;

    public EndState(FlipperMachine flipperMachine) {
        this.flipperMachine = flipperMachine;
    }

    @Override
    public void insertCoin() {
//        Kann der User das im EndState?
    }

    @Override
    public void pressStart() {
//        Kann der User das im EndState?
    }

    @Override
    public void loseBall() {
//        Kann der User das im EndState?
    }
}
