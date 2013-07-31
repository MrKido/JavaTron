package com.mrkido.madness.entity.mob;

import com.mrkido.madness.Game;
import com.mrkido.madness.entity.projectile.BombPoison;
import com.mrkido.madness.entity.projectile.Projectile;
import com.mrkido.madness.graphics.Screen;
import com.mrkido.madness.graphics.Sprite;
import com.mrkido.madness.input.Keyboard;
import com.mrkido.madness.input.Mouse;

public class Player extends Mob{
	
	
	private Keyboard input;
	private Sprite sprite;
	private int anim;
	private boolean walking;
	Projectile p;
	private int rof = 0;
	public Player(Keyboard inp){
		input = inp;
		sprite = sprite.player1_f_s;
	}
	
	public Player(int x, int y, Keyboard inp){
		this.x = x;
		this.y = y;
		input = inp;	
		sprite = Sprite.player1_f_s;
		rof = BombPoison.ROF;
	}
	
	public void tick(){
		if(rof >0) rof--;
		int xa = 0, ya = 0;
		if(anim >= 7500) anim = 0;
		anim++;
		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right) xa++;
		if (xa != 0 || ya != 0){
			walking = true;
			move(xa, ya);
		}else{
			walking = false;
		}
		clear();
		shooting();
	}
		
	private void clear() {
		for(int i =0; i < level.getProjectile().size(); i++){
			Projectile p = level.getProjectile().get(i);
			if(p.isRemoved()) level.getProjectile().remove(i);
		}
	}

	private void shooting() {
		if(Mouse.getButton() == 1 && rof <= 0){
			double dx = Mouse.getX() - Game.width /2;
			double dy = Mouse.getY() - Game.height /2;
			double dirP = Math.atan2(dy, dx);
			shoot(x, y, dirP);
			rof = BombPoison.ROF;
		}
	}

	public void render(Screen scr){
		if (dir == 2) {
			sprite = Sprite.player1_f_s;
			if (walking){
				if (anim % 20 > 10){
					sprite = Sprite.player1_f_m0;
				}else{
					sprite = Sprite.player1_f_m1;
				}
			}
		}
		if (dir == 0) {
			sprite = Sprite.player1_b_s;
			if (walking){
				if (anim % 20 > 10){
					sprite = Sprite.player1_b_m0;
				}else{
					sprite = Sprite.player1_b_m1;
				}
			}
			}
		if (dir == 3) {
			sprite = Sprite.player1_l_s;
			if (walking){
				if (anim % 20 > 10){
					sprite = Sprite.player1_l_m0;
				}else{
					sprite = Sprite.player1_l_m1;
				}
			}
		}
		if (dir == 1) {
			sprite = Sprite.player1_r_s;
			if (walking){
				if (anim % 20 > 10){
					sprite = Sprite.player1_r_m0;
				}else{
					sprite = Sprite.player1_r_m1;
				}
			}
		}
		scr.renderEntity(x, y, sprite);
	}
	
}
