package Main;

import Manager.KeyManager;

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
	
	public KeyManager getKey() {
		return simulator.getKey();
	}
	public Runner getSimulator() {
		return simulator;
	}

	public void setSimulator(Runner simulator) {
		this.simulator = simulator;
	}
}
