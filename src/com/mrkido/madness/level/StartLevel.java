package com.mrkido.madness.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;

import com.mrkido.madness.level.tile.Tile;

public class StartLevel extends Level{


	
	public StartLevel(String path) {
		super(path);
	}
	
	
	protected void loadLevel(String path){
		try{

			BufferedImage img = ImageIO.read(StartLevel.class.getResource(path));
			int w = width = img.getWidth();
			int h = height =img.getHeight();
			tiles = new int[w * h];
			img.getRGB(0, 0, w, h, tiles, 0, w);
		} catch (IOException e) {
			System.out.println("Error-001... Can't load Level...");
			e.printStackTrace();
		}
	}
	
	// Grass = 00FF00
	//G_R_Flower = BABA00
	//G_V_Flower = FF00FF
	//G_B_Flower = 0000FF
	
	//Void = 000000
	//Brick = FF0000
	//Planks = FF9900
	protected void genLevel(){
			System.out.println("Tiles:" + tiles[0]);
		}
	}

