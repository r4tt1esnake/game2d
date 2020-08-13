package ca.bc.southridge.ccc.game2d.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import ca.bc.southridge.ccc.game2d.utils.datastructures.Scaler;

public class UIImageButton extends UIObject {
	
	private BufferedImage[] images;
	private ClickListener clicker;

	public UIImageButton(Scaler s, BufferedImage[] images, ClickListener clicker) {
		super(s);
		this.images = images;
		this.clicker = clicker;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		if(hovering)
			g.drawImage(images[1], (int) x, (int) y, width, height, null);
		else
			g.drawImage(images[0], (int) x, (int) y, width, height, null);
	}

	@Override
	public void onClick() {
		// ClickListener influences behavior of click so that we don't have to waste classes
		// This way we can implement ClickListener objects on-the-fly
		clicker.onClick();
	}
	
	

}
