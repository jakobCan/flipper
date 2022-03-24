package com.example.flipper.machine.flipperElements.targets;

import com.example.flipper.machine.flipperElements.visitor.Visitor;

public abstract class FlipperElement {
	public int hitCount;
	
	public void hit() {
	}

	public void acceptVisitor(Visitor visitor) {

	}
}
