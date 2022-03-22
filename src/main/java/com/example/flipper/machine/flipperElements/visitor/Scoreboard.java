package com.example.flipper.machine.flipperElements.visitor;

import com.example.flipper.machine.flipperElements.command.Command;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

@Scope("singleton")
public class Scoreboard {


	int score = 0;
	int multiplicator = 1;
	private List<Command> commands = new ArrayList<>();

	public int getMultiplicator() {
		return multiplicator;
	}

	public void setMultiplicator(int multiplicator) {
		this.multiplicator = multiplicator;
	}

	public void saveHit(Command command) {
		commands.add(command);
	}

	public void calculateScore() {
		for (Command h : commands) {
			h.execute();
		}
	}

	public void addPoints(int i) {
		this.score += i;
	}
}
