package ca.bc.southridge.ccc.game2d.gfx;

import java.awt.image.BufferedImage;

import ca.bc.southridge.ccc.game2d.utils.Constants;

public class Assets {
	
	// Load all separate images from spritesheets here!
	public static BufferedImage icon, grass, grass_pebble, grass_flowers, 
	dirtpath_v, dirtpath_c, dirtpath_h, dirtpath_v_t_u, dirtpath_v_t_d, dirtpath_h_t_r, dirtpath_h_t_l,
	water_v, water_c, water_h, water_v_t_u, water_v_t_d, water_h_t_r, water_h_t_l,
	tree;
	
	public static BufferedImage[] player_down, player_up, player_left, player_right,
	player_down_idle, player_up_idle, player_left_idle, player_right_idle;
	
	public static void init() {
		icon = ImageLoader.loadImage("/textures/face.png");
		tree = ImageLoader.loadImage("/textures/face.png");
		
		SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/textures/village_girl.png"));
		
		player_down = new BufferedImage[3];
		for(int i = 0; i < 3; i++) {
			player_down[i] = playerSheet.crop(Constants.CELL_SIDE * i, 0, Constants.CELL_SIDE, Constants.CELL_SIDE * 2);
		}
		
		player_up = new BufferedImage[3];
		for(int i = 3; i < 6; i++) {
			player_up[i - 3] = playerSheet.crop(Constants.CELL_SIDE * i, 0, Constants.CELL_SIDE, Constants.CELL_SIDE * 2);
		}
		
		player_right = new BufferedImage[3];
		for(int i = 0; i < 3; i++) {
			player_right[i] = playerSheet.crop(Constants.CELL_SIDE * i, Constants.CELL_SIDE * 2, Constants.CELL_SIDE, Constants.CELL_SIDE * 2);
		}
		
		player_left = new BufferedImage[3];
		for(int i = 3; i < 6; i++) {
			player_left[i - 3] = playerSheet.crop(Constants.CELL_SIDE * i, Constants.CELL_SIDE * 2, Constants.CELL_SIDE, Constants.CELL_SIDE * 2);
		}
		
		player_down_idle = new BufferedImage[] {playerSheet.crop(0, 0, Constants.CELL_SIDE, Constants.CELL_SIDE * 2)};
		player_up_idle = new BufferedImage[] {playerSheet.crop(Constants.CELL_SIDE * 3, 0, Constants.CELL_SIDE, Constants.CELL_SIDE * 2)};
		player_right_idle = new BufferedImage[] {playerSheet.crop(0, Constants.CELL_SIDE * 2, Constants.CELL_SIDE, Constants.CELL_SIDE * 2)};
		player_left_idle = new BufferedImage[] {playerSheet.crop(Constants.CELL_SIDE * 3, Constants.CELL_SIDE * 2, Constants.CELL_SIDE, Constants.CELL_SIDE * 2)};
		
		SpriteSheet tileSheet = new SpriteSheet(ImageLoader.loadImage("/textures/tiles.png"));
		
		grass = tileSheet.crop(Constants.CELL_SIDE * 0, 0, Constants.CELL_SIDE, Constants.CELL_SIDE);
		grass_pebble = tileSheet.crop(Constants.CELL_SIDE * 1, 0, Constants.CELL_SIDE, Constants.CELL_SIDE);
		grass_flowers = tileSheet.crop(Constants.CELL_SIDE * 2, 0, Constants.CELL_SIDE, Constants.CELL_SIDE);
		
		dirtpath_v = tileSheet.crop(Constants.CELL_SIDE * 3, 0, Constants.CELL_SIDE, Constants.CELL_SIDE);
		dirtpath_c = tileSheet.crop(Constants.CELL_SIDE * 4, 0, Constants.CELL_SIDE, Constants.CELL_SIDE);
		dirtpath_h = tileSheet.crop(Constants.CELL_SIDE * 5, 0, Constants.CELL_SIDE, Constants.CELL_SIDE);
		dirtpath_v_t_u = tileSheet.crop(Constants.CELL_SIDE * 6, 0, Constants.CELL_SIDE, Constants.CELL_SIDE);
		dirtpath_v_t_d = tileSheet.crop(Constants.CELL_SIDE * 7, 0, Constants.CELL_SIDE, Constants.CELL_SIDE);
		dirtpath_h_t_r = tileSheet.crop(Constants.CELL_SIDE * 8, 0, Constants.CELL_SIDE, Constants.CELL_SIDE);
		dirtpath_h_t_l = tileSheet.crop(Constants.CELL_SIDE * 9, 0, Constants.CELL_SIDE, Constants.CELL_SIDE);
		
		water_v = tileSheet.crop(Constants.CELL_SIDE * 10, 0, Constants.CELL_SIDE, Constants.CELL_SIDE);
		water_c = tileSheet.crop(Constants.CELL_SIDE * 11, 0, Constants.CELL_SIDE, Constants.CELL_SIDE);
		water_h = tileSheet.crop(Constants.CELL_SIDE * 12, 0, Constants.CELL_SIDE, Constants.CELL_SIDE);
		water_v_t_u = tileSheet.crop(Constants.CELL_SIDE * 13, 0, Constants.CELL_SIDE, Constants.CELL_SIDE);
		water_v_t_d = tileSheet.crop(Constants.CELL_SIDE * 14, 0, Constants.CELL_SIDE, Constants.CELL_SIDE);
		water_h_t_r = tileSheet.crop(Constants.CELL_SIDE * 15, 0, Constants.CELL_SIDE, Constants.CELL_SIDE);
		water_h_t_l = tileSheet.crop(Constants.CELL_SIDE * Constants.CELL_SIDE, 0, Constants.CELL_SIDE, Constants.CELL_SIDE);
	}

}
