package ca.bc.southridge.ccc.game2d;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import ca.bc.southridge.ccc.game2d.display.Display;
import ca.bc.southridge.ccc.game2d.gfx.Assets;
import ca.bc.southridge.ccc.game2d.input.KeyManager;
import ca.bc.southridge.ccc.game2d.states.GameState;
import ca.bc.southridge.ccc.game2d.states.MenuState;
import ca.bc.southridge.ccc.game2d.states.State;

public class Game implements Runnable {
	
	public static final String TITLE = "game2D";
	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;
	public static final int FPS = 60;
	
	private Display display;
	
	private Thread thread;
	
	private boolean running;
	
	private BufferStrategy bs;
	private Graphics g;
	
	// States
	private State gameState;
	private State menuState;
	
	// Input
	private KeyManager keyManager;
	
	public Game() {
		running = false;
		keyManager = new KeyManager();
	}
	
	private void init() {
		Assets.init();
		display = new Display(TITLE + " - Southridge CCC", WIDTH, HEIGHT);
		display.getFrame().addKeyListener(keyManager);
		
		gameState = new GameState(this);
		menuState = new MenuState(this);
		State.setState(gameState);
	}
	
	// Update all variables here.
	private void tick() {
		keyManager.tick();
		
		// Errorcheck for null states.
		if(State.getState() != null)
			State.getState().tick();
		
	}
	
	// Do the rendering (drawing) here.
	private void render() {
		
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		// Clears the screen.
		g.setColor(new Color(255, 255, 255));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// Draw here!
		
		// Errorcheck for null states.
		if(State.getState() != null)
			State.getState().render(g);
		
		// End drawing.
		
		bs.show();
		g.dispose();
	}

	public void run() {
		init();
		
		// Fps limiter
		double timePerTick = 1000000000 / FPS;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1) {
				
				tick();
				render();
				
				ticks++;
				delta = 0; // Video shows as delta--, but I think this is better.
			}
			
			// Our FPS counter. We can implement a graphical one in the future!
			if(timer >= 1000000000) {
				System.out.println("Ticks and frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start(); // Calls the run() method!
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
