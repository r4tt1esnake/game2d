package ca.bc.southridge.ccc.game2d.entities;

import java.awt.Graphics;

import ca.bc.southridge.ccc.game2d.math.Vector;

public abstract class Entity {
	
	// Float is used here to ensure smooth movement.
	protected Vector position;
	protected int width, height;
	
	public Entity(float x, float y, int width, int height) {
		position = new Vector(x, y);
		this.width = width;
		this.height = height;
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
	
	public abstract void render(Graphics g);

}
