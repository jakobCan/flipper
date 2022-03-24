package com.example.flipper.machine.flipperElements.targets;

import com.example.flipper.machine.FlipperMachine;
import com.example.flipper.machine.flipperElements.command.Command;

public class Bumper extends FlipperElement {

	Command command;
	FlipperMachine flipperMachine;

	public Bumper(Command command, FlipperMachine flipperMachine) {
		this.hitCount=0;
		this.command = command;
		this.flipperMachine = flipperMachine;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	public boolean hasBeenHit() {
		return hitCount > 0;
	}

	@Override
	public void hit() {
		hitCount++;
		command.execute();
		flipperMachine.notify(this);
	}
}
