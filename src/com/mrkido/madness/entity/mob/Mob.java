package com.mrkido.madness.entity.mob;

import java.util.ArrayList;
import java.util.List;

import com.mrkido.madness.entity.Entity;
import com.mrkido.madness.entity.projectile.BombPoison;
import com.mrkido.madness.entity.projectile.BulletGoldReg;
import com.mrkido.madness.entity.projectile.LaserReg;
import com.mrkido.madness.entity.projectile.Projectile;
import com.mrkido.madness.graphics.Sprite;

public abstract class Mob extends Entity{

	protected Sprite spr;
	protected int dir = 0;
	protected boolean moving = false;
	
	
	public void move(int xa, int ya){
		if(xa !=0 && ya!=0){
			move(xa, 0);
			move(0, ya);
			return;
		}
		if(xa > 0) dir = 1;
		if(xa < 0) dir = 3;
		if(ya > 0) dir = 2;
		if(ya < 0) dir = 0;
		
		if(!collision(xa, ya)){		
			x += xa;
			y += ya;
		}

	}
	
	protected void shoot(int x,int y ,double dir){
		//dir *= 180 / Math.PI;
		Projectile BulletGoldReg = new BulletGoldReg(x, y, dir);
		Projectile LaserReg = new LaserReg(x, y, dir);
		Projectile BombPoison = new BombPoison(x, y, dir);
		level.add(BombPoison);
	}
	
	public void tick(){
		
	}
	
	private boolean collision(int xp, int yp){
		boolean solid = false;
		for(int c = 0; c < 4; c++){
			int xt = ((x + xp) + c % 2 * 28+2)/32;
			int yt = ((y + yp) + c / 2 * 16+15)/32;
			if(level.getTile(xt, yt).solid()) solid = true;
		}
		return solid;
	}
	
	public void render(){
		
	}
}
