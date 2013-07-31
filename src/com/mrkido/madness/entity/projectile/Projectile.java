package com.mrkido.madness.entity.projectile;

import com.mrkido.madness.entity.Entity;
import com.mrkido.madness.graphics.Sprite;

public abstract class Projectile extends Entity{
	
	final protected int xOrg, yOrg;
	protected double angle;
	protected double distance;
	protected Sprite spr;
	protected double nX, nY;
	protected double x, y;
	protected double speed, range, damage, effect;
	
	public Projectile(int x, int y, double dir){
		xOrg = x;
		yOrg = y;
		angle = dir;
		this.x = x;
		this.y = y;
	}
	
	protected void move(){
		
	}
	
}
