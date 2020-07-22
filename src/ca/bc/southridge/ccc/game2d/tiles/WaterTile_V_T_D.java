package ca.bc.southridge.ccc.game2d.tiles;

import ca.bc.southridge.ccc.game2d.gfx.Assets;

public class WaterTile_V_T_D extends Tile {
	
	public WaterTile_V_T_D(int id) {
		super(Assets.water_v_t_d, id);
	}
	
	@Override
	public boolean isWalkable() {
		return false;
	}

}
