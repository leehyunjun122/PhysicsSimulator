package States;

import java.awt.Graphics;

import Main.Handler;
import Entities.Element;

public class SimulatingState extends State{

	private Element ball;
	
	public SimulatingState(Handler handler) {
		super(handler);
		ball = new Element(handler,10,325);
	}
	
	@Override
	public void update() {
		ball.update();
		if(handler.getMouse().pressingLeft() || handler.getMouse().pressingRight())
			State.setState(handler.getSimulator().experiment);
	}

	@Override
	public void draw(Graphics g) {
		ball.draw(g);
	}

}
