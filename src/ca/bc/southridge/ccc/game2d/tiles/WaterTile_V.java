package ca.bc.southridge.ccc.game2d.tiles;

import ca.bc.southridge.ccc.game2d.gfx.Assets;

public class WaterTile_V extends Tile {
	
	public WaterTile_V(int id) {
		super(Assets.water_v, id);
	}
	
	@Override
	public boolean isWalkable() {
		return false;
	}

}
