package com.example.flipper.machine;

import com.example.flipper.machine.flipperElements.command.AddScoreCommand;
import com.example.flipper.machine.flipperElements.targets.Bumper;
import com.example.flipper.machine.flipperElements.targets.FlipperElement;
import com.example.flipper.machine.flipperElements.targets.Ramp;
import com.example.flipper.machine.flipperElements.mediator.Mediator;
import com.example.flipper.machine.flipperElements.visitor.ResetVisitor;
import com.example.flipper.machine.flipperElements.visitor.Scoreboard;
import com.example.flipper.machine.flipperElements.visitor.Visitor;
import com.example.flipper.states.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class FlipperMachine implements Mediator {
	
	// State pattern
	private FlipperState noCredit;
	private FlipperState ready;
	private FlipperState playing;
	private FlipperState end;
	private FlipperState currentState;
	
	// Observer pattern
	private final PropertyChangeSupport support;
	
	// Composite pattern
	private Scoreboard scoreboard;
	private List<FlipperElement> flipperElements = new ArrayList<>();
	private List<Bumper> bumpers = new ArrayList<>();
	private List<Ramp> ramps = new ArrayList<>();

	// Visitor pattern
	ResetVisitor resetVisitor;

	private int credit = 0;
	private int ball = 0;
	
	public FlipperMachine() {
		support = new PropertyChangeSupport(this);
		
		noCredit = new NoCreditState(this);
		ready = new ReadyState(this);
		playing = new PlayingState(this);
		end = new EndState(this);
		currentState = noCredit;
		this.scoreboard = new Scoreboard();
		this.bumpers.add(new Bumper(new AddScoreCommand(scoreboard), this));
		this.bumpers.add(new Bumper(new AddScoreCommand(scoreboard), this));
		this.bumpers.add(new Bumper(new AddScoreCommand(scoreboard), this));
		this.ramps.add(new Ramp(new AddScoreCommand(scoreboard)));
		this.ramps.add(new Ramp(new AddScoreCommand(scoreboard)));

		flipperElements.addAll(bumpers);
		flipperElements.addAll(ramps);

		this.resetVisitor = new ResetVisitor();
	}

	//<editor-fold desc="Getters & Setters">
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	public int getCredit() {
		return credit;
	}
	
	public void setBall(int ball) {
		this.ball = ball;
	}
	
	public int getBall() {
		return ball;
	}
	
	public void insertCoin() {
		currentState.insertCoin();
	}
	
	public void pressStart() {
		currentState.pressStart();
	}
	
	public FlipperState changeToEndState() {
		return getEnd();
	}
	
	public FlipperState getNoCredit() {
		return noCredit;
	}
	
	public FlipperState getReady() {
		return ready;
	}
	
	public FlipperState getPlaying() {
		return playing;
	}
	
	public FlipperState getEnd() {
		return end;
	}
	
	public Scoreboard getScoreboard() {
		return scoreboard;
	}
	
	public void setScoreboard(Scoreboard scoreboard) {
		this.scoreboard = scoreboard;
	}
	//</editor-fold>
	
	public void setCurrentState(FlipperState newFlipperState) {
		support.firePropertyChange("state", this.currentState, newFlipperState);
		currentState = newFlipperState;
		System.out.println("Flipper is now in " + currentState.getClass().getSimpleName());
	}
	
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		support.addPropertyChangeListener(pcl);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		support.removePropertyChangeListener(pcl);
	}

	public void hitEverythingOnce(){
		for (FlipperElement element : flipperElements) {
			element.hit();
		}
	}

	@Override
	public void notify(FlipperElement sender) {
		if (isKnownBumper(sender)){
			reactOnBumpers();
		}
	}

	private boolean isKnownBumper(FlipperElement bumper) {
		for (Bumper listBumper :
				bumpers) {
			if (listBumper == bumper){
				return true;
			}
		}
		return false;
	}

	private void reactOnBumpers() {
		for (Bumper bumper :
				bumpers) {
			if (bumper.hasBeenHit()){
				return;
			}
		}
		openRamps();
	}

	private void openRamps() {
		for (Ramp ramp :
				ramps) {
			ramp.setOpen(true);
			System.out.println("Opening Ramp " + ramp);
		}
	}

	public void reset() {
		for (FlipperElement element :
				flipperElements) {
			element.acceptVisitor(resetVisitor);
		}
	}
}
