package ca.bc.southridge.ccc.game2d.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;

import ca.bc.southridge.ccc.game2d.Game;
import ca.bc.southridge.ccc.game2d.Handler;
import ca.bc.southridge.ccc.game2d.gfx.Assets;

public class Player extends Creature {

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.WIDTH, Creature.HEIGHT);
		
		bounds.x = 16;
		bounds.y = 32;
		bounds.width = 32;
		bounds.height = 32;
	}

	@Override
	public void tick() {
		getInput();
		move();
		handler.getGameCamera().lock(this);
	}
	
	private void getInput() {
		movement.zero();
		if(handler.getKeyManager().up == true) {
			movement.addY(-3f);
		}
		if(handler.getKeyManager().down == true) {
			movement.addY(3f);
		}
		if(handler.getKeyManager().left == true) {
			movement.addX(-3f);
		}
		if(handler.getKeyManager().right == true) {
			movement.addX(3f);
		}
		movement.normalize(speed);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), /* image sizing */ width, height, null);
		if (Game.DEBUG) {
			g.setColor(Color.red);
			g.fillRect((int) (position.getX() + bounds.x - handler.getGameCamera().getxOffset()),
					(int) (position.getY() + bounds.y - handler.getGameCamera().getyOffset()), bounds.width,
					bounds.height);
		}
	}

}
