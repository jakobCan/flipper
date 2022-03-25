package com.example.flipper.machine;

import com.example.flipper.machine.flipperElements.command.AddScoreCommand;
import com.example.flipper.machine.flipperElements.command.LoseBallCommand;
import com.example.flipper.machine.flipperElements.factories.AbstractStateFactory;
import com.example.flipper.machine.flipperElements.factories.NoCrediteStateFactory;
import com.example.flipper.machine.flipperElements.targets.Bumper;
import com.example.flipper.machine.flipperElements.targets.FlipperElement;
import com.example.flipper.machine.flipperElements.targets.Ramp;
import com.example.flipper.machine.flipperElements.mediator.Mediator;
import com.example.flipper.machine.flipperElements.targets.TheVoid;
import com.example.flipper.machine.flipperElements.visitor.ResetVisitor;
import com.example.flipper.machine.flipperElements.visitor.Scoreboard;
import com.example.flipper.machine.flipperElements.visitor.Visitor;
import com.example.flipper.states.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class FlipperMachine implements Mediator {
	
	private int credit = 0;
	private int ball = 0;

	// State pattern
	private FlipperState noCredit;
	private FlipperState ready;
	private FlipperState playing;
	private FlipperState end;
	private FlipperState currentState;
	
	// Abstract Factory pattern
	private AbstractStateFactory factory;
	
	// Observer pattern
	private final PropertyChangeSupport support;
	
	// Composite pattern
	private Scoreboard scoreboard;
	private TheVoid theVoid;
	private List<FlipperElement> flipperElements = new ArrayList<>();
	private List<Bumper> bumpers = new ArrayList<>();
	private List<Ramp> ramps = new ArrayList<>();
	
	// Visitor pattern
	ResetVisitor resetVisitor;
	
	public FlipperMachine() {
		support = new PropertyChangeSupport(this);
		
		noCredit = new NoCreditState(this);
		ready = new ReadyState(this);
		PlayingState playing = new PlayingState(this);
		this.playing = playing;
		end = new EndState(this);

		currentState = noCredit;
		this.setFactory(new NoCrediteStateFactory());
		System.out.println(factory.showState());

		this.scoreboard = new Scoreboard();
		theVoid = new TheVoid(new LoseBallCommand(playing), this);
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
	
	public AbstractStateFactory getFactory() {
		return factory;
	}
	
	public void setFactory(AbstractStateFactory factory) {
		this.factory = factory;
	}
	
	public void setScoreboard(Scoreboard scoreboard) {
		this.scoreboard = scoreboard;
	}
	//</editor-fold>
	
	public void setCurrentState(FlipperState newFlipperState) {
		System.out.println(factory.showState());
		support.firePropertyChange("state", this.currentState, newFlipperState);
		currentState = newFlipperState;
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
			if (!bumper.hasBeenHit()){
				return;
			}
		}
		openRamps();
	}

	private void openRamps() {
		for (Ramp ramp :
				ramps) {
			if (!ramp.isOpen()){
				ramp.setOpen(true);
				System.out.println("Opening Ramp " + ramp);
			}
		}
	}

	public void reset() {
		for (FlipperElement element :
				flipperElements) {
			element.acceptVisitor(resetVisitor);
		}
		this.acceptVisitor(resetVisitor);
		this.scoreboard.acceptVisitor(resetVisitor);
	}

	public void loseBall(){
		theVoid.hit();
	}

	void acceptVisitor(ResetVisitor visitor) {
		visitor.visit(this);
	}
}
