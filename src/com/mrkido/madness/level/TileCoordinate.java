package com.mrkido.madness.level;

public class TileCoordinate {
	
	int x, y;
	int[] coordinates = new int[2];
	
	public TileCoordinate(int xpos, int ypos, int size){
		x = xpos * size;
		y = ypos * size;	
	}
	
	public int x(){
		return x;
	}
	
	public int y(){
		return y;
	}
	
	public int[] coordinates(){
		coordinates[0] = x;
		coordinates[1] = y;
		return coordinates;
	}

}
