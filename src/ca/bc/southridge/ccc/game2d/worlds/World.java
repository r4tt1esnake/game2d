package ca.bc.southridge.ccc.game2d.worlds;

import java.awt.Graphics;

import ca.bc.southridge.ccc.game2d.Handler;
import ca.bc.southridge.ccc.game2d.entities.EntityManager;
import ca.bc.southridge.ccc.game2d.entities.creatures.Player;
import ca.bc.southridge.ccc.game2d.entities.statics.Tree;
import ca.bc.southridge.ccc.game2d.tiles.Tile;
import ca.bc.southridge.ccc.game2d.utils.Constants;
import ca.bc.southridge.ccc.game2d.utils.Utils;
import ca.bc.southridge.ccc.game2d.utils.Vector;

public class World {
	
	private Handler handler;
	private int width, height; // This is in terms of tiles.
	private Vector spawn; // This is also in terms of tiles.
	private int[][] tiles; // In the format of (x, y);
	
	private EntityManager entityManager;

	public World(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 0, 0));
		
		loadWorld(path);
		
		entityManager.getPlayer().getPosition().setX(spawn.getX() * Constants.TILE_WIDTH);
		entityManager.getPlayer().getPosition().setY(spawn.getY() * Constants.TILE_HEIGHT);
		
		entityManager.addEntity(new Tree(handler, 3 * Constants.TILE_WIDTH, 3 * Constants.TILE_HEIGHT));
	}
	
	public void tick() {
		entityManager.tick();
	}
	
	public void render(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Constants.TILE_WIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Constants.TILE_WIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Constants.TILE_HEIGHT);
		int yEnd = (int) Math.min(width, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Constants.TILE_HEIGHT + 1);
		
		for(int y = yStart; y < yEnd; y++) {
			for(int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int)(x * Constants.TILE_WIDTH - handler.getGameCamera().getxOffset()), 
						(int)(y * Constants.TILE_HEIGHT - handler.getGameCamera().getyOffset())); // Must convert tile units into pixels!
			}
		}
		
		entityManager.render(g);
	}
	
	public Tile getTile(int x, int y) {
		// Ensure glitch-free boundary-breaking
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.stoneTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null) 
			return Tile.grassTile;
		return t;
	}
	
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawn = new Vector(Utils.parseInt(tokens[2]), Utils.parseInt(tokens[3]));
		
		tiles = new int[width][height];
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	
	public Vector getSpawn() {
		return spawn;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
