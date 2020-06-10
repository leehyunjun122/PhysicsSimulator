package Manager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener, MouseMotionListener{
//to recognize and manage the mouse control
		private boolean leftPressed, rightPressed, roller; //the right and left clicks plus pressing the rolling thing on mouse
		//true when pressed while false when released
		private int xPosition, yPosition;
		private UI manager;
		
		public Mouse() {//constructor
			
		}
		
		public void setUIManager(UI manager) {
			this.manager = manager;
		}
		
		public boolean pressingLeft() {
			return leftPressed;
		}
		
		public boolean pressingRight() {
			return rightPressed;
		}
		
		public boolean pressingRoller() {
			return roller;
		}
		
		public int getXPosition() {
			return xPosition;
		}
		
		public int getYPosition() {
			return yPosition;
		}
		
		//codes for implemented methods
		@Override
		public void mousePressed(MouseEvent m) {
			if(m.getButton() == MouseEvent.BUTTON1)
				leftPressed = true;
			else if(m.getButton() == MouseEvent.BUTTON3)
				rightPressed = true;
			else if(m.getButton() == MouseEvent.BUTTON2)
				roller = true;
		}

		@Override
		public void mouseReleased(MouseEvent m) {
			if(m.getButton() == MouseEvent.BUTTON1)
				leftPressed = false;
			else if(m.getButton() == MouseEvent.BUTTON3)
				rightPressed = false;
			else if(m.getButton() == MouseEvent.BUTTON2)
				roller = false;
			
			if(manager != null)
				manager.onMouseRelease(m);
		}
		
		@Override
		public void mouseDragged(MouseEvent m) {
			
		}

		@Override
		public void mouseMoved(MouseEvent m) {
			xPosition = m.getX();
			yPosition = m.getY();
			
			if(manager != null)
				manager.onMouseMove(m);
		}

		@Override
		public void mouseClicked(MouseEvent m) {
		}

		@Override
		public void mouseEntered(MouseEvent m) {
		}

		@Override
		public void mouseExited(MouseEvent m) {
		}
}
