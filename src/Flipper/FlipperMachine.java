package src.Flipper;

import src.Flipper.States.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class FlipperMachine {

    private FlipperState noCredit;
    private FlipperState ready;
    private FlipperState playing;
    private FlipperState end;

    private FlipperState currentState;
    private final PropertyChangeSupport support;


    private int credit = 0;
    private int ball = 0;

    public FlipperMachine() {
        support = new PropertyChangeSupport(this);

        noCredit = new NoCreditState(this);
        ready = new ReadyState(this);
        playing = new PlayingState(this);
        end = new EndState(this);

        currentState = noCredit;
    }

    public void setCurrentState(FlipperState newFlipperState){
        support.firePropertyChange("state", this.currentState, newFlipperState);
        currentState = newFlipperState;
    }

    public void setCredit(int credit){
        this.credit = credit;
    }

    public int getCredit() {
        return credit;
    }

    public void setBall(int ball){
        this.ball = ball;
    }

    public int getBall() {
        return ball;
    }

    public void insertCoin(){
        currentState.insertCoin();
    }

    public void pressStart(){
        currentState.pressStart();
    }

    public FlipperState changeToEndState(){
        return getEnd();
    }

    public FlipperState getNoCredit(){ return noCredit; }
    public FlipperState getReady(){ return ready; }
    public FlipperState getPlaying(){ return playing; }
    public FlipperState getEnd(){ return end; }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

}
