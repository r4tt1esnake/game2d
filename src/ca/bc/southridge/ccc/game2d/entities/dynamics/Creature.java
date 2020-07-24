package ca.bc.southridge.ccc.game2d.entities.dynamics;

import java.awt.Graphics;
import java.awt.Rectangle;

import ca.bc.southridge.ccc.game2d.Handler;
import ca.bc.southridge.ccc.game2d.entities.Entity;
import ca.bc.southridge.ccc.game2d.utils.Constants;
import ca.bc.southridge.ccc.game2d.utils.datastructures.Vector;

public abstract class Creature extends DynamicEntity {
	
	protected double health;

	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = Constants.CREATURE_HEALTH;
		speed = Constants.CREATURE_SPEED;
		movement = new Vector(0, 0);
		cm = new CollisionManager(handler, this, colBox, new Rectangle(0, 0));
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}
	
	public void render(Graphics g) {
		super.render(g);
	}

}
