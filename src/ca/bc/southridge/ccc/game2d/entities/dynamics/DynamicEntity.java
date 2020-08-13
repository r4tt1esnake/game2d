package ca.bc.southridge.ccc.game2d.entities.dynamics;

import ca.bc.southridge.ccc.game2d.Handler;
import ca.bc.southridge.ccc.game2d.entities.Entity;
import ca.bc.southridge.ccc.game2d.utils.Constants;
import ca.bc.southridge.ccc.game2d.utils.datastructures.Scaler;
import ca.bc.southridge.ccc.game2d.utils.datastructures.Vector;

public abstract class DynamicEntity extends Entity {
	
	protected float speed;
	protected Vector movement;
	protected CollisionManager cm;
	
	public DynamicEntity(Handler handler, Scaler s) {
		super(handler, s);
	}
	
	public void move() {
		// TODO: May be buggy
		if(movement.isZero())
			return;
		if(movement.getX() != 0) {
			if (cm.canMoveX())
				position.addX(movement.getX());
			else {
				int tx = (int) (position.getX() + movement.getX() + colBox.x + colBox.width) / Constants.TILE_WIDTH;
				if (cm.getXCollisionBoxType() == CollisionManager.CollisionBoxType.TILE) {
					if (movement.getX() > 0)
						position.setX(tx * Constants.TILE_WIDTH - colBox.x - colBox.width - 1);
					else if (movement.getX() < 0)
						position.setX((tx - 1) * Constants.TILE_WIDTH + Constants.TILE_WIDTH - colBox.x);
				}
			} 
		}
		if(movement.getY() != 0) {
			if (cm.canMoveY() && movement.getY() != 0)
				position.addY(movement.getY());
			else {
				int ty = (int) (position.getY() + movement.getY() + colBox.y + colBox.height) / Constants.TILE_HEIGHT;
				if (cm.getYCollisionBoxType() == CollisionManager.CollisionBoxType.TILE) {
					if (movement.getY() > 0)
						position.setY(ty * Constants.TILE_HEIGHT - colBox.y - colBox.height - 1);
					else if (movement.getY() < 0)
						position.setY((ty - 1) * Constants.TILE_HEIGHT + Constants.TILE_HEIGHT - colBox.y);
				}
			} 
		}
	}
	
	public Vector getMovement() {
		return movement;
	}

	public void setMovement(Vector movement) {
		this.movement = movement;
	}
	
	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

}
