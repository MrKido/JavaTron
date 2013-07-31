package com.mrkido.madness.graphics;

import java.awt.Color;

public class Sprite {

	private final int SIZEX;
	private final int SIZEY;
	private int x,y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	
	//SPRITES!!!
	public static Sprite planks = new Sprite(32, 0, 0, SpriteSheet.blocks);
	public static Sprite spr_void = new Sprite(32, 1, 0, SpriteSheet.blocks);
	public static Sprite brick = new Sprite(32, 2, 0, SpriteSheet.blocks);
	public static Sprite grass = new Sprite(32, 0, 1, SpriteSheet.blocks);
	public static Sprite grass_flower_red = new Sprite(32, 1, 1, SpriteSheet.blocks);
	public static Sprite grass_flower_violet = new Sprite(32, 2, 1, SpriteSheet.blocks);
	public static Sprite grass_flower_blue = new Sprite(32, 3, 1, SpriteSheet.blocks);
	//Water
	public static Sprite water0 = new Sprite(32, 0, 5, SpriteSheet.blocks);
	public static Sprite water1 = new Sprite(32, 1, 5, SpriteSheet.blocks);
	public static Sprite water2 = new Sprite(32, 2, 5, SpriteSheet.blocks);
	public static Sprite water3 = new Sprite(32, 3, 5, SpriteSheet.blocks);
	
		//Entity
			//Projectiles
				//BulletReg
				public static Sprite BulletReg_u = new Sprite(32, 0, 0, SpriteSheet.BulletGoldReg);
				public static Sprite BulletReg_ur = new Sprite(32, 2, 0, SpriteSheet.BulletGoldReg);
				public static Sprite BulletReg_r = new Sprite(32, 1, 0, SpriteSheet.BulletGoldReg);
				public static Sprite BulletReg_dr = new Sprite(32, 3, 0, SpriteSheet.BulletGoldReg);
				public static Sprite BulletReg_d = new Sprite(32, 0, 1, SpriteSheet.BulletGoldReg);
				public static Sprite BulletReg_dl = new Sprite(32, 3, 1, SpriteSheet.BulletGoldReg);
				public static Sprite BulletReg_l = new Sprite(32, 1, 1, SpriteSheet.BulletGoldReg);
				public static Sprite BulletReg_ul = new Sprite(32, 2, 1, SpriteSheet.BulletGoldReg);
				//LaserReg
				public static Sprite LaserReg_h = new Sprite(32, 0, 0, SpriteSheet.LaserReg);
				public static Sprite LaserReg_v = new Sprite(32, 1, 0, SpriteSheet.LaserReg);
				public static Sprite LaserReg_hv = new Sprite(32, 0, 1, SpriteSheet.LaserReg);
				public static Sprite LaserReg_vh = new Sprite(32, 1, 1, SpriteSheet.LaserReg);
				//BombPoison
				public static Sprite Bomb_Poison_0 = new Sprite(32, 0, 0, SpriteSheet.Bombs);
				public static Sprite Bomb_Poison_1 = new Sprite(32, 1, 0, SpriteSheet.Bombs);

			//Mob
				//PLAYER1
				public static Sprite player1_f_s = new Sprite(32, 1, 0, SpriteSheet.Player1);
				public static Sprite player1_f_m0 = new Sprite(32, 0, 0, SpriteSheet.Player1);
				public static Sprite player1_f_m1 = new Sprite(32, 2, 0, SpriteSheet.Player1);
				//
				public static Sprite player1_l_s = new Sprite(32, 1, 1, SpriteSheet.Player1);
				public static Sprite player1_l_m0 = new Sprite(32, 0, 1, SpriteSheet.Player1);
				public static Sprite player1_l_m1 = new Sprite(32, 2, 1, SpriteSheet.Player1);
				//
				public static Sprite player1_r_s = new Sprite(32, 1, 2, SpriteSheet.Player1);
				public static Sprite player1_r_m0 = new Sprite(32, 0, 2, SpriteSheet.Player1);
				public static Sprite player1_r_m1 = new Sprite(32, 2, 2, SpriteSheet.Player1);
				//
				public static Sprite player1_b_s = new Sprite(32, 1, 3, SpriteSheet.Player1);
				public static Sprite player1_b_m0 = new Sprite(32, 0, 3, SpriteSheet.Player1);
				public static Sprite player1_b_m1 = new Sprite(32, 2, 3, SpriteSheet.Player1);
				//	
	public Sprite(int size, int xi, int yi, SpriteSheet sh){
		SIZEX = size;
		SIZEY = size;
		pixels = new int[SIZEX * SIZEY];
		x = xi * SIZEX;
		y = yi * SIZEY;
		sheet = sh;
		load();
	}
	
	private void load(){
		for(int y = 0; y < SIZEX; y++){
			for(int x = 0; x < SIZEY; x++){
				pixels[x+y*SIZEX] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE1];
			}
			
		}
		
		
	}
	//Get SIZE for another classes
	public int getSizeX(){
		return SIZEX;

		}
	public int getSizeY(){
		return SIZEY;

		}
	
	public Sprite(int size, int color){
		SIZEX = size;
		SIZEY = size;
		pixels = new int[SIZEX * SIZEY];
		setColor(color);
	}
	
	public Sprite(int sizex, int sizey, int color){
		SIZEX = sizex;
		SIZEY = sizey;
		pixels = new int[SIZEX * SIZEY];
		setColor(color);
	}

	private void setColor(int color) {
		for(int i = 0;i < SIZEX*SIZEY; i++){
			pixels[i] = color;
		}
	}

}
