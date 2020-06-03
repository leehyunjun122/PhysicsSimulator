package States;

import java.awt.Graphics;
import java.util.Scanner;

import Main.Handler;
import Manager.UI;
import UI.Button;
import UI.ClickListener;
import graphics.Input;

public class ExperimentState extends State{
	//place for trying out various things
	
	private UI manager;
	private static Scanner input = new Scanner(System.in);
	private String currentText;
	
	public ExperimentState(Handler handler) {
		super(handler);
		manager = new UI(handler);
		handler.getMouse().setUIManager(manager);
		manager.addObject(new Button(800, 500, 100, 100, Input.next, new ClickListener() {
			public void onClick() {
				handler.getMouse().setUIManager(null);
				State.setState(handler.getSimulator().simulator);
				handler.getMouse().setUIManager(manager);
			}
		}));
	}

	@Override
	public void update() {
		manager.update();
	}

	@Override
	public void draw(Graphics g) {
		manager.draw(g);
	}
}
