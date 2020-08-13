package ca.bc.southridge.ccc.game2d.states;

import java.awt.Graphics;

import ca.bc.southridge.ccc.game2d.Handler;
import ca.bc.southridge.ccc.game2d.gfx.Assets;
import ca.bc.southridge.ccc.game2d.ui.ClickListener;
import ca.bc.southridge.ccc.game2d.ui.UIImageButton;
import ca.bc.southridge.ccc.game2d.ui.UIManager;
import ca.bc.southridge.ccc.game2d.utils.Constants;
import ca.bc.southridge.ccc.game2d.utils.datastructures.Scaler;

public class MenuState extends State {
	
	private UIManager uMan;
	
	public MenuState(Handler handler) {
		super(handler);
		
		uMan = new UIManager(handler);
		
		uMan.addObject(new UIImageButton(new Scaler((Constants.WINDOW_WIDTH - Constants.UI_IMAGEBUTTON_WIDTH) / 2,
				(Constants.WINDOW_HEIGHT - Constants.UI_IMAGEBUTTON_HEIGHT) / 2, 1, 1),
				Assets.btn_resume, new ClickListener() {
			
			@Override
			public void onClick() {
				State.setState(handler.getGame().getGameState());
			}
			
		}));
	}

	@Override
	public void tick() {
		uMan.tick();
	}

	@Override
	public void render(Graphics g) {
		for(int i = 0; i < Constants.WINDOW_WIDTH / Constants.TILE_WIDTH; i++) {
			for(int j = 0; j < Constants.WINDOW_HEIGHT / Constants.TILE_HEIGHT; j++) {
				g.drawImage(Assets.stone_bricks, i * Constants.TILE_WIDTH, j * Constants.TILE_HEIGHT,
						Constants.TILE_WIDTH, Constants.TILE_HEIGHT, null);
			}
		}
		uMan.render(g);
	}

}
