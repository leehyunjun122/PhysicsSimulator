package UI;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public abstract class UIObject{

	protected float x, y;
	protected int length, height;
	protected Rectangle boundary;
	protected boolean covered = false;
	
	public UIObject(float x, float y, int length, int height) {
		this.x = x;
		this.y = y;
		this.length = length;
		this.height = height;
		boundary = new Rectangle((int) x, (int) y, length, height);
	}
	
	
	public abstract void update();
	public abstract void draw(Graphics g);
	public abstract void onClick();
	
	public void onMouseMove(MouseEvent e) {
		if(boundary.contains(e.getX(), e.getY()))
			covered = true;
		else
			covered = false;
	}
	
	public void onMouseRelease(MouseEvent e) {
		if(covered)
			onClick();
	}
	
	//get & set
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
}