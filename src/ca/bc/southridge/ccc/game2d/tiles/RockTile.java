package ca.bc.southridge.ccc.game2d.tiles;

import ca.bc.southridge.ccc.game2d.gfx.Assets;

public class RockTile extends Tile {
	
	public RockTile(int id) {
		super(Assets.icon, id);
	}
	
	@Override
	public boolean isWalkable() {
		return false;
	}

}
