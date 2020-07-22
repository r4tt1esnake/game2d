package ca.bc.southridge.ccc.game2d.tiles;

import ca.bc.southridge.ccc.game2d.gfx.Assets;

public class WaterTile_H_T_L extends Tile {
	
	public WaterTile_H_T_L(int id) {
		super(Assets.water_h_t_l, id);
	}
	
	@Override
	public boolean isWalkable() {
		return false;
	}

}
