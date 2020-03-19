package ca.bc.southridge.ccc.game2d.worlds;

import java.awt.Graphics;

import ca.bc.southridge.ccc.game2d.tiles.Tile;

public class World {
	
	private int width, height; // This is in terms of tiles.
	private int[][] tiles; // In the format of (x, y);
	
	public World(String path) {
		loadWorld(path);
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				getTile(x, y).render(g, x * Tile.WIDTH, y * Tile.HEIGHT); // Must convert tile units into pixels!
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null) 
			return Tile.grassTile;
		return t;
	}
	
	private void loadWorld(String path) {
		width = 5;
		height = 5;
		tiles = new int[width][height];
		
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				tiles[x][y] = 0;
			}
		}
	}

}
