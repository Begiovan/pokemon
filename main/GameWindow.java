package main;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameWindow extends JPanel {
	public static JFrame jframe;

	public GameWindow(GamePanel gamePanel) {

		jframe = new JFrame();

		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.add(gamePanel);
		jframe.pack();
		jframe.setLocationRelativeTo(null);
		jframe.setResizable(false);
		jframe.setVisible(true);
	
	}

	
}
