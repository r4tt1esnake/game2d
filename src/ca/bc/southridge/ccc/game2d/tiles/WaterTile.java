package ca.bc.southridge.ccc.game2d.tiles;

import ca.bc.southridge.ccc.game2d.gfx.Assets;

public class WaterTile extends Tile {
	
	public WaterTile(int id) {
		super(Assets.water, id);
	}
	
	@Override
	public boolean isWalkable() {
		return false;
	}

}
