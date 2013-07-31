package com.mrkido.madness.level;

import java.util.ArrayList;
import java.util.List;

import com.mrkido.madness.entity.Entity;
import com.mrkido.madness.entity.projectile.Projectile;
import com.mrkido.madness.graphics.Screen;
import com.mrkido.madness.level.tile.Tile;

public class Level {

	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;
	
	public static final Level StartLevel = new StartLevel("/maps/StartMap.png");
	public static final Level PoolLevel = new StartLevel("/maps/Pool.png");
	protected List<Entity> entities = new ArrayList<Entity>();
	protected List<Projectile> projectiles = new ArrayList<Projectile>();
	
	public Level(int width, int height){
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		
		genLevel();
	}
	public Level(String path){
		loadLevel(path);
		genLevel();
	}


	protected void loadLevel(String path) {
		
		
	}
	
	protected void genLevel() {
		
		
	}
	
	public void tick(){
		for(int i = 0; i < entities.size(); i++){
		entities.get(i).tick();
		}
		for(int i = 0; i < projectiles.size(); i++){
			projectiles.get(i).tick();
			}
	}
	
	private void time(){
		
	}
	
	public boolean collision(double x, double y , double xp, double yp, double size){
		boolean solid = false;
		for(int c = 0; c < 4; c++){
			double xt = ((x + xp) + c % 2 * size/2)/32;
			double yt = ((y + yp) + c / 2 * size/3+7)/32;
			if(getTile((int)xt, (int)yt).solid()) solid = true;
		}
		return solid;
	}
	
	public void add(Entity e){
		entities.add(e);
	}
	public void add(Projectile p){
		p.init(this);
		projectiles.add(p);
	}
	
	public List<Projectile> getProjectile(){
		return projectiles;
	}
	
	public void render(int xScr, int yScr,  Screen scr){
		int x0, x1, y0, y1;
		scr.setOff(xScr, yScr);
		x0 = (xScr - 32) / 32;
		x1 = (xScr + scr.getWidth() + 32) / 32;
		y0 = (yScr -32) / 32;
		y1 = (yScr + scr.getHeight() + 32) / 32;
		
		for(int y = y0; y <= y1; y++){
			for(int x = x0; x <= x1; x++){
				getTile(x, y).render(x, y, scr);
			}
		}
		for(int i = 0; i < entities.size(); i++){
			entities.get(i).render(scr);
			}
		for(int i = 0; i < projectiles.size(); i++){
			projectiles.get(i).render(scr);
			}
		
	}
	
	// Grass = 00FF00
	//G_R_Flower = BABA00
	//G_V_Flower = FF00FF
	//G_B_Flower = 0000FF
	
	//Void = 000000
	//Brick = FF0000
	//Planks = FF9900
	
	public Tile getTile(int x, int y){
			if(x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
			if(tiles[x+y*width] == 0xFF00FF00) return Tile.grass;
			if(tiles[x+y*width] == 0xFFBABA00) return Tile.grass_flower_red;
			if(tiles[x+y*width] == 0xFFFF00FF) return Tile.grass_flower_violet;
			if(tiles[x+y*width] == 0xFF0000FF) return Tile.grass_flower_blue;
			if(tiles[x+y*width] == 0xFF006EFF) return Tile.water;
			//
			if(tiles[x+y*width] == 0xFFFF0000) return Tile.bricks;
			if(tiles[x+y*width] == 0xFFFF9900) return Tile.planks;
			return Tile.voidTile;
	}

}
