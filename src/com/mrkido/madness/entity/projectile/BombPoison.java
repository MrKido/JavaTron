package com.mrkido.madness.entity.projectile;

import com.mrkido.madness.graphics.Screen;
import com.mrkido.madness.graphics.Sprite;

public class BombPoison extends Projectile{

	public static final int ROF = 30; //Time between projectiles
	
	public BombPoison(int x, int y, double dir) {
		super(x, y, dir);
		range = 400;
		speed = 4;
		damage = 5;
		spr = Sprite.Bomb_Poison_0;
		nX = speed* Math.cos(angle);
		nY = speed*Math.sin(angle);
	}
	
	public void tick(){
		if(level.collision(x, y, nX, nY, 64)) explode();
		move();
	}
	
	protected void move(){
		x += nX;
		y += nY;
		if(distance()>range) explode();
	}
	
	private double distance() {
		double dist = 0;
		dist = Math.sqrt(Math.abs((xOrg - x) * (xOrg - x) + (yOrg - y) * (yOrg - y)));
		return dist;
	}

	public void render(Screen scr){
		scr.renderEntity((int)x, (int)y, spr);
	}

}
