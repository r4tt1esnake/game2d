package ca.bc.southridge.ccc.game2d.utils;

public final class Constants {
	// Sprite Sheet Scaling
	public static final int CELL_SIDE = 16;
	
	// Fundamental
	public static final int GAME_FPS = 60;
	public static final double SCALE = 4;
	public static final int UNIT = (int) (CELL_SIDE * SCALE);
	
	// Window
	public static final String WINDOW_TITLE = "game2D";
	public static final int WINDOW_WIDTH = UNIT * 10;
	public static final int WINDOW_HEIGHT = UNIT * 10;
	
	// Scaling
	public static final int TILE_WIDTH = UNIT;
	public static final int TILE_HEIGHT = UNIT;
	
	public static final int CREATURE_WIDTH = UNIT;
	public static final int CREATURE_HEIGHT = UNIT * 2;
	
	public static final int TREE_WIDTH = UNIT * 2;
	public static final int TREE_HEIGHT = UNIT * 3;
	
	public static final int ROCK_WIDTH = UNIT;
	public static final int ROCK_HEIGHT = UNIT;
	
	public static final int UI_ELEMENT_WIDTH = UNIT * 2;
	public static final int UI_ELEMENT_HEIGHT = UNIT * 1;
	
	public static final int UI_IMAGEBUTTON_WIDTH = UNIT * 2;
	public static final int UI_IMAGEBUTTON_HEIGHT = UNIT * 1;
	
	// Attributes
	public static final double CREATURE_HEALTH = 100.0;
	public static final float CREATURE_SPEED = 2.5f;
	
	// Debug
	public static final boolean SHOW_HITBOXES = true;
	public static final boolean SHOW_COLLISION_BOXES = true;
	public static final boolean OUTPUT_FPS = false;
	public static final boolean SHOW_COLLISION_REGIONS = false;
	public static final boolean SHOULD_USE_BAD_COLLISION = true;

}
