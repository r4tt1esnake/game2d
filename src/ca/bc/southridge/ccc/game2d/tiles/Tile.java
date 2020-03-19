package ca.bc.southridge.ccc.game2d.tiles;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import ca.bc.southridge.ccc.game2d.utils.ImageLib;

public class Tile {
	
	public static Tile[] tiles = new Tile[256];
	public static Tile roughGrassTile = new RoughGrassTile(0);
	public static Tile waterTile = new WaterTile(1);
	public static Tile grassTile = new GrassTile(2);
	public static Tile RockTile = new StoneTile(3);
	public static Tile dirtTile = new DirtTile(4);
	
	public static final int WIDTH = 64, HEIGHT = 64;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, WIDTH, HEIGHT, null);
	}
	
	public boolean isWalkable() {
		return true;
	}
	
	// Is the tile generic? Can it be randomly rotated without losing uniformity?
	public boolean isGeneric() {
		return true;
	}
	
	public int getId() {
		return id;
	}
	
}
