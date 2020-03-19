package ca.bc.southridge.ccc.game2d.utils;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

public class ImageLib {
	
	public static BufferedImage deepCopy(BufferedImage bi) {
	    ColorModel cm = bi.getColorModel();
	    boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
	    WritableRaster raster = bi.copyData(bi.getRaster().createCompatibleWritableRaster());
	    return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
	}
	
	public static void rotate(BufferedImage bi, double deg) {
		final double rads = Math.toRadians(deg);
		final double sin = Math.abs(Math.sin(rads));
		final double cos = Math.abs(Math.cos(rads));
		final int w = (int) Math.floor(bi.getWidth() * cos + bi.getHeight() * sin);
		final int h = (int) Math.floor(bi.getHeight() * cos + bi.getWidth() * sin);
		final BufferedImage rotatedImage = new BufferedImage(w, h, bi.getType());
		final AffineTransform at = new AffineTransform();
		at.translate(w / 2, h / 2);
		at.rotate(rads, 0, 0);
		at.translate(-bi.getWidth() / 2, -bi.getHeight() / 2);
		final AffineTransformOp rotateOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
		rotateOp.filter(bi, rotatedImage);
	}

}
