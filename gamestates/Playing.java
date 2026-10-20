package gamestates;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import main.Game;
import java.awt.image.BufferedImage;

import javax.swing.text.Position;

import gamestates.Gamestate;

import utilz.LoadSave;
import entities.Player;
import java.awt.Point;
import entities.*;
import java.awt.geom.Rectangle2D;

public class Playing  /*implements Statemethods*/ {

	private Player player;
	private Point playerSpawn;
	private int x = 500, y = 450;
	private int xLvlOffset;

	private int xPos, yPos;
    private BufferedImage playing_background;
    private Gamestate state;


	public static Rectangle2D pveHitbox;
	public static Rectangle2D pvpHitbox; 
	public static Rectangle2D seaLeftHitbox; 
	public static Rectangle2D seaRightHitbox; 
	public static Rectangle2D seaUpHitbox;


	private int XpveHitbox = 250, YpveHitbox = 150;
	private int	XpvpHitbox = 650,	YpvpHitbox = 150;
	private int	XseaLeftHitbox = 0,	YseaLeftHitbox = 0; 
	private int	XseaRightHitbox = 795, YseaRightHitbox = 0;
	private int	XseaUpHitbox = 205, YseaUpHitbox = 0;


	private int WIDTHpveHitbox = 150, HEIGHTpveHitbox = 100;
	private int	WIDTHpvpHitbox = 150,	HEIGHTpvpHitbox = 100;
	private int	WIDTHseaLeftHitbox = 205,	HEIGHTseaLeftHitbox = 640; 
	private int	WIDTHseaRightHitbox = 205, HEIGHTseaRightHitbox= 640;
	private int	WIDTHseaUpHitbox = 590, HEIGHTseaUpHitbox= 150; 



	public Playing() {
		
		loadImgs();
		initClasses();
		initPlayingHitbox();
	
	
	}

	private void initClasses() {
		player = new Player(200, 200, (int) (64 * Game.SCALE), (int) (40 * Game.SCALE), this);
		playerSpawn = new Point(x, y);
		player.setSpawn(playerSpawn);


	}

	public void update() {
		player.update();
		
	}




	protected void initPlayingHitbox() {
		pveHitbox = new Rectangle2D.Float(XpveHitbox, YpveHitbox, WIDTHpveHitbox, HEIGHTpveHitbox);
		pvpHitbox = new Rectangle2D.Float(XpvpHitbox, YpvpHitbox, WIDTHpvpHitbox, HEIGHTpvpHitbox);
		seaLeftHitbox = new Rectangle2D.Float(XseaLeftHitbox, YseaLeftHitbox, WIDTHseaLeftHitbox, HEIGHTseaLeftHitbox);
		seaRightHitbox = new Rectangle2D.Float(XseaRightHitbox, YseaRightHitbox, WIDTHseaRightHitbox, HEIGHTseaRightHitbox);
		seaUpHitbox = new Rectangle2D.Float(XseaUpHitbox, YseaUpHitbox, WIDTHseaUpHitbox, HEIGHTseaUpHitbox);
	}

	public void drawPlayingHitbox(Graphics g) {
		// For debugging the hitbox
		g.setColor(Color.PINK);
		g.drawRect(XpveHitbox, YpveHitbox, WIDTHpveHitbox, HEIGHTpveHitbox);
		g.drawRect(XpvpHitbox, YpvpHitbox, WIDTHpvpHitbox, HEIGHTpvpHitbox);
		g.drawRect(XseaLeftHitbox, YseaLeftHitbox, WIDTHseaLeftHitbox, HEIGHTseaLeftHitbox);
		g.drawRect(XseaRightHitbox, YseaRightHitbox, WIDTHseaRightHitbox, HEIGHTseaRightHitbox);
		g.drawRect(XseaUpHitbox, YseaUpHitbox, WIDTHseaUpHitbox, HEIGHTseaUpHitbox);
	}




	public BufferedImage getPlaying_background() {
		return playing_background;
	}
	
	private void loadImgs() {
		playing_background = LoadSave.GetSpriteAtlas(LoadSave.PLAYING_BACKGROUND);
	}
	
	public void draw(Graphics g) {
		//g.setColor(new Color(0, 0, 0, 150));
		//g.fillRect(0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT);
		g.drawImage(playing_background, xPos, yPos, null);

		player.render(g, xLvlOffset);
		player.drawPlayerHitbox(g);
		drawPlayingHitbox(g);
	}
	


	
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_A:
				player.setLeft(true);
				break;
			case KeyEvent.VK_D:
				player.setRight(true);
				break;
			case KeyEvent.VK_W:
				player.setUp(true);
				break;
			case KeyEvent.VK_S:
				player.setDown(true);
				break;
			case KeyEvent.VK_ENTER:
				Gamestate.state = Gamestate.PVE;
				break;
			}
	}

	
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_A:
				player.setLeft(false);
				break;
			case KeyEvent.VK_D:
				player.setRight(false);
				break;
				case KeyEvent.VK_W:
				player.setUp(false);
				break;
			case KeyEvent.VK_S:
				player.setDown(false);
				break;
			}
	}

   // public void mouseMoved(MouseEvent e) {
    //}

	/*public void mouseClicked(MouseEvent e) {
	}

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }*/


	
}
