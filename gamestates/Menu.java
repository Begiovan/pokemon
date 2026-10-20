package gamestates;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JTextField;

import main.Game;
import main.GameWindow;
import ui.MenuButton;
import utilz.LoadSave;


public class Menu{

	private MenuButton[] buttons = new MenuButton[3];
	private BufferedImage backgroundImg;
	private int menuX, menuY, menuWidth, menuHeight;



	public Menu() {
		
		loadButtons();
		loadBackground();

	}

	public void update() {
		for (MenuButton mb : buttons)
			mb.update();
	}




	private void loadBackground() {
		backgroundImg = LoadSave.GetSpriteAtlas(LoadSave.MENU_BACKGROUND);
		menuWidth = (int) (backgroundImg.getWidth() * Game.SCALE);
        menuHeight = (int) (backgroundImg.getHeight() * Game.SCALE);
		menuX =  Game.GAME_WIDTH / 2 - menuWidth / 2;
		menuY =  -412;
	}


	private void loadButtons() {
		buttons[0] = new MenuButton(Game.GAME_WIDTH / 2, (int) (150 * Game.SCALE), 0, Gamestate.PLAYING);
		buttons[1] = new MenuButton(Game.GAME_WIDTH / 2, (int) (220 * Game.SCALE), 1, Gamestate.OPTIONS);
		buttons[2] = new MenuButton(Game.GAME_WIDTH / 2, (int) (290 * Game.SCALE), 2, Gamestate.QUIT);
	}


	public void draw(Graphics g) {
		
		g.drawImage(backgroundImg, menuX, menuY, menuWidth, menuHeight, null);

		JTextField textField1 = new JTextField();
        GameWindow.jframe.add(textField1);
		textField1.setLocation(10, 10);
		textField1.setBackground(new Color(0,0,0));
		textField1.setVisible(true);
		textField1.setBounds(10,10, 200, 50);
		textField1.setEditable(true);
		textField1.setEnabled(true);
		textField1.setFocusable(true);
		textField1.setActionCommand("gigi");
		//textField1.registerKeyboardAction(null, null, 0);
		//textField1.registerKeyboardAction(null, null, null, menuHeight);
		
		String a = textField1.getText();
		System.out.print(a);

		/*g.setColor(new Color(100, 50, 200, 250));  porva per vedere se sovrappone le immagini in base all'ordine in cui vengono disegnate(lo fa, la prima che viene disegnata è sotto le altre)
		g.fillRect(0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT);*/ 
	
		for (MenuButton mb : buttons)
			mb.draw(g);
	}

	




	public boolean isIn(MouseEvent e, MenuButton mb) {
		return mb.getBounds().contains(e.getX(), e.getY());
	}


	public void mouseMoved(MouseEvent e) {
		for (MenuButton mb : buttons)
			mb.setMouseOver(false);

		for (MenuButton mb : buttons)
			if (isIn(e, mb)) {
				mb.setMouseOver(true);
				break;
			}
	}


	public void mousePressed(MouseEvent e) {
		for (MenuButton mb : buttons) {
			if (isIn(e, mb)) {
				mb.setMousePressed(true);
			}
		}
	}

	
	public void mouseReleased(MouseEvent e) {
		for (MenuButton mb : buttons) {
			if (isIn(e, mb)) {
				if (mb.isMousePressed())
					mb.applyGamestate();
				break;
			}
		}

		resetButtons();
	}


	private void resetButtons() {
		for (MenuButton mb : buttons)
			mb.resetBools();

	}

	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
			Gamestate.state = Gamestate.PLAYING;

	}

	
	

}