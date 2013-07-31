package com.mrkido.madness.entity;

import java.util.Random;

import com.mrkido.madness.graphics.Screen;
import com.mrkido.madness.level.Level;

public abstract class Entity {
	
	public int x = 0, y = 0;
	private boolean removed = false;
	protected Level level;
	protected final Random rand = new Random();
	
	public void tick(){
	}
	
	public void render(Screen scr){
		
	}
	
	public void remove(){
		removed = true;
	}
	public void explode(){
		removed = true;
	}
	public boolean isRemoved(){
		return removed;
	}
	public void init(Level lvl){
		level = lvl;
	}
}
