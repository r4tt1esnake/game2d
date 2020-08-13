package ca.bc.southridge.ccc.game2d;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import ca.bc.southridge.ccc.game2d.display.Display;
import ca.bc.southridge.ccc.game2d.gfx.Assets;
import ca.bc.southridge.ccc.game2d.gfx.GameCamera;
import ca.bc.southridge.ccc.game2d.input.KeyManager;
import ca.bc.southridge.ccc.game2d.input.MouseManager;
import ca.bc.southridge.ccc.game2d.states.GameState;
import ca.bc.southridge.ccc.game2d.states.MenuState;
import ca.bc.southridge.ccc.game2d.states.State;
import ca.bc.southridge.ccc.game2d.utils.Constants;

public class Game implements Runnable {
	
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
	private MouseManager mouseManager;
	
	// Camera
	private GameCamera gameCamera;
	
	// Handler
	private Handler handler;
	
	public Game() {
		running = false;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}
	
	private void init() {
		Assets.init();
		display = new Display(Constants.WINDOW_TITLE + " - Southridge CCC", Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		display.getFrame().addKeyListener(keyManager);
		// Added to both to reduce glitches
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
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
			display.getCanvas().createBufferStrategy(2);
			return;
		}
		g = bs.getDrawGraphics();
		
		// Clears the screen.
		g.setColor(new Color(0, 0, 0));
		g.fillRect(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		
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
		
		// FPS limiter
		double timePerTick = 1000000000 / Constants.GAME_FPS;
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
				if(Constants.OUTPUT_FPS)
					System.out.println("Ticks and frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
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
	
	
	public KeyManager getKeyManager() {
		return keyManager;
	}

	public MouseManager getMouseManager() {
		return mouseManager;
	}
	
	public GameCamera getGameCamera() {
		return gameCamera;
	}
	
	public State getGameState() {
		return gameState;
	}

	public void setGameState(State gameState) {
		this.gameState = gameState;
	}

	public State getMenuState() {
		return menuState;
	}

	public void setMenuState(State menuState) {
		this.menuState = menuState;
	}

	// Deprecated
	public Graphics getGraphics() {
		return g;
	}

}
