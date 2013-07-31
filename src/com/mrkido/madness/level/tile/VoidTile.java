package com.mrkido.madness.level.tile;

import com.mrkido.madness.graphics.Screen;
import com.mrkido.madness.graphics.Sprite;

public class VoidTile extends Tile {

	public VoidTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen scr){
		scr.renderTile(x * 32, y * 32, this.sprite);
	}
	
	public boolean solid(){
		return true;
	}

}
