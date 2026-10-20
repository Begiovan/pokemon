package main;

import java.awt.Graphics;

import gamestates.Creation;
import gamestates.CreationPvp;
import gamestates.Gamestate;
import gamestates.Menu;
import gamestates.Playing;
import gamestates.Pve;
import gamestates.Pvp;

public class Game implements Runnable {

	public static GameWindow gameWindow;
	public static GamePanel gamePanel;
	private Thread gameThread;
	private final int FPS_SET = 120;
	private final int UPS_SET = 200; //updatePerSec

	private Playing playing;
	private Menu menu;
	private Creation creation;
	private CreationPvp creationPvp;
	private Pve pve;
	private Pvp pvp;

	public final static float SCALE = 2f;
	public final static int GAME_WIDTH = 1000;
	public final static int GAME_HEIGHT = 900;
	
	
	public Game() {
		gamePanel = new GamePanel(this);
		gameWindow = new GameWindow(gamePanel);
		gamePanel.requestFocus();

		initClasses();

		startGameLoop();

	}


	private void initClasses() {
		menu = new Menu();
		playing = new Playing();
		creation = new Creation ();
		creationPvp = new CreationPvp();
		pve = new Pve();
		pvp = new Pvp();
	}


	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
	}


	public void update() {
		switch (Gamestate.state) {
		case MENU:
			menu.update();
			break;
		case PLAYING:
			playing.update();
			break;
		case CREATION:
			creation.update();
			break;
		case CREATIONPVP:
			creationPvp.update();
		case PVE:
			pve.update();
			break;
		case PVP:
			pvp.update();
			break;
		case OPTIONS:
		case QUIT:
		default:
			System.exit(0);
			break;

		}
	}

	public void render(Graphics g) {
		switch (Gamestate.state) {
		case MENU:
			menu.draw(g);
			break;
		case PLAYING:
			playing.draw(g);
			break;
		case CREATION:
			creation.draw(g);
			break;
		case PVE:
			pve.draw(g);
			break;
		case PVP:
		case OPTIONS:
		default:
			break;
		}
	}



	@Override
	public void run() {

		double timePerFrame = 1000000000.0 / FPS_SET; // Quanto deve durare ogni frame in nanoSec
		double timePerUpdate = 1000000000.0 / UPS_SET;

		long previousTime = System.nanoTime();

		int frames = 0;
		int updates = 0;
		long lastCheck = System.currentTimeMillis();

		double deltaU = 0;
		double deltaF = 0;

		while (true) {
			long currentTime = System.nanoTime();

			deltaU += (currentTime - previousTime) / timePerUpdate;
			deltaF += (currentTime - previousTime) / timePerFrame;
			previousTime = currentTime;

			
			if (deltaF >= 1) {
				gamePanel.repaint();
				frames++;
				deltaF--;
			}
			if (deltaU >= 1) {
				update();
				updates++;
				deltaU--;
			}

			

			if (System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				//System.out.println("FPS: " + frames + " | UPS: " + updates);
				frames = 0;
				updates = 0;

			}
		}

	}


	
	public Menu getMenu() {
		return menu;
	}

	public Playing getPlaying() {
		return playing;
	}

	public Pve getPve(){
		return pve;
	}
}