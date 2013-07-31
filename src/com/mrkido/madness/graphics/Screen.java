package com.mrkido.madness.graphics;

import java.util.Random;

import com.mrkido.madness.ThreeD.render.Render3D;
import com.mrkido.madness.level.tile.Tile;


public class Screen {

		private int width, height;
		public int[] pixels;
		public final int MAP_SIZE = 32;
		public final int MAP_SIZE_MASK = MAP_SIZE - 1;
		public int[] tiles = new int[MAP_SIZE*MAP_SIZE];
		private Random rand = new Random();
		
		public int xOff, yOff;
		
		public Screen(int width, int height){
			this.width = width;
			this.height = height;
			
			pixels = new int[width * height];
			
			for(int i = 0; i < MAP_SIZE*MAP_SIZE; i++){
				tiles[i] = rand.nextInt(0xffffff);
			}
		}
		
		public void clear(){
			for(int i = 0; i < pixels.length; i++){
				pixels[i] = 0;
			}
		}
		
		public void renderSprite(int xp, int yp, Sprite spr, boolean fixed){
			if(fixed){
				xp -= xOff;
				yp -= yOff;
			}
			for(int y = 0; y < spr.getSizeY(); y++){
				int ya = y + yp;
				for(int x = 0; x < spr.getSizeX(); x++){
					int xa = x + xp;
					if(xa < 0 || xa >= width || ya < 0 || ya >= height) continue;
					pixels[x+y*width] = spr.pixels[x+y*spr.getSizeX()];
				}
			}
		}
		
		public void renderTile(int xp, int yp, Sprite sprite){
			xp -= xOff;
			yp -= yOff;
				for(int y = 0; y < sprite.getSizeX(); y++){
					int ya = yp + y;
					for(int x = 0; x < sprite.getSizeX(); x++){
						int xa = xp + x;
						if(xa < -32 || xa >= width || ya < 0 || ya >= height) break;
						if(xa < 0) xa = 0;
						pixels[xa + ya * width] = sprite.pixels[x+y*sprite.getSizeX()];
					}
				}
		}
		public void renderEntity(int xp, int yp, Sprite spr){
			xp -= xOff;
			yp -= yOff;
				for(int y = 0; y < spr.getSizeX(); y++){
					int ya = yp + y;
					for(int x = 0; x < spr.getSizeX(); x++){
						int xa = xp + x;
						if(xa < -32 || xa >= width || ya < 0 || ya >= height) break;
						if(xa < 0) xa = 0;
						int col = spr.pixels[x+y*spr.getSizeX()];
						if(col != 0xFFFF00FF) pixels[xa + ya * width] = col;
					}
				}
		}
		
		
		public void setOff(int xo,int yo){
			xOff = xo;
			yOff = yo;
		}
		
		
		
		
		public int getWidth(){
			return width;
		}
		
		public int getHeight(){
			return height;
		}
		
		
}