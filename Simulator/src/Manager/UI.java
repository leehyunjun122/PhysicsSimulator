package Manager;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Main.Handler;
import UI.UIObject;

public class UI {
	//to recognize and manage the UI
	private Handler handler;
	private ArrayList<UIObject> object;
		
	public UI(Handler handler) {
		this.handler = handler;
		object = new ArrayList<UIObject>();
	}
		
	public void update() {
		for(UIObject o : object)
			o.update();
	}
		
	public void draw(Graphics g) {
		for(UIObject o : object)
			o.draw(g);
	}
		
	public void onMouseMove(MouseEvent e) {
		for(UIObject o : object)
			o.onMouseMove(e);
	}
		
	public void onMouseRelease(MouseEvent e) {
		for(UIObject o : object)
			o.onMouseRelease(e);
	}
		
	public void addObject(UIObject o) {
		object.add(o);
	}
		
	public void removeObject(UIObject o) {
		object.remove(o);
	}

}
