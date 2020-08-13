package ca.bc.southridge.ccc.game2d.entities.statics;

import java.awt.Graphics;

import ca.bc.southridge.ccc.game2d.Handler;
import ca.bc.southridge.ccc.game2d.entities.Entity;
import ca.bc.southridge.ccc.game2d.utils.datastructures.Scaler;

public abstract class StaticEntity extends Entity {
	
	public StaticEntity(Handler handler, Scaler s) {
		super(handler, s);
	}
	
	public void render(Graphics g) {
		super.render(g);
	}

}
