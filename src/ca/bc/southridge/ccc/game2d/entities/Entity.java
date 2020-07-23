package ca.bc.southridge.ccc.game2d.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import ca.bc.southridge.ccc.game2d.Handler;
import ca.bc.southridge.ccc.game2d.utils.Constants;
import ca.bc.southridge.ccc.game2d.utils.Vector;

public abstract class Entity {
	
	protected Handler handler;
	// Float is used here to ensure smooth movement.
	protected Vector position;
	protected int width, height;
	protected Rectangle bounds;
	
	public Entity(Handler handler, float x, float y, int width, int height) {
		this.handler = handler;
		position = new Vector(x, y);
		this.width = width;
		this.height = height;
		
		bounds = new Rectangle(0, 0, width, height);
	}
	
	public Vector getPosition() {
		return position;
	}
	
	public void setPosition(Vector position) {
		this.position = position;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public abstract void tick();
	
	public void render(Graphics g) {
		if(Constants.DEBUG) {
			g.setColor(Color.red);
			g.drawRect((int) (position.getX() + bounds.x - handler.getGameCamera().getxOffset()),
					(int) (position.getY() + bounds.y - handler.getGameCamera().getyOffset()), bounds.width,
					bounds.height);
		}
	}
	
	// The offset is there so that we can get check collisions previous to when the entity actually collides
	public boolean checkEntityCollisions(float xOffset, float yOffset) {
		for(Entity e : handler.getWorld().getEntityManager().getEntities()) {
			// Skips self-collision
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
				return true;
		}
		return false;
	}
	
	// Returns the collision box of the entity
	public Rectangle getCollisionBounds(float xOffset, float yOffset) {
		return new Rectangle((int) (position.getX() + bounds.x + xOffset), (int) (position.getY() + bounds.y + yOffset), bounds.width, bounds.height);
	}

}
