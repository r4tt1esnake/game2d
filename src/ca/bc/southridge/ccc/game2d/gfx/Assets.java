package ca.bc.southridge.ccc.game2d.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	// Load all separate images from spritesheets here!
	public static BufferedImage icon, player, roughGrass, grass, water, stone, dirt; 
	
	public static void init() {
		SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/textures/generic_person.png"));
		SpriteSheet tileSheet = new SpriteSheet(ImageLoader.loadImage("/textures/tiles.png"));
		
		icon = ImageLoader.loadImage("/textures/face.png");
		player = playerSheet.crop(0, 0, 256, 256);
		roughGrass = tileSheet.crop(0, 0, 32, 32);
		water = tileSheet.crop(32, 0, 32, 32);
		grass = tileSheet.crop(64, 0, 32, 32);
		stone = tileSheet.crop(96, 0, 32, 32);
		dirt = tileSheet.crop(128, 0, 32, 32);
	}

}
