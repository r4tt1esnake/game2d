package ca.bc.southridge.ccc.game2d.entities.statics;

import java.awt.Graphics;

import ca.bc.southridge.ccc.game2d.Handler;
import ca.bc.southridge.ccc.game2d.gfx.Assets;
import ca.bc.southridge.ccc.game2d.utils.Constants;
import ca.bc.southridge.ccc.game2d.utils.datastructures.Scaler;

public class Tree extends StaticEntity{

	public Tree(Handler handler, Scaler s) {
		super(handler, s);
		
		width = (int) (s.getxScale() * Constants.TREE_WIDTH);
		height = (int) (s.getyScale() * Constants.TREE_HEIGHT);
		
		colBox.x = (int) (2 * width / 5);
		colBox.y = (int) (13.5 * height / 15);
		colBox.width = width / 5;
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
