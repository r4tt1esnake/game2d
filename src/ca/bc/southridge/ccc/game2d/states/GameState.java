package ca.bc.southridge.ccc.game2d.states;

import java.awt.Graphics;

import ca.bc.southridge.ccc.game2d.Game;
import ca.bc.southridge.ccc.game2d.entities.creatures.Player;
import ca.bc.southridge.ccc.game2d.tiles.Tile;
import ca.bc.southridge.ccc.game2d.worlds.World;

public class GameState extends State {
	
	private Player player;
	private World world;
	
	public GameState(Game game) {
		super(game);
		player = new Player(game, 100, 100);
		world = new World("");
	}

	@Override
	public void tick() {
		world.tick();
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
	}

}
