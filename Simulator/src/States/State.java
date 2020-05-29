package States;

import java.awt.Graphics;

import Main.Handler;
import Main.Runner;

public abstract class State {
	//managing which state should be in and where we are currently in
	private static State currentState = null;
	
	public static void setState(State s) {
		currentState = s;
	}
	
	public static State getState() {
		return currentState;
	}
	
	
	//for each state to update
	protected Handler handler;
	
	public State(Handler handler) {
		this.handler = handler;
	}
	
	public abstract void update();
	public abstract void draw(Graphics g);
}
