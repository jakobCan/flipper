package com.example.flipper.machine.flipperElements.visitor;

import com.example.flipper.machine.flipperElements.command.HitFlipperElement;

import java.util.ArrayList;
import java.util.List;

public class Scoreboard {
	private List<HitFlipperElement> hitFlipperElements = new ArrayList<>();

	public void saveHit(HitFlipperElement hitFlipperElement) {
		hitFlipperElements.add(hitFlipperElement);
	}

	public void calculateScore() {
		for (HitFlipperElement h : hitFlipperElements) {
			h.execute();
		}
	}
}
