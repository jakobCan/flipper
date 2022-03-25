package com.example.flipper.states;

import com.example.flipper.machine.FlipperMachine;
import com.example.flipper.machine.flipperElements.factories.EndStateFactory;
import com.example.flipper.machine.flipperElements.factories.NoCrediteStateFactory;
import com.example.flipper.machine.flipperElements.factories.ReadyStateFactory;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class EndState implements FlipperState, PropertyChangeListener {

    FlipperMachine flipperMachine;

    public EndState(FlipperMachine flipperMachine) {
        this.flipperMachine = flipperMachine;
        this.flipperMachine.addPropertyChangeListener(this);
    }

    @Override
    public void insertCoin() {}

    @Override
    public void pressStart() {}

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() == this){
            if (winGameChance()){
                flipperMachine.setFactory(new ReadyStateFactory());
                flipperMachine.setCurrentState(flipperMachine.getReady());
            } else {
                flipperMachine.setFactory(new NoCrediteStateFactory());
                flipperMachine.setCurrentState(flipperMachine.getNoCredit());
            }
        }
    }

    private boolean winGameChance() {
        double random = Math.random();
        System.out.println("Win game chance random number:" + random);
        return random < 0.5;
    }
}
