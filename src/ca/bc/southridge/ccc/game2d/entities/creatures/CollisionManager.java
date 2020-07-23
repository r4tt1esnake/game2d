package ca.bc.southridge.ccc.game2d.entities.creatures;

import java.awt.Rectangle;

import ca.bc.southridge.ccc.game2d.Handler;
import ca.bc.southridge.ccc.game2d.entities.Entity;
import ca.bc.southridge.ccc.game2d.utils.Constants;
import ca.bc.southridge.ccc.game2d.utils.Vector;

public class CollisionManager {
	
	private Handler handler;
	private Creature c;
	private Rectangle colBox;
	private Rectangle hitBox;
	
	// Collision-state savers
	boolean entityTestX, entityTestY, tileTestX, tileTestY;
	
	public CollisionManager(Handler handler, Creature c, Rectangle colBox, Rectangle hitBox) {
		this.handler = handler;
		this.c = c;
		this.colBox = colBox;
		this.hitBox = hitBox;
		entityTestX = true;
		entityTestY = true;
		tileTestX = true;
		tileTestY = true;
	}
	
	// TILE COLLISIONS
	
	public boolean collisionWithTile(int x, int y) {
		return !handler.getWorld().getTile(x, y).isWalkable();
	}
	
	// ENTITY COLLISIONS
	
	// Returns the collision box of the entity
	public Rectangle getCollisionBounds(float xOffset, float yOffset) {
		return new Rectangle((int) (c.getPosition().getX() + colBox.x + xOffset),
				(int) (c.getPosition().getY() + colBox.y + yOffset), colBox.width, colBox.height);
	}
	
	public boolean checkEntityCollisions(float xOffset, float yOffset) {
		for(Entity i : handler.getWorld().getEntityManager().getEntities()) {
			// Skips self-collision
			if(i.equals(c))
				continue;
			if(i.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
				return true;
		}
		return false;
	}
	
	// TOTAL COLLISIONS
	
	public boolean canMoveX() {
		Vector position = c.getPosition();
		Vector movement = c.getMovement();
		
		entityTestX = !checkEntityCollisions(movement.getX(), 0f);
		tileTestX = true;
		
		// Moving right
		if(movement.getX() > 0) {
			int tx = (int) (position.getX() + movement.getX() + colBox.x + colBox.width) / Constants.TILE_WIDTH;
			if(!collisionWithTile(tx, (int) (position.getY() + colBox.y) / Constants.TILE_HEIGHT) &&
					!collisionWithTile(tx, (int) (position.getY() + colBox.y + colBox.height) / Constants.TILE_HEIGHT)) {
				tileTestX = true;
			} else {
				tileTestX = false;
			}
		}
		
		// Moving left
		else if(movement.getX() < 0) {
			int tx = (int) (position.getX() + movement.getX() + colBox.x) / Constants.TILE_WIDTH;
			if(!collisionWithTile(tx, (int) (position.getY() + colBox.y) / Constants.TILE_HEIGHT) &&
					!collisionWithTile(tx, (int) (position.getY() + colBox.y + colBox.height) / Constants.TILE_HEIGHT)) {
				tileTestX = true;
			} else {
				tileTestX = false;
			}
		}
		
		return entityTestX && tileTestX;
	}
	
	public boolean canMoveY() {
		Vector position = c.getPosition();
		Vector movement = c.getMovement();
		
		entityTestY = !checkEntityCollisions(0f, movement.getY());
		tileTestY = true;
		
		// Moving down
		if(movement.getY() > 0) {
			int ty = (int) (position.getY() + movement.getY() + colBox.y + colBox.height) / Constants.TILE_HEIGHT;
			if(!collisionWithTile((int) (position.getX() + colBox.x) / Constants.TILE_WIDTH, ty) &&
			!collisionWithTile((int) (position.getX() + colBox.x + colBox.width) / Constants.TILE_WIDTH, ty)) {
				tileTestY = true;
			} else {
				tileTestY = false;
			}
		} 
		
		// Moving up
		else if(movement.getY() < 0) {
			int ty = (int) (position.getY() + movement.getY() + colBox.y) / Constants.TILE_HEIGHT;
			if(!collisionWithTile((int) (position.getX() + colBox.x) / Constants.TILE_WIDTH, ty) &&
			!collisionWithTile((int) (position.getX() + colBox.x + colBox.width) / Constants.TILE_WIDTH, ty)) {
				tileTestY = true;
			} else {
				tileTestY = false;
			}
		}
		
		return entityTestY && tileTestY;
	}
	
	public static enum CollisionBoxType {
		TILE,
		ENTITY,
		TILE_AND_ENTITY,
		NONE
	}
	
	public CollisionBoxType getXCollisionBoxType() {
		if(!tileTestX) {
			if(!entityTestX)
				return CollisionBoxType.TILE_AND_ENTITY;
			return CollisionBoxType.TILE;
		}
		else if(!entityTestX)
			return CollisionBoxType.ENTITY;
		else
			return CollisionBoxType.NONE;
	}
	
	public CollisionBoxType getYCollisionBoxType() {
		if(!tileTestY) {
			if(!entityTestY)
				return CollisionBoxType.TILE_AND_ENTITY;
			return CollisionBoxType.TILE;
		}
		else if(!entityTestY)
			return CollisionBoxType.ENTITY;
		else
			return CollisionBoxType.NONE;
	}

}
