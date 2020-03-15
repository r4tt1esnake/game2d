package ca.bc.southridge.ccc.game2d.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	
	private boolean[] keys;
	// Cardinal direction keys.
	public boolean up, down, left, right;
	
	public KeyManager() {
		// Each separate index corresponds to an ASCII value.
		keys = new boolean[256];
	}
	
	// Constantly check for user input.
	public void tick() {
		// We update the booleans based upon the array keys[].
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	

}
