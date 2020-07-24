package ca.bc.southridge.ccc.game2d.gfx.animations;

import java.awt.image.BufferedImage;

import ca.bc.southridge.ccc.game2d.entities.dynamics.Player;
import ca.bc.southridge.ccc.game2d.utils.MathLib;
import ca.bc.southridge.ccc.game2d.utils.datastructures.Vector;

public class AnimManager_Player extends AnimManager {
	
	private Player p;
	
	private Animation movUp, movDown, movRight, movLeft,
	idleUp, idleDown, idleRight, idleLeft,
	melee;
	
	public AnimManager_Player(Player p, Animation a) {
		super(a);
		this.p = p;
	}
	
	public BufferedImage getCurrentFrame() {
		Vector movement = p.getMovement();
		
		if(movement.isZero()) {
			if(movement.getDir() == MathLib.Direction.W) {
				active = idleLeft;
				return idleLeft.getCurrentFrame();
			}
			else if(movement.getDir() == MathLib.Direction.E) {
				active = idleRight;
				return idleRight.getCurrentFrame();
			}
			else if(movement.getDir() == MathLib.Direction.N || movement.getDir() == MathLib.Direction.NE ||
					movement.getDir() == MathLib.Direction.NW) {
				active = idleUp;
				return idleUp.getCurrentFrame();
			}
			else {
				active = idleDown;
				return idleDown.getCurrentFrame();
			}
		}
		
		if(movement.getDir() == MathLib.Direction.W) {
			active = movLeft;
			return movLeft.getCurrentFrame();
		}
		else if(movement.getDir() == MathLib.Direction.E) {
			active = movRight;
			return movRight.getCurrentFrame();
		}
		else if(movement.getDir() == MathLib.Direction.N || movement.getDir() == MathLib.Direction.NE ||
				movement.getDir() == MathLib.Direction.NW) {
			active = movUp;
			return movUp.getCurrentFrame();
		}
		else {
			active = movDown;
			return movDown.getCurrentFrame(); 

		}
	}

	public void setMovUp(Animation movUp) {
		this.movUp = movUp;
	}

	public void setMovDown(Animation movDown) {
		this.movDown = movDown;
	}

	public void setMovRight(Animation movRight) {
		this.movRight = movRight;
	}

	public void setMovLeft(Animation movLeft) {
		this.movLeft = movLeft;
	}

	public void setIdleUp(Animation idleUp) {
		this.idleUp = idleUp;
	}

	public void setIdleDown(Animation idleDown) {
		this.idleDown = idleDown;
	}

	public void setIdleRight(Animation idleRight) {
		this.idleRight = idleRight;
	}

	public void setIdleLeft(Animation idleLeft) {
		this.idleLeft = idleLeft;
	}

	public void setMelee(Animation melee) {
		this.melee = melee;
	}

}
