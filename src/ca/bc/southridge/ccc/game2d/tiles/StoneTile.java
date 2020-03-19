package ca.bc.southridge.ccc.game2d.tiles;

import ca.bc.southridge.ccc.game2d.gfx.Assets;

public class StoneTile extends Tile {
	
	public StoneTile(int id) {
		super(Assets.stone, id);
	}
	
	@Override
	public boolean isWalkable() {
		return false;
	}

}
