package ca.bc.southridge.ccc.game2d.tiles;

import ca.bc.southridge.ccc.game2d.gfx.Assets;

public class WaterTile_C extends Tile {
	
	public WaterTile_C(int id) {
		super(Assets.water_c, id);
	}
	
	@Override
	public boolean isWalkable() {
		return false;
	}

}
