package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import Display.Display;
import Manager.Keyboard;
import Manager.Mouse;
import States.ExperimentState;
import States.SimulatingState;
import States.State;
import graphics.Input;

public class Runner implements Runnable{
	
	//for the display variables
	private Display display;
	public int length,height;
	public String title;
	
	//for the thread - mini programs that runs off the main big program
	private Thread thread;
	private boolean running = false;

	//for the buffer and graphics
	private BufferStrategy buffer;
	private Graphics graphic;

	//States
	public State simulator;
	public State experiment;
	
	//managers: keyboard, mouse
	private Keyboard key;
	private Mouse mouse;
	
	//handling object
	private Handler handler;
	
	public Runner(String title, int l, int h) {
		this.title = title;
		length = l;
		height = h;
		key = new Keyboard();
		mouse = new Mouse();
	}
	
	private void initialize() {
		display = new Display(title,length,height);
		//keyboard
		display.getFrame().addKeyListener(key);
		//mouse
		display.getFrame().addMouseListener(mouse);
		display.getFrame().addMouseMotionListener(mouse);
		display.getCanvas().addMouseListener(mouse);
		display.getCanvas().addMouseMotionListener(mouse);
		
		//initializing all the necessary materials at once
		Input.initialize();
		
		//handler
		handler = new Handler(this);
		
		//state
		simulator = new SimulatingState(handler);
		experiment = new ExperimentState(handler);
		State.setState(experiment);
	}
	
	private void update() {
		key.update();
		
		if(State.getState() != null) {
			State.getState().update();
		}
	}
	
	private void render() {
		buffer = display.getCanvas().getBufferStrategy();
		if(buffer == null) {
			display.getCanvas().createBufferStrategy(3);//three should be enough/maximum(i guess?) buffers we need
			return;
		}
		graphic = buffer.getDrawGraphics();
		graphic.clearRect(0, 0, length, height);
		
		//color setting for each state
		if(State.getState() == simulator)
			graphic.setColor(Color.pink);
			graphic.fillRect(0, 0, length, height);
		if(State.getState() == experiment)
			graphic.setColor(Color.white);
			graphic.fillRect(0, 0, length, height);	
		
		if(State.getState() != null) {
			State.getState().draw(graphic);
		}
		
		buffer.show();
		graphic.dispose();
	}
	
	public void run() {
		initialize();
		
		int fps = 150;
		double maxNum = 1000000000/fps;//the maximum number of times that update should run every second to achieve 60 fps
		double delta = 0;//the change
		long currentChange;
		long current = System.nanoTime();//its the current time
		long checker = 0;//checking if the system is well conducting
		
		while(running) {
			currentChange = System.nanoTime();//using nanosecond = small enough to be very accurate
			delta += (currentChange - current)/maxNum;
			checker += (currentChange - current);
			current = currentChange;
			
			if(delta >= 1) {
				update();
				render();
				delta--;
			}
			if(checker>=1000000000) {
				checker = 0;
			}
		}
		
		end();
		
	}
	
	public Keyboard getKey() {
		return key;
	}
	
	public Mouse getMouse() {
		return mouse;
	}
	
	public int getLength() {
		return length;
	}
	
	public int getHeight() {
		return height;
	}
	
	//for the run
	public synchronized void start() {
		if(running)//when it is already running
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	//for the run
	public synchronized void end() {
		if(!running)//when it is already ended
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
