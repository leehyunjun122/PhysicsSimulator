package Main;

import Manager.Keyboard;

public class Handler {

	private Runner simulator;
	
	public Handler(Runner simulator) {
		this.simulator = simulator;
	}

	public int getLength() {
		return simulator.getLength();
	}
	
	public int getHeight() {
		return simulator.getHeight();
	}
	
	public Keyboard getKey() {
		return simulator.getKey();
	}
	public Runner getSimulator() {
		return simulator;
	}

	public void setSimulator(Runner simulator) {
		this.simulator = simulator;
	}
}
