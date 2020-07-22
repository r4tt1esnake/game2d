package ca.bc.southridge.ccc.game2d.utils;

public class MathLib {
	
	public static double getHypotenuse(double a, double b) {
		return Math.sqrt(a * a + b * b);
	}
	
	public static enum Direction {
		N,
		NE,
		E,
		SE,
		S,
		SW,
		W,
		NW
	}

}
