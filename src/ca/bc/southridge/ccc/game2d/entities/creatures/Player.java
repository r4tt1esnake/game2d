package ca.bc.southridge.ccc.game2d.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import ca.bc.southridge.ccc.game2d.Handler;
import ca.bc.southridge.ccc.game2d.gfx.Assets;
import ca.bc.southridge.ccc.game2d.gfx.animations.AnimManager_Player;
import ca.bc.southridge.ccc.game2d.gfx.animations.Animation;
import ca.bc.southridge.ccc.game2d.utils.Constants;
import ca.bc.southridge.ccc.game2d.utils.MathLib;

public class Player extends Creature {
	
	private Animation animDown, animUp, animRight, animLeft,
	animDownIdle, animUpIdle, animRightIdle, animLeftIdle;
	private AnimManager_Player am_P;

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Constants.CREATURE_WIDTH, Constants.CREATURE_HEIGHT);
		
		bounds.x = width / 3;
		bounds.y = height / 2;
		bounds.width = width / 3;
		bounds.height = height / 2;
		
		int[] animDownSeq = new int[]{0, 1, 0, 2};
		int[] animUpSeq = new int[]{0, 1, 0, 2};
		int[] animRightSeq = new int[]{0, 1, 0, 2};
		int[] animLeftSeq = new int[]{0, 1, 0, 2};
		
		double[] movAnimSeqFPS = new double[] {10, 4, 10, 4};
		
		animDown = new Animation(movAnimSeqFPS, Assets.player_down, animDownSeq);
		animUp = new Animation(movAnimSeqFPS, Assets.player_up, animUpSeq);
		animRight = new Animation(movAnimSeqFPS, Assets.player_right, animRightSeq);
		animLeft = new Animation(movAnimSeqFPS, Assets.player_left, animLeftSeq);
		
		animDownIdle = new Animation(1, Assets.player_down_idle);
		animUpIdle = new Animation(1, Assets.player_up_idle);
		animRightIdle = new Animation(1, Assets.player_right_idle);
		animLeftIdle = new Animation(1, Assets.player_left_idle);
		
		am_P = new AnimManager_Player(this, animDownIdle);
		
		am_P.setIdleUp(animUpIdle);
		am_P.setIdleDown(animDownIdle);
		am_P.setIdleRight(animRightIdle);
		am_P.setIdleLeft(animLeftIdle);
		
		am_P.setMovUp(animUp);
		am_P.setMovDown(animDown);
		am_P.setMovRight(animRight);
		am_P.setMovLeft(animLeft);
	}

	@Override
	public void tick() {
		am_P.tick();
		
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
		g.drawImage(am_P.getCurrentFrame(), (int) (position.getX() - handler.getGameCamera().getxOffset()), (int) (position.getY() - handler.getGameCamera().getyOffset()), /* image sizing */ width, height, null);
		super.render(g);
	}

}
