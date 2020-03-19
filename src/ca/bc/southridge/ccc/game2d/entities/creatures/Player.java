package ca.bc.southridge.ccc.game2d.entities.creatures;

import java.awt.Graphics;

import ca.bc.southridge.ccc.game2d.Game;
import ca.bc.southridge.ccc.game2d.gfx.Assets;
import ca.bc.southridge.ccc.game2d.utils.Vector;

public class Player extends Creature {
	
	private Game game;

	public Player(Game game, float x, float y) {
		super(x, y, Creature.WIDTH, Creature.HEIGHT);
		this.game = game;
	}

	@Override
	public void tick() {
		getInput();
		move();
	}
	
	private void getInput() {
		movement.zero();
		if(game.getKeyManager().up == true) {
			movement.addY(-3f);
		}
		if(game.getKeyManager().down == true) {
			movement.addY(3f);
		}
		if(game.getKeyManager().left == true) {
			movement.addX(-3f);
		}
		if(game.getKeyManager().right == true) {
			movement.addX(3f);
		}
		movement.normalize(speed);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) position.getX(), (int) position.getY(), /* image sizing */ width, height, null);
	}

}
