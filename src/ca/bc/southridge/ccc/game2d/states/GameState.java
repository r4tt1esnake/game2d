package ca.bc.southridge.ccc.game2d.states;

import java.awt.Graphics;

import ca.bc.southridge.ccc.game2d.Game;
import ca.bc.southridge.ccc.game2d.gfx.Assets;

public class GameState extends State {
	
	int x = 0;
	
	public GameState() {
		
	}

	@Override
	public void tick() {
		x++;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.icon, x, 0, null);
		g.drawImage(Assets.icon, Game.WIDTH - x, 0, null);
	}

}
