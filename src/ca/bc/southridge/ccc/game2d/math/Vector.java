package ca.bc.southridge.ccc.game2d.math;

public class Vector {
	
	private float x, y;
	
	public Vector(float x, float y) {
		this.x = x; 
		this.y = y;
	}
	
	public void addX(float x) {
		this.x += x;
	}
	
	public void addY(float y) {
		this.y += y;
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

}
