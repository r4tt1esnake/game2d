package ca.bc.southridge.ccc.game2d.utils;

public final class Constants {
	// Sprite Sheet Scaling
	public static final int CELL_SIDE = 16;
	
	// Fundamental
	public static final int GAME_FPS = 60;
	public static final double SCALE = 6;
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
	
	// Attributes
	public static final double CREATURE_HEALTH = 100.0;
	public static final float CREATURE_SPEED = 2.5f;
	
	// Debug
	public static final boolean DEBUG = true;

}
