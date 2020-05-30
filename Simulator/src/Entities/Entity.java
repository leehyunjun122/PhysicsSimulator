package Entities;

import java.awt.Graphics;

import Main.Handler;

public abstract class Entity {
	
	protected Handler handler;
	protected float x, y;
	protected int length, height;
	
	
	public Entity(Handler handler, float xPosition, float yPosition, int l, int h) {
		this.handler = handler;
		x = xPosition;
		y = yPosition;
		length = l;
		height = h;
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public abstract void update();
	
	public abstract void draw(Graphics g);
}
