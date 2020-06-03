package graphics;

import java.awt.image.BufferedImage;

/*for anything related to image,sound,or music
to prevent the redundancy of declaring the variables with the loadimage method*/

public class Input {
		
		public static BufferedImage ball;
		public static BufferedImage[] next;
		
		public static void initialize() {//only called once
			//there will be more later on
			ball = Loader.loadImage("/Image/ball.png");
			
			next = new BufferedImage[2];
			next[0] = Loader.loadImage("/Image/NextButton1.png");
			next[1] = Loader.loadImage("/Image/NextButton2.png");
			
			
			
		}

}
