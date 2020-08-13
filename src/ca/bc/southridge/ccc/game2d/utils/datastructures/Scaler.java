package ca.bc.southridge.ccc.game2d.utils.datastructures;

public class Scaler {
	
	private float x, y;
	private float xScale, yScale;
	
	public Scaler(float x, float y, float xScale, float yScale) {
		this.x = x;
		this.y = y;
		this.xScale = xScale;
		this.yScale = yScale;
	}
	
	public Scaler(float x, float y) {
		this.x = x;
		this.y = y;
		xScale = 1;
		yScale = 1;
	}
	
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getxScale() {
		return xScale;
	}

	public float getyScale() {
		return yScale;
	}

}
