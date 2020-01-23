package ca.bc.southridge.ccc.game2d.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	// Load all separate images from spritesheets here!
	public static BufferedImage icon;
	
	public static void init() {
		icon = ImageLoader.loadImage("/textures/face.png");
	}

}
