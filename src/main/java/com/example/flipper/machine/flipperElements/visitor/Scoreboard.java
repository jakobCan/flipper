package com.example.flipper.machine.flipperElements.visitor;

import com.example.flipper.machine.flipperElements.command.Command;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

@Scope("singleton")
public class Scoreboard {


	int score;
	int multiplicator;
//	private List<Command> commands = new ArrayList<>();


	public Scoreboard() {
		this.score = 0;
		this.multiplicator = 1;
	}

	public int getMultiplicator() {
		return multiplicator;
	}

	public void setMultiplicator(int multiplicator) {
		this.multiplicator = multiplicator;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void addPoints(int i) {
		this.score += i;
	}

	public void acceptVisitor(ResetVisitor visitor) {
		visitor.visit(this);
	}
}
