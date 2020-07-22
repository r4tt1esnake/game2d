package ca.bc.southridge.ccc.game2d.tiles;

import ca.bc.southridge.ccc.game2d.gfx.Assets;

public class WaterTile_V_T_U extends Tile {
	
	public WaterTile_V_T_U(int id) {
		super(Assets.water_v_t_u, id);
	}
	
	@Override
	public boolean isWalkable() {
		return false;
	}

}
