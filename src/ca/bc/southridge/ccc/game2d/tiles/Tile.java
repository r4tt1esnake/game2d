package ca.bc.southridge.ccc.game2d.tiles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import ca.bc.southridge.ccc.game2d.utils.Constants;

public class Tile {
	
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile stoneTile = new CliffTile(1);
	public static Tile grassFlowerTile = new GrassFlowerTile(2);
	
	public static Tile dirtPathTile_V = new DirtPathTile_V(3);
	public static Tile dirtPathTile_C = new DirtPathTile_C(4);
	public static Tile dirtPathTile_H = new DirtPathTile_H(5);
	public static Tile dirtPathTile_V_T_U = new DirtPathTile_V_T_U(6);
	public static Tile dirtPathTile_V_T_D = new DirtPathTile_V_T_D(7);
	public static Tile dirtPathTile_H_T_R = new DirtPathTile_H_T_R(8);
	public static Tile dirtPathTile_H_T_L = new DirtPathTile_H_T_L(9);
	
	public static Tile waterTile_V = new WaterTile_V(10);
	public static Tile waterTile_C = new WaterTile_C(11);
	public static Tile waterTile_H = new WaterTile_H(12);
	public static Tile waterTile_V_T_U = new WaterTile_V_T_U(13);
	public static Tile waterTile_V_T_D = new WaterTile_V_T_D(14);
	public static Tile waterTile_H_T_R = new WaterTile_H_T_R(15);
	public static Tile waterTile_H_T_L = new WaterTile_H_T_L(16);
	
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
		g.drawImage(texture, x, y, Constants.TILE_WIDTH, Constants.TILE_HEIGHT, null);
		if(Constants.SHOW_COLLISION_BOXES) {
			g.setColor(Color.red);
			g.drawRect(x, y, Constants.TILE_WIDTH, Constants.TILE_HEIGHT);
		}
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
