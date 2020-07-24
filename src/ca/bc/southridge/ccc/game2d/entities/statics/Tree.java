package ca.bc.southridge.ccc.game2d.entities.statics;

import java.awt.Graphics;

import ca.bc.southridge.ccc.game2d.Handler;
import ca.bc.southridge.ccc.game2d.gfx.Assets;
import ca.bc.southridge.ccc.game2d.utils.Constants;

public class Tree extends StaticEntity{

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Constants.TILE_WIDTH * 1, Constants.TILE_HEIGHT * 3);
		
		colBox.x = 0;
		colBox.y = 14 * height / 15;
		colBox.width = width;
		colBox.height = height / 15;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int) (position.getX() - handler.getGameCamera().getxOffset()),
				(int) (position.getY() - handler.getGameCamera().getyOffset()), width, height, null);
		super.render(g);
	}

}
