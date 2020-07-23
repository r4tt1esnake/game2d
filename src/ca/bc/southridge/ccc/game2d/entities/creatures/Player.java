package ca.bc.southridge.ccc.game2d.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import ca.bc.southridge.ccc.game2d.Handler;
import ca.bc.southridge.ccc.game2d.gfx.Animation;
import ca.bc.southridge.ccc.game2d.gfx.Assets;
import ca.bc.southridge.ccc.game2d.utils.Constants;
import ca.bc.southridge.ccc.game2d.utils.MathLib;

public class Player extends Creature {
	
	private Animation animDown, animUp, animRight, animLeft,
	animDownIdle, animUpIdle, animRightIdle, animLeftIdle;
	private int[] animDownSeq, animUpSeq, animRightSeq, animLeftSeq;
	private double[] movAnimSeqFPS;

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Constants.CREATURE_WIDTH, Constants.CREATURE_HEIGHT);
		
		bounds.x = width / 3;
		bounds.y = height / 2;
		bounds.width = width / 3;
		bounds.height = height / 2;
		
		animDownSeq = new int[]{0, 1, 0, 2};
		animUpSeq = new int[]{0, 1, 0, 2};
		animRightSeq = new int[]{0, 1, 0, 2};
		animLeftSeq = new int[]{0, 1, 0, 2};
		
		movAnimSeqFPS = new double[] {10, 4, 10, 4};
		
		animDown = new Animation(movAnimSeqFPS, Assets.player_down, animDownSeq);
		animUp = new Animation(movAnimSeqFPS, Assets.player_up, animUpSeq);
		animRight = new Animation(movAnimSeqFPS, Assets.player_right, animRightSeq);
		animLeft = new Animation(movAnimSeqFPS, Assets.player_left, animLeftSeq);
		
		animDownIdle = new Animation(1, Assets.player_down_idle);
		animUpIdle = new Animation(1, Assets.player_up_idle);
		animRightIdle = new Animation(1, Assets.player_right_idle);
		animLeftIdle = new Animation(1, Assets.player_left_idle);
	}

	@Override
	public void tick() {
		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();
		
		getInput();
		move();
		handler.getGameCamera().lock(this);
	}
	
	private void getInput() {
		movement.zero();
		if(handler.getKeyManager().up == true) {
			movement.addY(-speed);
		}
		if(handler.getKeyManager().down == true) {
			movement.addY(speed);
		}
		if(handler.getKeyManager().left == true) {
			movement.addX(-speed);
		}
		if(handler.getKeyManager().right == true) {
			movement.addX(speed);
		}
		movement.normalize(speed);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), /* image sizing */ width, height, null);
		super.render(g);
	}
	
	private BufferedImage getCurrentAnimationFrame() {
		if(movement.isZero()) {
			if(movement.getDir() == MathLib.Direction.W)
				return animLeftIdle.getCurrentFrame();
			else if(movement.getDir() == MathLib.Direction.E)
				return animRightIdle.getCurrentFrame();
			else if(movement.getDir() == MathLib.Direction.N || movement.getDir() == MathLib.Direction.NE || movement.getDir() == MathLib.Direction.NW)
				return animUpIdle.getCurrentFrame();
			else
				return animDownIdle.getCurrentFrame();
		}
		
		if(movement.getDir() == MathLib.Direction.W)
			return animLeft.getCurrentFrame();
		else if(movement.getDir() == MathLib.Direction.E)
			return animRight.getCurrentFrame();
		else if(movement.getDir() == MathLib.Direction.N || movement.getDir() == MathLib.Direction.NE || movement.getDir() == MathLib.Direction.NW)
			return animUp.getCurrentFrame();
		else
			return animDown.getCurrentFrame(); 
	}

}
