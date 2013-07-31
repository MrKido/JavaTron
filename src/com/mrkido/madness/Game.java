package com.mrkido.madness;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;

import com.mrkido.ThreeD.render.Render3D;
import com.mrkido.madness.entity.mob.Player;
import com.mrkido.madness.graphics.Screen;
import com.mrkido.madness.graphics.Sprite;
import com.mrkido.madness.input.Keyboard;
import com.mrkido.madness.input.Mouse;
import com.mrkido.madness.level.Level;
import com.mrkido.madness.level.RandomLevel;
import com.mrkido.madness.level.StartLevel;
import com.mrkido.madness.level.TileCoordinate;
import com.mrkido.madness.level.tile.Tile;

public class Game extends Canvas implements Runnable{

	
	private static final long serialVersionUID = 1L;
	//Window Resolution
	public static int width = 800;
	public static int height = width / 16 * 9;
	public static String title = "The God of Devil";
	
	//Is the game running at all times
	private boolean isRunning = false;
	
	//Objects
	private JFrame window;
	private Screen screen;
	private Thread mainT;
	private Keyboard keyinput;
	private Level level;
	private Player player;
	private Render3D r3d;
	private Tile tilec;
	
	//Pixels/Image
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	private enum STATE{
		Main_MENU,
		GAME,
		GAME3D
	}
	private STATE state = STATE.GAME;
	
	//Main method
	public static void main(String[] args){
		Game game = new Game();
		
		game.window.setResizable(false);
		game.window.setTitle(Game.title);
		game.window.add(game);
		game.window.pack();
		game.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.window.setVisible(true);
		
		game.start();
	}
	
	//Window
	public Game(){
		Dimension size = new Dimension(width, height);
		setPreferredSize(size);
		TileCoordinate player1_startlevel_spawn = new TileCoordinate(15, 5, 32);
		level = level.PoolLevel;
		screen = new Screen(width, height);
		keyinput = new Keyboard();
		player = new Player(player1_startlevel_spawn.x(), player1_startlevel_spawn.y(), keyinput);
		player.init(level);
		window = new JFrame();
		r3d = new Render3D(width, height, keyinput);
		tilec = new Tile();
		Mouse mouse = new Mouse();
		addKeyListener(keyinput);
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
	}
	
	//Start Main Thread
	public synchronized void start(){
		isRunning = true;
		mainT = new Thread(this, "MadnessGameMain");
		mainT.start();
	}
	
	//Stop Main Thread
	public synchronized void stop(){
			isRunning= false;
		try {
			mainT.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//Run method
	public void run() {
		long startTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int fps = 0;
		int ticks = 0;
		requestFocus();
		while(isRunning){
			long now = System.nanoTime();
			delta += (now - startTime) / ns;
			startTime = now;
			while(delta >= 1){
				tick();
				ticks++;
				delta--;
			}
			render();
			fps++;
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS:" + fps + " Ticks:" + ticks);
				ticks = 0;
				fps = 0;
			}
		}
		stop();
	}
	
	public void tick(){
		if(state == STATE.GAME){
		keyinput.tick();
		player.tick();
		level.tick();
		tilec.tick();
		}
		if(state == STATE.GAME3D){
			r3d.tick();
			keyinput.tick3D();
		}
	}
	
	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if (bs == null){
			createBufferStrategy(3);
			return;
		}
		
		screen.clear();
		Graphics g = bs.getDrawGraphics();
		int xScr = player.x - screen.getWidth() / 2;
		int yScr = player.y - screen.getHeight() / 2;
		if(state == STATE.GAME){
			level.render(xScr, yScr, screen);
			player.render(screen);
		}
		if(state == STATE.GAME3D){
			r3d.fog(screen);
			r3d.fc(screen);
		}
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = screen.pixels[i];
		}
		
		
				window.setTitle(title);
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		if(state == STATE.Main_MENU){
			g.setColor(Color.BLUE);
			g.fillRect(screen.getWidth()/2 - 35, 150, 200, 80);
			Font title = new Font("Ariel", Font.PLAIN, 75);
			g.setFont(title);
			g.setColor(Color.white);
			g.drawString("The God of Devil", screen.getWidth()/4 - 10, 77);
		}
		g.setFont(new Font("Ariel", 0, 15));
		g.setColor(Color.WHITE);
		g.drawString("X: " + player.x + "  |  Y:"+player.y, 10, 20);
		g.drawString("Mouse X: " + Mouse.getX() + "  |  Mouse Y:"+Mouse.getY(), 10, 35);
		g.drawString("Button:", 10, 50);
		if(Mouse.getButton() != -1){
		g.drawString(""+Mouse.getButton(), 57, 50);
		}else{
			g.drawString("Null", 57, 50);
		}
		g.dispose();
		bs.show();
	}
	
}
