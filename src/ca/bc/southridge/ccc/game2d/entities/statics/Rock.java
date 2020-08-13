package ca.bc.southridge.ccc.game2d.entities.statics;

import java.awt.Graphics;

import ca.bc.southridge.ccc.game2d.Handler;
import ca.bc.southridge.ccc.game2d.gfx.Assets;
import ca.bc.southridge.ccc.game2d.utils.Constants;
import ca.bc.southridge.ccc.game2d.utils.datastructures.Scaler;

public class Rock extends StaticEntity{

	public Rock(Handler handler, Scaler s) {
		super(handler, s);
		
		width = (int) (s.getxScale() * Constants.ROCK_WIDTH);
		height = (int) (s.getyScale() * Constants.ROCK_HEIGHT);
		
		colBox.x = 0;
		colBox.y = (int) (1.7 * height / 3);
		colBox.width = width;
		colBox.height = height / 3;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.rock, (int) (position.getX() - handler.getGameCamera().getxOffset()),
				(int) (position.getY() - handler.getGameCamera().getyOffset()), width, height, null);
		super.render(g);
	}

}
