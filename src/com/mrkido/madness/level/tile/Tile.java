package com.mrkido.madness.level.tile;

import com.mrkido.madness.graphics.Screen;
import com.mrkido.madness.graphics.Sprite;

public class Tile {

	
	//Void
	public static Tile voidTile = new VoidTile(Sprite.spr_void);
	//Outdoors
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile grass_flower_red = new GrassTile(Sprite.grass_flower_red);
	public static Tile grass_flower_violet = new GrassTile(Sprite.grass_flower_violet);
	public static Tile grass_flower_blue = new GrassTile(Sprite.grass_flower_blue);
	
	public static Tile water = new WaterTile(Sprite.water0);
	//Indoors
	public static Tile planks = new PlankTile(Sprite.planks);
	public static Tile bricks = new BrickTile(Sprite.brick);
	public int x,y;
	public Sprite sprite;
	
	public Tile(Sprite sprite){
		this.sprite = sprite;
	}
	
	public Tile(){
		
	}
	
	public void render(int x, int y, Screen scr){
		
	}
	
	public void tick(){
		water.tick();
	}
	
	public boolean solid(){
		return false;
	}
}
