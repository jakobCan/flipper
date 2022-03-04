package src.Flipper.States;

public interface FlipperState {

//    different states expected:
//    NoCredit, Ready, Playing, End

//    coins can be inserted at all times
    void insertCoin();

//    changes to PlayingState when credit > 0
//    prints msg when no credit
//    prints author when in PlayingState
    void pressStart();

//    when ball is lost 3 times, change to EndState
//    from EndState either NoCredit or Ready will be selected
    void loseBall();
}
