package com.mrkido.madness.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener, MouseMotionListener{

	
	private static int mouseX = -1;
	private static int mouseY = -1;
	private static int mouseB = -1;
	
	public static int getX(){
		return mouseX;
	}
	public static int getY(){
		return mouseY;
	}
	public static int getButton(){
		return mouseB;
	}

	public void mouseDragged(MouseEvent m) {
		mouseX = m.getX();
		mouseY = m.getY();
	}


	public void mouseMoved(MouseEvent m) {
		mouseX = m.getX();
		mouseY = m.getY();
	}


	public void mouseClicked(MouseEvent m) {
	
	}


	public void mouseEntered(MouseEvent m) {

	}


	public void mouseExited(MouseEvent m) {

	}


	public void mousePressed(MouseEvent m) {
		mouseB = m.getButton();
	}


	public void mouseReleased(MouseEvent m) {
		mouseB = -1;
	}

	
	
}
