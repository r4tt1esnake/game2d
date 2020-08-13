package ca.bc.southridge.ccc.game2d.tiles;

import ca.bc.southridge.ccc.game2d.gfx.Assets;

public class StoneBrickTIle extends Tile {
	
	public StoneBrickTIle(int id) {
		super(Assets.stone_bricks, id);
	}
	
	@Override
	public boolean isWalkable() {
		return false;
	}

}
