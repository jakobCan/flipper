package com.example.flipper.machine.flipperElements.command;

import com.example.flipper.machine.flipperElements.visitor.Scoreboard;

public class AddScoreCommand implements Command {

    Scoreboard scoreboard;
    int score = 100;

    public AddScoreCommand(Scoreboard scoreboard) {
        this.scoreboard = scoreboard;
    }

    @Override
    public void execute() {
        scoreboard.addPoints(score * scoreboard.getMultiplicator());
    }
}
