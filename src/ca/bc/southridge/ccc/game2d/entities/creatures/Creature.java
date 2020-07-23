package ca.bc.southridge.ccc.game2d.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;

import ca.bc.southridge.ccc.game2d.Handler;
import ca.bc.southridge.ccc.game2d.entities.Entity;
import ca.bc.southridge.ccc.game2d.utils.Constants;
import ca.bc.southridge.ccc.game2d.utils.Vector;

public abstract class Creature extends Entity {
	
	protected double health;
	protected Vector movement;
	protected float speed;
	protected CollisionManager cm;

	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = Constants.CREATURE_HEALTH;
		speed = Constants.CREATURE_SPEED;
		movement = new Vector(0, 0);
		cm = new CollisionManager(handler, this, bounds, new Rectangle(0, 0));
	}
	
	public void move() {
		if(cm.canMoveX())
			position.addX(movement.getX());
		else {
			int tx = (int) (position.getX() + movement.getX() + bounds.x + bounds.width) / Constants.TILE_WIDTH;
			if(cm.getXCollisionBoxType() == CollisionManager.CollisionBoxType.TILE) {
				if (movement.getX() > 0)
					position.setX(tx * Constants.TILE_WIDTH - bounds.x - bounds.width - 1);
				else if (movement.getX() < 0)
					position.setX((tx - 1) * Constants.TILE_WIDTH + Constants.TILE_WIDTH - bounds.x);
			}
		}
		if(cm.canMoveY())
			position.addY(movement.getY());
		else {
			int ty = (int) (position.getY() + movement.getY() + bounds.y + bounds.height) / Constants.TILE_HEIGHT;
			if(cm.getYCollisionBoxType() == CollisionManager.CollisionBoxType.TILE) {
				if (movement.getY() > 0)
					position.setY(ty * Constants.TILE_HEIGHT - bounds.y - bounds.height - 1);
				else if (movement.getY() < 0)
					position.setY((ty - 1) * Constants.TILE_HEIGHT + Constants.TILE_HEIGHT - bounds.y);
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
	
	public void render(Graphics g) {
		super.render(g);
	}

}
