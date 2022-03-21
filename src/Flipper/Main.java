package src.Flipper;

public class Main {
    public static void main(String[] args) {
        FlipperMachine flipperMachine = new FlipperMachine();
        flipperMachine.setCurrentState(flipperMachine.getEnd());
    }
}
