package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import utilz.LoadSave;
import static utilz.Constants.UI.BattleButton.*;




public class BattleButtons {
 
	private int xPos, yPos, rowIndex, index;
	//private int xOffsetCenter = B_WIDTH / 2;
	private BufferedImage[] imgs;
	private Rectangle bounds;
	private boolean mouseOver, mousePressed;

	

	public BattleButtons(int xPos, int yPos, int rowIndex) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.rowIndex = rowIndex;
        initBounds();
		loadImgs();
    }




    public void update() {
		index = 0;
		if (mouseOver)
			index = 1;
		if (mousePressed)
			index = 2;
	}





	private void initBounds() {
		bounds = new Rectangle(xPos, yPos, B_WIDTH, B_HEIGHT);
	}




	private void loadImgs() {
		imgs = new BufferedImage[4];
		BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.BATTLE_BUTTONS);
		for (int i = 0; i < imgs.length; i++)
			imgs[i] = temp.getSubimage(0 * B_WIDTH_DEFAULT, i * B_HEIGHT_DEFAULT, B_WIDTH_DEFAULT, B_HEIGHT_DEFAULT);
	}

	public void draw(Graphics g) {
		g.drawImage(imgs[index], xPos, yPos, B_WIDTH, B_HEIGHT, null);
		// For debugging the hitbox
		g.setColor(Color.PINK);
		g.drawRect(xPos, yPos, B_WIDTH, B_HEIGHT);
	}

	




	
	public boolean isMouseOver() {
		return mouseOver;
	}

	public void setMouseOver(boolean mouseOver) {
		this.mouseOver = mouseOver;
	}



	public boolean isMousePressed() {
		return mousePressed;
	}

	public void setMousePressed(boolean mousePressed) {
		this.mousePressed = mousePressed;
	}



	public Rectangle getBounds() {
		return bounds;
	}

	public void resetBools() {
		mouseOver = false;
		mousePressed = false;
	}
	

}
