package ca.bc.southridge.ccc.game2d.utils.datastructures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class QuadTree {
	
	private static final int MAX_OBJECTS = 1;
	private static final int MAX_LEVELS = 5;
	
	private int level;
	private List<Rectangle> objects;
	private Rectangle bounds;
	private QuadTree[] nodes;
	
	public QuadTree(int pLevel, Rectangle pBounds) {
		level = pLevel;
		objects = new ArrayList<Rectangle>();
		bounds = pBounds;
		nodes = new QuadTree[4];
	}
	
	public void clear() {
		objects.clear();
		
		for(int i = 0; i < nodes.length; i++) {
			if(nodes[i] != null) {
				nodes[i].clear();
				nodes[i] = null;
			}
		}
	}
	
	private void split() {
		int subWidth = (int) (bounds.getWidth() / 2);
		int subHeight = (int) (bounds.getHeight() / 2);
		int x = (int) bounds.getX();
		int y = (int) bounds.getY();
		
		// Follows standard Cartesian quadrants
		nodes[0] = new QuadTree(level + 1, new Rectangle(x + subWidth, y, subWidth, subHeight));
		nodes[1] = new QuadTree(level + 1, new Rectangle(x, y, subWidth, subHeight));
		nodes[2] = new QuadTree(level + 1, new Rectangle(x, y + subHeight, subWidth, subHeight));
		nodes[3] = new QuadTree(level + 1, new Rectangle(x + subWidth, y + subHeight, subWidth, subHeight));
	}
	
	private int getIndex(Rectangle pRect) {
		int index = -1;
		double xMid = bounds.getX() + bounds.getWidth() / 2;
		double yMid = bounds.getY() + bounds.getHeight() / 2;
		
		boolean topQuad = pRect.getY() < yMid && pRect.getY() + pRect.getHeight() < yMid;
		boolean bottomQuad = pRect.getY() > yMid && pRect.getY() + pRect.getHeight() > yMid;
		boolean rightQuad = pRect.getX() > xMid && pRect.getX() + pRect.getWidth() > xMid;
		boolean leftQuad = pRect.getX() < xMid && pRect.getX() + pRect.getWidth() < xMid;
		
		if(topQuad) {
			if(rightQuad)
				index = 0;
			else if(leftQuad)
				index = 1;
		}
		else if(bottomQuad) {
			if(leftQuad)
				index = 2;
			else if(rightQuad)
				index = 3;
		}
		return index;
	}
	
	public void insert(Rectangle pRect) {
		if(nodes[0] != null) {
			int index = getIndex(pRect);
			if(index != -1) {
				nodes[index].insert(pRect);
				return;
			}
		}
		
		objects.add(pRect);
		
		if(objects.size() > MAX_OBJECTS && level < MAX_LEVELS) {
			if(nodes[0] == null)
				split();
			int i = 0;
			while(i < objects.size()) {
				int index = getIndex(objects.get(i));
				if(index != -1)
					nodes[index].insert(objects.remove(i));
				else
					i++;
			}
		}
	}
	
	public List<Rectangle> retrive(List<Rectangle> retObjs, Rectangle pRect) {
		int index = getIndex(pRect);
		if(index != -1 && nodes[0] != null)
			nodes[index].retrive(retObjs, pRect);
		
		retObjs.addAll(objects);
		
		return retObjs;
	}
	
	public void render(Graphics g) {
		int subWidth = (int) (bounds.getWidth() / 2);
		int subHeight = (int) (bounds.getHeight() / 2);
		int x = (int) bounds.getX();
		int y = (int) bounds.getY();
		
		g.setColor(Color.blue);
		g.drawRect(x + subWidth, y, subWidth, subHeight);
		g.drawRect(x, y, subWidth, subHeight);
		g.drawRect(x, y + subHeight, subWidth, subHeight);
		g.drawRect(x + subWidth, y + subHeight, subWidth, subHeight);
		
		for(int i = 0; i < 4; i++) {
			if(nodes[i] != null) 
				nodes[i].render(g);
		}
	}

}
