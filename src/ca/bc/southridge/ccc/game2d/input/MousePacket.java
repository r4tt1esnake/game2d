package ca.bc.southridge.ccc.game2d.input;

import java.awt.event.MouseEvent;

public class MousePacket {
	
	public static enum EventType {
		MOVED,
		RELEASED,
		PRESSED
	}
	
	private MouseEvent e;

	private EventType t;
	
	public MousePacket(MouseEvent e, EventType t) {
		this.e = e;
		this.t = t;
	}
	
	public MouseEvent getMouseEvent() {
		return e;
	}

	public EventType getEventType() {
		return t;
	}
	
	public void setMouseEvent(MouseEvent e) {
		this.e = e;
	}
	
	public void setEventType(EventType t) {
		this.t = t;
	}

}
