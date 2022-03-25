package com.example.flipper.machine.flipperElements.command;

import com.example.flipper.states.PlayingState;

public class LoseBallCommand implements Command{

    PlayingState playingState;

    public LoseBallCommand(PlayingState playingState) {
        this.playingState = playingState;
    }

    @Override
    public void execute() {
        playingState.loseBall();
    }
}
