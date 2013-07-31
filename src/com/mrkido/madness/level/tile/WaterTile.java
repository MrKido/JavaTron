package com.mrkido.madness.level.tile;

import com.mrkido.madness.graphics.Screen;
import com.mrkido.madness.graphics.Sprite;

public class WaterTile extends Tile{
	
	private int anim = 0;
	
	public WaterTile(Sprite sprite0) {
		super(sprite0);
	}
	
	public void render(int x, int y, Screen scr){
		if(anim <= 7)scr.renderTile(x * 32, y * 32, Sprite.water0);
		if(anim <= 14 && anim > 7)scr.renderTile(x * 32, y * 32, Sprite.water1);
		if(anim <= 21 && anim > 14)scr.renderTile(x * 32, y * 32, Sprite.water2);
	}

	public void tick(){
		anim++;
		if(anim >= 21) anim = 0;
		System.out.println(anim);
	}
	
}
