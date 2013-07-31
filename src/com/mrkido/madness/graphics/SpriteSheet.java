package com.mrkido.madness.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpriteSheet {

		private String location;
		public final int SIZE1;
		public final int SIZE2;
		public int[] pixels;
		
		public static SpriteSheet blocks = new SpriteSheet("/textures/Tiles/blocks.png", 512, 512);
		public static SpriteSheet Player1 = new SpriteSheet("/textures/Mobs/Player1.png", 96, 128);
		public static SpriteSheet BulletGoldReg = new SpriteSheet("/textures/Projectiles/BulletGoldReg.png", 128, 128);
		public static SpriteSheet LaserReg = new SpriteSheet("/textures/Projectiles/LaserReg.png", 64, 64);
		public static SpriteSheet Bombs = new SpriteSheet("/textures/Projectiles/Bombs.png", 64, 64);

		
		public SpriteSheet(String p, int s1, int s2){
			location = p;
			SIZE1 = s1;
			SIZE2 = s2;
			pixels = new int[SIZE1 * SIZE2];
			load();
		}
		
		
		
		
		private void load(){
			try {
				BufferedImage img = ImageIO.read(SpriteSheet.class.getResource(location));
				int w = img.getWidth();
				int h = img.getHeight();
				img.getRGB(0, 0, w, h, pixels, 0, w);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
