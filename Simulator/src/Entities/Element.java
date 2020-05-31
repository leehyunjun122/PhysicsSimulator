package Entities;

import java.awt.Graphics;

import Main.Handler;
import graphics.Input;

public class Element extends Entity{

	private Handler handler;
	
	protected float speed;
	public static final float REGULAR_SPEED = 3.0f;
	public static final int HEIGHT = 150,
							LENGTH = 150;
	protected float xChange, yChange;
	
	public Element(Handler handler, float xPosition, float yPosition) {
		super(handler, xPosition, yPosition, LENGTH, HEIGHT);
		this.handler = handler;
		speed = REGULAR_SPEED;
	}
	
	public void move() {
		x += xChange;
		y += yChange;
	}

	public float getxChange() {
		return xChange;
	}

	public void setxChange(float xChange) {
		this.xChange = xChange;
	}

	public float getyChange() {
		return yChange;
	}

	public void setyChange(float yChange) {
		this.yChange = yChange;
	}

	@Override
	public void update() {
		getMovement();
		move();
	}
	
	private void getMovement() {
		xChange = 0;
		yChange = 0;
		
		if(handler.getKey().up)
			yChange = -speed;
		if(handler.getKey().down)
			yChange = speed;
		if(handler.getKey().left)
			xChange = -speed;
		if(handler.getKey().right)
			xChange = speed;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(Input.ball, (int) x, (int) y, length, height, null);
	}

}
