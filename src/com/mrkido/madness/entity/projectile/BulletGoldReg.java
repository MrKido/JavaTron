package com.mrkido.madness.entity.projectile;

import com.mrkido.madness.graphics.Screen;
import com.mrkido.madness.graphics.Sprite;

public class BulletGoldReg extends Projectile{

	public static final int ROF = 30; //Time between projectiles
	
	public BulletGoldReg(int x, int y, double dir) {
		super(x, y, dir);
		range = 200;
		speed = 4;
		damage = 5;
		spr = Sprite.BulletReg_u;
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
