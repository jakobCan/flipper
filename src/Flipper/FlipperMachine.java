package src.Flipper;

import src.Flipper.States.*;

public class FlipperMachine {

    FlipperState noCredit;
    FlipperState ready;
    FlipperState playing;
    FlipperState end;

    FlipperState currentState;

    int credit = 0;
    int ball = 0;

    public FlipperMachine() {
        noCredit = new NoCreditState(this);
        ready = new ReadyState(this);
        playing = new PlayingState(this);
        end = new EndState(this);

        currentState = noCredit;
    }

    public void setCurrentState(FlipperState newFlipperState){
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

    public void loseBall(){
        currentState.loseBall();
    }

    public FlipperState changeToEndState(){

        return getEnd();
    }

    public FlipperState getNoCredit(){ return noCredit; }
    public FlipperState getReady(){ return ready; }
    public FlipperState getPlaying(){ return playing; }
    public FlipperState getEnd(){ return end; }

}
