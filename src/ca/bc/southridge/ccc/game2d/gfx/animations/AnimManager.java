package ca.bc.southridge.ccc.game2d.gfx.animations;

import java.awt.image.BufferedImage;

public abstract class AnimManager {
	
	protected Animation active;
	
	public AnimManager(Animation a) { 
		active = a;
	}
	
	public abstract BufferedImage getCurrentFrame();
	
	public void tick() {
		active.tick();
	}
	
	public Animation getActive() {
		return active;
	}
	
	public void setActive(Animation a) {
		active = a;
	}

}
