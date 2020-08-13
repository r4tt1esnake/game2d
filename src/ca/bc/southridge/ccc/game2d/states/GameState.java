package ca.bc.southridge.ccc.game2d.states;

import java.awt.Graphics;

import ca.bc.southridge.ccc.game2d.Handler;
import ca.bc.southridge.ccc.game2d.entities.dynamics.Player;
import ca.bc.southridge.ccc.game2d.worlds.World;

public class GameState extends State {
	
	private Player player;
	private World world;
	
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		// handler.setWorld(world);
	}

	@Override
	public void tick() {
		// poll for universal inputs here
		if(handler.getKeyManager().key_esc)
			State.setState(handler.getGame().getMenuState());
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}

}
