package UI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Button extends UIObject{
		
		private BufferedImage[] images;
		private ClickListener clicker;
		
		public Button(float x, float y, int length, int height, BufferedImage[] images, ClickListener clicker) {
			super(x, y, length, height);
			this.images = images;
			this.clicker = clicker;
		}

		@Override
		public void update() {
		}

		@Override
		public void draw(Graphics g) {
		}

		@Override
		public void onClick() {
			clicker.onClick();
		}

}
