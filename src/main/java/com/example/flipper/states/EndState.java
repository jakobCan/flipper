package com.example.flipper.states;

import com.example.flipper.machine.FlipperMachine;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class EndState implements FlipperState, PropertyChangeListener {

    FlipperMachine flipperMachine;

    public EndState(FlipperMachine flipperMachine) {
        this.flipperMachine = flipperMachine;
        this.flipperMachine.addPropertyChangeListener(this);
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
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() == this){
            if (winGameChance()){
                flipperMachine.setCurrentState(flipperMachine.getReady());
            } else {
                flipperMachine.setCurrentState(flipperMachine.getNoCredit());
            }
        }
    }

    private boolean winGameChance() {
        return Math.random() < 0.5;
    }


}
