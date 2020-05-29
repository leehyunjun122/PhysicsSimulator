package States;

import java.awt.Color;
import java.awt.Graphics;

import Main.Handler;

public class ExperimentState extends State{
	//place for trying out various things
	
	public ExperimentState(Handler handler) {
		super(handler);
	}

	@Override
	public void update() {
	}

	@Override
	public void draw(Graphics g) {
		Color color = new Color(255, 0, 0, 100);
		g.setColor(color);
	}
}
