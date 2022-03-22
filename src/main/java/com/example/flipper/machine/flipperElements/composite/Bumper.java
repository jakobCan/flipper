package com.example.flipper.machine.flipperElements.composite;

import com.example.flipper.machine.flipperElements.command.HitBumper;

public class Bumper extends FlipperElement {
	
//	private int score;

	public Bumper() {
		this.hitCount=0;
	}
	
	@Override
	public void hit() {
		this.hitCount++;
		System.out.println(this.getClass() + " got hit " + hitCount + " times!");
	}
}
