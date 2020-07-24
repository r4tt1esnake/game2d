package ca.bc.southridge.ccc.game2d.entities.dynamics;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import ca.bc.southridge.ccc.game2d.Handler;
import ca.bc.southridge.ccc.game2d.entities.Entity;
import ca.bc.southridge.ccc.game2d.utils.Constants;
import ca.bc.southridge.ccc.game2d.utils.datastructures.QuadTree;
import ca.bc.southridge.ccc.game2d.utils.datastructures.Vector;

public class CollisionManager {
	
	private Handler handler;
	private DynamicEntity c;
	private Rectangle colBox;
	private Rectangle hitBox;
	private QuadTree colTree;
	
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
		colTree = handler.getWorld().getColTree();
	}
	
	// TILE COLLISIONS
	
	public boolean collisionWithTile(int x, int y) {
		return !handler.getWorld().getTile(x, y).isWalkable();
	}
	
	// ENTITY COLLISIONS
	
	public boolean checkEntityCollisions(float xOffset, float yOffset) {
		if(!Constants.SHOULD_USE_BAD_COLLISION) {
			
			// QuadTree collision (doesn't fucking work!!!!!!)
			List<Rectangle> retObjs = new ArrayList<Rectangle>();
			colTree.retrive(retObjs, c.getColBox(0, 0));
			System.out.println("Num of potential colliders " + retObjs.size());
			for(Rectangle i : retObjs) {
				if(i.equals(c.getColBox(0, 0)))
					continue;
				
				System.out.println("Player coords at " + c.getPosition().getX() + ", " + c.getPosition().getY());
				System.out.println("Potential collision at " + i.x + ", " + i.y);
		
				if(i.intersects(c.getColBox(xOffset, yOffset))) {
					System.out.println("Entity collision!");
					return true;
				}
			}
			return false;
			
		}
		else {
			
			// Bad collision
			for(Entity e : handler.getWorld().getEntityManager().getEntities()) {
				if(e.equals((Entity) c))
					continue;
		
				if(e.getColBox(0, 0).intersects(c.getColBox(xOffset, yOffset))) {
					return true;
				}
			}
			return false;
			
		}
			
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
