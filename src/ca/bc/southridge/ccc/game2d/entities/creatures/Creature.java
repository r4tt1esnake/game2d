package ca.bc.southridge.ccc.game2d.entities.creatures;

import ca.bc.southridge.ccc.game2d.entities.Entity;

public abstract class Creature extends Entity {
	
	protected double health;

	public Creature(float x, float y) {
		super(x, y);
		health = 10;
	}

}
