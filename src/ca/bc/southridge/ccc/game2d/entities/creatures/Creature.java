package ca.bc.southridge.ccc.game2d.entities.creatures;

import ca.bc.southridge.ccc.game2d.Handler;
import ca.bc.southridge.ccc.game2d.entities.Entity;
import ca.bc.southridge.ccc.game2d.tiles.Tile;
import ca.bc.southridge.ccc.game2d.utils.Vector;

public abstract class Creature extends Entity {
	
	public static final int HEALTH = 10;
	public static final float SPEED = 2.0f;
	public static final int WIDTH = 64, 
			HEIGHT = 64;
	
	protected double health;
	protected float speed;
	protected Vector movement;

	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = HEALTH;
		speed = SPEED;
		movement = new Vector(0, 0);
	}
	
	public void move() {
		moveX();
		moveY();
	}
	
	public void moveX() {
		// Moving right
		if(movement.getX() > 0) {
			int tx = (int) (position.getX() + movement.getX() + bounds.x + bounds.width) / Tile.WIDTH;
			if(!collisionWithTile(tx, (int) (position.getY() + bounds.y) / Tile.HEIGHT) &&
					!collisionWithTile(tx, (int) (position.getY() + bounds.y + bounds.height) / Tile.HEIGHT)) {
				position.addX(movement.getX());
			} else {
				position.setX(tx * Tile.WIDTH - bounds.x - bounds.width - 1);
			}
		}
		// Moving left
		else if(movement.getX() < 0) {
			int tx = (int) (position.getX() + movement.getX() + bounds.x) / Tile.WIDTH;
			if(!collisionWithTile(tx, (int) (position.getY() + bounds.y) / Tile.HEIGHT) &&
					!collisionWithTile(tx, (int) (position.getY() + bounds.y + bounds.height) / Tile.HEIGHT)) {
				position.addX(movement.getX());
			} else {
				position.setX(tx * Tile.WIDTH + Tile.WIDTH - bounds.x);
			}
		}
	}
	
	public void moveY() {
		// Moving down
		if(movement.getY() > 0) {
			int ty = (int) (position.getY() + movement.getY() + bounds.y + bounds.height) / Tile.HEIGHT;
			if(!collisionWithTile((int) (position.getX() + bounds.x) / Tile.WIDTH, ty) &&
			!collisionWithTile((int) (position.getX() + bounds.x + bounds.width) / Tile.WIDTH, ty)) {
				position.addY(movement.getY());
			} else {
				position.setY(ty * Tile.HEIGHT - bounds.y - bounds.height - 1);
			}
		} 
		// Moving up
		else if(movement.getY() < 0) {
			int ty = (int) (position.getY() + movement.getY() + bounds.y) / Tile.HEIGHT;
			if(!collisionWithTile((int) (position.getX() + bounds.x) / Tile.WIDTH, ty) &&
			!collisionWithTile((int) (position.getX() + bounds.x + bounds.width) / Tile.WIDTH, ty)) {
				position.addY(movement.getY());
			} else {
				position.setY(ty * Tile.HEIGHT + Tile.HEIGHT - bounds.y);
			}
		}
	}
	
	protected boolean collisionWithTile(int x, int y) {
		return !handler.getWorld().getTile(x, y).isWalkable();
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
