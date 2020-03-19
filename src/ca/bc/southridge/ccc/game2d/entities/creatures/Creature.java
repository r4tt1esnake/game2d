package ca.bc.southridge.ccc.game2d.entities.creatures;

import ca.bc.southridge.ccc.game2d.entities.Entity;
import ca.bc.southridge.ccc.game2d.utils.Vector;

public abstract class Creature extends Entity {
	
	public static final int HEALTH = 10;
	public static final float SPEED = 2.0f;
	public static final int WIDTH = 64, 
			HEIGHT = 64;
	
	protected double health;
	protected float speed;
	protected Vector movement;

	public Creature(float x, float y, int width, int height) {
		super(x, y, width, height);
		health = HEALTH;
		speed = SPEED;
		movement = new Vector(0, 0);
	}
	
	public void move() {
		position.addX(movement.getX());
		position.addY(movement.getY());
	}

	public Vector getMovement() {
		return movement;
	}

	public void setMovement(Vector movement) {
		this.movement = movement;
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

}
