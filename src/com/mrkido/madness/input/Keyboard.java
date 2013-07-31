package com.mrkido.madness.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Keyboard implements KeyListener{

	private boolean[] keys = new boolean[1150];
	public boolean up, down, left, right;
	public boolean foward, back, left3d, right3d, rotL, rotR, jump, down3d;
	
	public void tick(){
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		
		for(int i = 0; i < keys.length; i++){
			
		}
	}
	
	public void tick3D(){
		foward = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		back = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left3d = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right3d = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		rotL = keys[KeyEvent.VK_Q];
		rotR = keys[KeyEvent.VK_E];
		jump = keys[KeyEvent.VK_SPACE];
		down3d = keys[KeyEvent.VK_CONTROL];
	}
	
	public void keyPressed(KeyEvent e) {
	
		keys[e.getKeyCode()] = true;
	}


	public void keyReleased(KeyEvent e) {
		
		keys[e.getKeyCode()] = false;
	}


	public void keyTyped(KeyEvent e) {
		
		
	}

	
	

}
