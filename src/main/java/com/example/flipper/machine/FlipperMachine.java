package com.example.flipper.machine;

import com.example.flipper.machine.flipperElements.command.AddScoreCommand;
import com.example.flipper.machine.flipperElements.composite.Bumper;
import com.example.flipper.machine.flipperElements.composite.FlipperElement;
import com.example.flipper.machine.flipperElements.composite.RightEject;
import com.example.flipper.machine.flipperElements.visitor.Scoreboard;
import com.example.flipper.states.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class FlipperMachine {
	
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
		this.flipperElements.add(new Bumper(new AddScoreCommand(scoreboard)));
		this.flipperElements.add(new RightEject(new AddScoreCommand(scoreboard)));
	}
	
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
	
	public void setCurrentState(FlipperState newFlipperState) {
		support.firePropertyChange("state", this.currentState, newFlipperState);
		currentState = newFlipperState;
		System.out.println("Changed to " + this.currentState);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		support.addPropertyChangeListener(pcl);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		support.removePropertyChangeListener(pcl);
	}

	public void hitEverythingOnce(){
		for (FlipperElement element :
				flipperElements) {
			element.hit();
		}
	}
}
