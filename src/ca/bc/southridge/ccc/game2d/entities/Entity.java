package ca.bc.southridge.ccc.game2d.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import ca.bc.southridge.ccc.game2d.Handler;
import ca.bc.southridge.ccc.game2d.utils.Constants;
import ca.bc.southridge.ccc.game2d.utils.datastructures.Scaler;
import ca.bc.southridge.ccc.game2d.utils.datastructures.Vector;

public abstract class Entity {
	
	protected int width, height, ID;
	protected Handler handler;
	protected Vector position;
	protected Rectangle colBox, hitBox;
	
	public Entity(Handler handler, Scaler s) {
		this.handler = handler;
		position = new Vector(s.getX(), s.getY());
		this.width = (int) (0 * s.getxScale());
		this.height = (int) (0 * s.getyScale());
		
		colBox = new Rectangle(0, 0, 0, 0);
		hitBox = new Rectangle(0, 0, 0, 0);
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
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public int getID() {
		return ID;
	}

	public abstract void tick();
	
	public void render(Graphics g) {
		if(Constants.SHOW_COLLISION_BOXES) {
			g.setColor(Color.red);
			g.drawRect((int) (position.getX() + colBox.x - handler.getGameCamera().getxOffset()),
					(int) (position.getY() + colBox.y - handler.getGameCamera().getyOffset()), colBox.width, colBox.height);
		}
					
		if(Constants.SHOW_HITBOXES) {
			g.setColor(Color.blue);
			g.drawRect((int) (position.getX() + hitBox.getX() - handler.getGameCamera().getxOffset()),
					(int) (position.getY() + hitBox.getY() - handler.getGameCamera().getyOffset()),
					(int) hitBox.getWidth(), (int) hitBox.getHeight());
		}
	}
	
	public boolean getManaged() {
		if(ID == -1)
			return false;
		return true;
	}
	
	public void unmanage() {
		ID = -1;
	}
	
	// Returns the collision box of the entity
	public Rectangle getColBox(float xOffset, float yOffset) {
		return new Rectangle((int) (position.getX() + colBox.x + xOffset),
				(int) (position.getY() + colBox.y + yOffset), colBox.width, colBox.height);
	}
	
	// Returns the hit box of the entity
	public Rectangle getHitBox(float xOffset, float yOffset) {
		return new Rectangle((int) (position.getX() + hitBox.x + xOffset),
				(int) (position.getY() + hitBox.y + yOffset), hitBox.width, hitBox.height);
	}

}
