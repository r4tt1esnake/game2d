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
	
	public CollisionManager(Handler handler, Creature c, Rectangle colBox, Rectangle hitBox) {
		this.handler = handler;
		this.c = c;
		this.colBox = colBox;
		this.hitBox = hitBox;
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
		
		boolean entityTest = !checkEntityCollisions(movement.getX(), 0f);
		boolean tileTest = true;
		
		// Moving right
		if(movement.getX() > 0) {
			int tx = (int) (position.getX() + movement.getX() + colBox.x + colBox.width) / Constants.TILE_WIDTH;
			if(!collisionWithTile(tx, (int) (position.getY() + colBox.y) / Constants.TILE_HEIGHT) &&
					!collisionWithTile(tx, (int) (position.getY() + colBox.y + colBox.height) / Constants.TILE_HEIGHT)) {
				tileTest = true;
			} else {
				tileTest = false;
			}
		}
		
		// Moving left
		else if(movement.getX() < 0) {
			int tx = (int) (position.getX() + movement.getX() + colBox.x) / Constants.TILE_WIDTH;
			if(!collisionWithTile(tx, (int) (position.getY() + colBox.y) / Constants.TILE_HEIGHT) &&
					!collisionWithTile(tx, (int) (position.getY() + colBox.y + colBox.height) / Constants.TILE_HEIGHT)) {
				tileTest = true;
			} else {
				tileTest = false;
			}
		}
		
		return entityTest && tileTest;
	}
	
	public boolean canMoveY() {
		Vector position = c.getPosition();
		Vector movement = c.getMovement();
		
		boolean entityTest = !checkEntityCollisions(0f, movement.getY());
		boolean tileTest = true;
		
		// Moving down
		if(movement.getY() > 0) {
			int ty = (int) (position.getY() + movement.getY() + colBox.y + colBox.height) / Constants.TILE_HEIGHT;
			if(!collisionWithTile((int) (position.getX() + colBox.x) / Constants.TILE_WIDTH, ty) &&
			!collisionWithTile((int) (position.getX() + colBox.x + colBox.width) / Constants.TILE_WIDTH, ty)) {
				tileTest = true;
			} else {
				tileTest = false;
			}
		} 
		
		// Moving up
		else if(movement.getY() < 0) {
			int ty = (int) (position.getY() + movement.getY() + colBox.y) / Constants.TILE_HEIGHT;
			if(!collisionWithTile((int) (position.getX() + colBox.x) / Constants.TILE_WIDTH, ty) &&
			!collisionWithTile((int) (position.getX() + colBox.x + colBox.width) / Constants.TILE_WIDTH, ty)) {
				tileTest = true;
			} else {
				tileTest = false;
			}
		}
		
		return entityTest && tileTest;
	}

}
