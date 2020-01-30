package ca.bc.southridge.ccc.game2d.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	// Load all separate images from spritesheets here!
	public static BufferedImage icon, player;
	
	public static void init() {
		SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/textures/generic_person.png"));
		
		icon = ImageLoader.loadImage("/textures/face.png");
		player = playerSheet.crop(0, 0, 256, 256);
	}

}
