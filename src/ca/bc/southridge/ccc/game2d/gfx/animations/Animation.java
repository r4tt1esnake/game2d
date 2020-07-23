package ca.bc.southridge.ccc.game2d.gfx.animations;

import java.awt.image.BufferedImage;

public class Animation {
	
	private int index, seqIndex, spIndex;
	private long lastTime, timer;
	private BufferedImage[] frames;
	
	// Provide an array with its elements the indices of frames in order to loop custom animations.
	private int[] sequence;
	// Individual FPS speed of each frame in the sequence
	private int[] speed;
	
	public Animation(double FPS, BufferedImage[] frames) {
		this.speed = new int[] {(int) (1000 / FPS)};
		this.frames = frames;
		sequence = new int[frames.length];
		for(int i = 0; i < frames.length; i++) {
			this.sequence[i] = i;
		}
		index = 0;
		seqIndex = 0;
		spIndex = 0;
		timer = 0;
		lastTime = System.currentTimeMillis();
	}
	
	public Animation(double FPS, BufferedImage[] frames, int[] sequence) {
		this.speed = new int[] {(int) (1000 / FPS)};
		this.frames = frames;
		this.sequence = sequence;
		index = 0;
		seqIndex = 0;
		timer = 0;
		lastTime = System.currentTimeMillis();
	}
	
	// This constructor allows you to provide a custom double array of FPS that each individual frame in a custom sequence should run at. 
	public Animation(double[] FPS, BufferedImage[] frames, int[] sequence) {
		this.speed = new int[FPS.length];
		for(int i = 0; i < speed.length; i++) {
			this.speed[i] = (int) (1000 / FPS[i]);
		}
		this.frames = frames;
		this.sequence = sequence;
		index = 0;
		seqIndex = 0;
		timer = 0;
		lastTime = System.currentTimeMillis();
	}
	
	public void tick() {
		if(frames.length == 1) return;
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(timer > speed[spIndex]) {
			seqIndex++;
			
			spIndex = seqIndex;
			if(spIndex >= speed.length)
				spIndex = 0;
			
			timer = 0;
			
			if(seqIndex >= sequence.length)
				seqIndex = 0;
			
			index = sequence[seqIndex];
		}
	}
	
	public BufferedImage getCurrentFrame() {
		return frames[index];
	}

}
