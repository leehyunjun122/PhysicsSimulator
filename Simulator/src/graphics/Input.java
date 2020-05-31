package graphics;

import java.awt.image.BufferedImage;

/*for anything related to image,sound,or music
to prevent the redundancy of declaring the variables with the loadimage method*/

public class Input {
		
		public static BufferedImage ball;
		
		public static void initialize() {//only called once
			//there will be more later on
			ball = Loader.loadImage("/images/ball.png");
			
		}

}
