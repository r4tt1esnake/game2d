package ca.bc.southridge.ccc.game2d;

import ca.bc.southridge.ccc.game2d.gfx.GameCamera;
import ca.bc.southridge.ccc.game2d.input.KeyManager;
import ca.bc.southridge.ccc.game2d.utils.Constants;
import ca.bc.southridge.ccc.game2d.worlds.World;

public class Handler {
	
	private Game game;
	private World world;
	
	public Handler(Game game) {
		this.game = game;
	}
	
	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	
	public int getWidth() {
		return Constants.WINDOW_WIDTH;
	}
	
	public int getHeight() {
		return Constants.WINDOW_HEIGHT;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

}
