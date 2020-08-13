package ca.bc.southridge.ccc.game2d.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import ca.bc.southridge.ccc.game2d.input.MousePacket.EventType;
import ca.bc.southridge.ccc.game2d.utils.datastructures.Vector;

public class MouseManager implements MouseListener, MouseMotionListener {
	
	private boolean lPressed, rPressed;
	private Vector pos;
	private MousePacket mp;
	
	public MouseManager() {
		pos = new Vector(0, 0);
		mp = new MousePacket(null, null);
	}
	
	public boolean leftPressed() {
		return lPressed;
	}
	
	public boolean rightPressed() {
		return rPressed;
	}
	
	public Vector getMousePos() {
		return pos;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		pos.setX(e.getX());
		pos.setY(e.getY());
		mp.setMouseEvent(e);
		mp.setEventType(EventType.MOVED);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1)
			lPressed = true;
		if(e.getButton() == MouseEvent.BUTTON3)
			rPressed = true;

		mp.setMouseEvent(e);
		mp.setEventType(EventType.PRESSED);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1)
			lPressed = false;
		if(e.getButton() == MouseEvent.BUTTON3)
			rPressed = false;
		
		mp.setMouseEvent(e);
		mp.setEventType(EventType.RELEASED);
	}
	
	public MousePacket poll() {
		return mp;
	}

}
