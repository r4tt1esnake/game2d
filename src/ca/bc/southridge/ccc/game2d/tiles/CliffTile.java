package ca.bc.southridge.ccc.game2d.tiles;

import ca.bc.southridge.ccc.game2d.gfx.Assets;

public class CliffTile extends Tile {
	
	public CliffTile(int id) {
		super(Assets.grass_pebble, id);
	}
	
	@Override
	public boolean isWalkable() {
		return false;
	}

}
