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

}
