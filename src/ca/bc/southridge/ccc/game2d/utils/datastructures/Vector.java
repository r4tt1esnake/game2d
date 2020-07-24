package ca.bc.southridge.ccc.game2d.utils.datastructures;

import ca.bc.southridge.ccc.game2d.utils.MathLib;

public class Vector {
	
	private float x, y;
	private MathLib.Direction persistDir;
	
	public Vector(float x, float y) {
		this.x = x; 
		this.y = y;
		persistDir = MathLib.Direction.S;
		persistDir = getDir();
	}
	
	public void addX(float x) {
		this.x += x;
		persistDir = getDir();
	}
	
	public void addY(float y) {
		this.y += y;
		persistDir = getDir();
	}
	
	public void zero() {
		x = 0;
		y = 0;
	}
	
	public void normalize(float normal) {
		float scale = (float) (MathLib.getHypotenuse(x, y) / normal);
		if(scale == 0) {
			return;
		} else {
			x = x / scale;
			y = y / scale;
		}
	}
	
	public float getX() {
		return x;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public MathLib.Direction getDir() {
		if(x > 0) {
			if(y > 0) 
				return MathLib.Direction.SE;
			else if(y < 0)
				return MathLib.Direction.NE;
			else
				return MathLib.Direction.E;
		} else if (x < 0) {
			if(y > 0) 
				return MathLib.Direction.SW;
			else if(y < 0)
				return MathLib.Direction.NW;
			else
				return MathLib.Direction.W;
		} else {
			if(y > 0)
				return MathLib.Direction.S;
			else if(y < 0)
				return MathLib.Direction.N;
			else
				return persistDir;
		}
	}
	
	public boolean isZero() {
		return (x == 0 && y == 0);
	}

}
