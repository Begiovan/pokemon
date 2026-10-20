package entities;

import static utilz.Constants.PlayerConstants.*;
//import static utilz.HelpMethods.*;
import static utilz.Constants.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import gamestates.Gamestate;
import gamestates.Playing;
import main.Game;
import utilz.LoadSave;
import ui.MenuButton;
import gamestates.Pve;

public class Player  {
	
	private float playerX, playerY;
	private int playerWidth, playerHeight;
	private Rectangle2D.Float playerHitbox;
	private int aniTick, aniIndex;
	private int playerState;
	private float walkSpeed;
	private float xSpeed;
	private	float ySpeed;
	

	private BufferedImage[][] animations;//$
	private boolean moving = false;
	private boolean left, right, up, down;
	private int[][] lvlData;
	private float xDrawOffset = 21 * Game.SCALE;
	private float yDrawOffset = 4 * Game.SCALE;
	private int flipX = 0;
	private int flipW = 1;
	

	//private Playing playing;
	



	public Player(float playerX, float playerY, int playerWidth, int playerHeight, Playing playing) {
		//this.playing = playing;
		this.playerState = IDLE;
		this.walkSpeed = Game.SCALE * 1.0f;
		loadAnimations();
		initPlayerHitbox(playerWidth, playerHeight); //dimensioni hitbox a cazzo di cane
	}

	public void setSpawn(Point playerSpawn) {// x, y non so che valori hanno (l'ho pure fatto io sto metodo) //Agg. non è vero, li ho trovati sono x, y in Playing
		this.playerX = playerSpawn.x;
		this.playerY = playerSpawn.y;
		playerHitbox.x = playerSpawn.x;
		playerHitbox.y = playerSpawn.y;
	}

	public void update() {
		checkPlayerHitbox ();
		updatePos();
		setAnimation();
		updateAnimationTick();
		
	}

	public void render(Graphics g, int lvlOffset) {
		g.drawImage(animations[playerState][aniIndex], (int) (playerHitbox.x - xDrawOffset) - lvlOffset + flipX, (int) (playerHitbox.y - yDrawOffset), playerWidth * flipW, playerHeight, null);// cercare di capire espressione 2° e 3° parametro
		drawPlayerHitbox(g);
	
	}





// non sappiamo come funzionano le animazioni
	private void updateAnimationTick() {
		aniTick++;
		if (aniTick >= ANI_SPEED) {
			aniTick = 0;
			aniIndex++;
			if (aniIndex >= GetSpriteAmount(playerState)) {
				aniIndex = 0;	
			}
		}
	}


	private void setAnimation() {
		int startAni = playerState;

		if (moving)
			playerState = RUNNING;
		else
			playerState = IDLE;

		if (startAni != playerState)
			resetAniTick();
	}


	private void resetAniTick() {
		aniTick = 0;
		aniIndex = 0;
	}


	private void loadAnimations() {
		BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_ATLAS);
		animations = new BufferedImage[7][8];
		for (int j = 0; j < animations.length; j++)
			for (int i = 0; i < animations[j].length; i++)
				animations[j][i] = img.getSubimage(i * 64, j * 40, 64, 40);	
	}






	private void updatePos() {
		moving = false;

		xSpeed = 0;
		ySpeed = 0;
		

		if (left) {
			xSpeed = xSpeed - walkSpeed;// sto walkSpeed non si sa che valore ha e quando e dove assume questo valore (viene dichiarato in Entity)
			flipX = playerWidth;
			flipW = -1;
			moving = true;
		}
		if (right) {
			xSpeed = xSpeed + walkSpeed;
			flipX = 0;
			flipW = 1;
			moving = true;
		}
		if(up) {
			ySpeed = ySpeed - walkSpeed;
		}
		if (down) {
			ySpeed = ySpeed + walkSpeed;
		}

		updateXPos(xSpeed);
		updateYPos(ySpeed);
	}

	

	private void updateXPos(float xSpeed) {
		
			playerHitbox.x += xSpeed;
		
	}

	private void updateYPos(float ySpeed) {
			playerHitbox.y += ySpeed;
	}




	public void resetDirBooleans() {
		left = false;
		right = false;
	}
	
	public void resetAll() {
		resetDirBooleans();
	
		moving = false;
		playerState = IDLE;
		

		playerHitbox.x = playerX;
		playerHitbox.y = playerY;

	}

	


	public boolean isLeft() {// is == get (non so perché sia scritto così, poi in caso si cambia)
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}



	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}



	public boolean isUp() {
		return right;
	}

	public void setUp(boolean up) {
		this.up = up;
	}



	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}




	protected void initPlayerHitbox(int width, int height) {
		playerHitbox = new Rectangle2D.Float(playerX, playerY, width, height);
	}


	protected void updateHitbox() {
		playerHitbox.x = (int) playerX;
		playerHitbox.y = (int) playerY;
	}


	public Rectangle2D.Float getHitbox() {
		return playerHitbox;
	}


	public void drawPlayerHitbox(Graphics g) {
		// For debugging the hitbox
		g.setColor(Color.PINK);
		g.drawRect((int) playerHitbox.x, (int) playerHitbox.y, (int) playerHitbox.width, (int) playerHitbox.height);

	}

	public void checkPlayerHitbox (){
		if (playerHitbox.intersects(Playing.seaLeftHitbox)) {
			walkSpeed = 0;
			if (isRight()) {
				walkSpeed = Game.SCALE * 1.0f;
			}
			if (isUp()) {
				walkSpeed = Game.SCALE * -1.0f;
			}
			if (isDown()) {
				walkSpeed = Game.SCALE * 1.0f;
			}
		}

		if (playerHitbox.intersects(Playing.seaRightHitbox)) {
			walkSpeed = 0;
			if (isLeft()) {
				walkSpeed = Game.SCALE * 1.0f;
			}
			if (isUp()) {
				walkSpeed = Game.SCALE * 1.0f;
			}
			if (isDown()) {
				walkSpeed = Game.SCALE * 1.0f;
			}
		}

		if (playerHitbox.intersects(Playing.seaUpHitbox)) {
			walkSpeed = 0;
			if (isLeft()) {
				walkSpeed = Game.SCALE * 1.0f;
			}
			if (isRight()) {
				walkSpeed = Game.SCALE * 1.0f;
			}
			if (isDown()) {
				walkSpeed = Game.SCALE * 1.0f;
			}
		}

		if (playerHitbox.intersects(Playing.pveHitbox)) {
			walkSpeed = 0;
			Gamestate.state = Gamestate.CREATION;
		}

		if (playerHitbox.intersects(Playing.pvpHitbox)) {
			Gamestate.state = Gamestate.CREATIONPVP;
		}


	}
}