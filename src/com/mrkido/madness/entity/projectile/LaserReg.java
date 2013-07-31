package com.mrkido.madness.entity.projectile;

import com.mrkido.madness.graphics.Screen;
import com.mrkido.madness.graphics.Sprite;

public class LaserReg extends Projectile{
	
	public static final int ROF = 30; //Time between projectiles
	
	public LaserReg(int x, int y, double dir) {
		super(x, y, dir);
		range = 200;
		speed = 15;
		damage = 5;
		System.out.println(dir);
		if(dir >= -0.07 && dir <=1) spr = Sprite.LaserReg_h;
		else if(dir >= 2.8 && dir <= 4)spr = Sprite.LaserReg_h;
		if(dir >= -1.4 && dir <=-0.07) spr = Sprite.LaserReg_hv;
		if(dir >= 2 && dir <= 3) spr = Sprite.LaserReg_hv;
		if(dir >= 0.2 && dir <= 1.5) spr = Sprite.LaserReg_vh;
		else spr = Sprite.LaserReg_v;
		nX = speed* Math.cos(angle);
		nY = speed*Math.sin(angle);
	}
	
	public void tick(){
		move();
	}
	
	protected void move(){
		x += nX;
		y += nY;
	}
	
	public void render(Screen scr){
		scr.renderEntity((int)x, (int)y, spr);
	}

}
