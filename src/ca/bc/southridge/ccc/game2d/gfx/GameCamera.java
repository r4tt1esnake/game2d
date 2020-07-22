package ca.bc.southridge.ccc.game2d.gfx;

import ca.bc.southridge.ccc.game2d.Handler;
import ca.bc.southridge.ccc.game2d.entities.Entity;
import ca.bc.southridge.ccc.game2d.utils.Constants;

public class GameCamera {
	
	private Handler handler;
	private float xOffset, yOffset;
	
	public GameCamera(Handler handler, float xOffset, float yOffset) {
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void checkBlankSpace() {
		
		if(handler.getWidth() < handler.getWorld().getWidth()) {
			if (xOffset < 0) {
				xOffset = 0;
			} else if (xOffset > handler.getWorld().getWidth() * Constants.TILE_WIDTH - handler.getWidth()) {
				xOffset = handler.getWorld().getWidth() * Constants.TILE_WIDTH - handler.getWidth();
			}
		} else {
			xOffset = -(handler.getWidth() - handler.getWorld().getWidth() * Constants.TILE_WIDTH) / 2;
		}
		
		if(handler.getHeight() < handler.getWorld().getHeight()) {
			if (yOffset < 0) {
				yOffset = 0;
			} else if (yOffset > handler.getWorld().getHeight() * Constants.TILE_HEIGHT - handler.getHeight()) {
				yOffset = handler.getWorld().getHeight() * Constants.TILE_HEIGHT - handler.getHeight();
			} 
		} else {
			yOffset = -(handler.getHeight() - handler.getWorld().getHeight() * Constants.TILE_HEIGHT) / 2;
		}
	}
	
	public void lock(Entity e) {
		xOffset = e.getPosition().getX() - handler.getWidth() / 2 + e.getWidth() / 2;
		yOffset = e.getPosition().getY() - handler.getHeight() / 2 + e.getHeight() / 2;
		checkBlankSpace();
	}
	
	public void move(float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}
	
	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}

}
