package com.example.flipper.states;

public interface FlipperState {

//    different states expected:
//    NoCredit, Ready, Playing, End

//    coins can be inserted at all times
    void insertCoin();

//    changes to PlayingState when credit > 0
//    prints msg when no credit
//    prints author when in PlayingState
    void pressStart();
}
