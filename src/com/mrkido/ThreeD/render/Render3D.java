package com.mrkido.madness.ThreeD.render;

import java.awt.event.KeyEvent;

import com.mrkido.madness.Game;
import com.mrkido.madness.graphics.Screen;
import com.mrkido.madness.input.Keyboard;

public class Render3D extends Screen{
	
	public double xM, zM, xa, za, oRotation;
	public double[] zBuff;
	public double renderD = 5000;
	double anim = 0;
	double rotation;
	double cos;
	double sin;
	Keyboard keyboard;

	
	public Render3D(int width, int height, Keyboard inp) {
		super(width, height);
		zBuff = new double[width * height];
		keyboard = inp;
	}
	
	public void fc(Screen scr){
		for(int y = 0; y < getHeight(); y++){
			double yD = (y + -getHeight() / 2.0) / getHeight();
			//Floor
			double z = 15 / yD;
			//C
			if(yD<0)z = 15/-yD;
				for(int x = 0; x < getWidth(); x++){
					double xD = (x - getWidth() / 2.0) / getHeight();
					xD *= z;
					double xx = xD*cos+z*sin;
					double yy = z*cos-xD*sin;
					int xP = (int)(xx+xM);
					int yP = (int)(yy+zM);
					zBuff[x+y*getWidth()] = z;
					scr.pixels[x + y * getWidth()] = ((xP&15)*16) | ((yP&15)*16) << 8;
				}
			
		}
	}
	
	public void fog(Screen scr){
		for(int i = 0; i < zBuff.length; i++){
			int color = pixels[i];
			int brightness = (int) (renderD / (zBuff[i]));
			
			if(brightness < 0)brightness = 0;
			if(brightness < 255)brightness = 255;

			int r = (color << 16) & 0xFF;
			int g = (color << 8) & 0xFF;
			int b = (color) & 0xFF;
			
			r = r*brightness/255;
			g = g*brightness/255;
			b = b*brightness/255;
			
			scr.pixels[i] = r << 16 | g << 8 | b;
		}
	}
	
	public void tick(){
		cos = Math.cos(rotation);
		sin = Math.sin(rotation);
		
		double wSpeed = 1;
		double rSpeed = 0.0075;
		double jSpeed = 1;
		double xMove = 0;
		double zMove = 0;
		double yMove = 0;
		if(keyboard.foward)zMove+=wSpeed;
		if(keyboard.back)zMove-=wSpeed;
		if(keyboard.left3d)xMove-=wSpeed;
		if(keyboard.right3d)xMove+=wSpeed;
		if(keyboard.rotL)oRotation-=rSpeed;
		if(keyboard.rotR)oRotation+=rSpeed;
		xa+=(xMove*Math.cos(rotation)+zMove*Math.sin(rotation)) * wSpeed;
		za+=(zMove*Math.cos(rotation)-xMove*Math.sin(rotation)) * wSpeed;
		xM+=xa;
		zM+=za;
		xa*=0.1;
		za*=0.1;
		oRotation *= 0.8;
		rotation += oRotation;
	}
}
