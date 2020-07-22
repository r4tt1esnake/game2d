package ca.bc.southridge.ccc.game2d.tiles;

import ca.bc.southridge.ccc.game2d.gfx.Assets;

public class WaterTile_H extends Tile {
	
	public WaterTile_H(int id) {
		super(Assets.water_h, id);
	}
	
	@Override
	public boolean isWalkable() {
		return false;
	}

}
