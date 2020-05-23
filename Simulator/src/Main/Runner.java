package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import Display.Display;
import graphics.Loader;

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
	
	private BufferedImage picture;
	
	public Runner(String title, int l, int h) {
		this.title = title;
		length = l;
		height = h;
	}
	
	private void initialize() {
		display = new Display(title,length,height);
		picture = Loader.loadImage("/Image/ball.png");
	}
	
	private void update() {
		
	}
	
	private void render() {
		buffer = display.getCanvas().getBufferStrategy();
		if(buffer == null) {
			display.getCanvas().createBufferStrategy(3);//three should be enough/maximum(i guess?) buffers we need
			return;
		}
		graphic = buffer.getDrawGraphics();
		graphic.clearRect(0, 0, length, height);		
		graphic.drawImage(picture, 20, 20, null);
		buffer.show();
		graphic.dispose();
	}
	
	public void run() {
		initialize();
		
		while(running) {
			update();
			render();
		}
		
		end();
		
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
