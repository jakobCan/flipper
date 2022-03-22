package com.example.flipper.machine.flipperElements.command;

import com.example.flipper.machine.flipperElements.composite.Bumper;

public class HitBumper implements HitFlipperElement {
	
	private Bumper bumper;
	
	public HitBumper (Bumper bumper) {
		this.bumper=bumper;
	}

	@Override
	public void execute() {
		bumper.hit();
	}
}
