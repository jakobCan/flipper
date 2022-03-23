package com.example.flipper.machine.flipperElements.composite;

import com.example.flipper.machine.flipperElements.command.Command;

public class Bumper extends FlipperElement {
	
//	private int score;
	private int id;
	Command command;

	public Bumper(Command command, int id) {
		this.hitCount=0;
		this.command = command;
		this.id = id;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	public boolean hasBeenHit() {
		return hitCount > 0;
	}

	@Override
	public void hit() {
		command.execute();

	}

}
