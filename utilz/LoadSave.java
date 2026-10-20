package utilz;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import main.Game;


public class LoadSave {

	
	public static final String MENU_BUTTONS = "button_atlas.png";
	public static final String MENU_BACKGROUND = "sfondo_pokeball_menu.png";
	public static final String PLAYER_ATLAS = "player_sprites.png";
	public static final String PLAYING_BACKGROUND = "playing_background.png";
	public static final String CREATION_BACKGROUND = "creation_background.png";
	public static final String BATTLE_BACKGROUND = "battle_background.png";
	public static final String BATTLE_BUTTONS = "battle_button_atlas.png";

	public static BufferedImage GetSpriteAtlas(String fileName) {
		BufferedImage img = null;

		InputStream is = LoadSave.class.getResourceAsStream("/res/" + fileName);
		try {
			img = ImageIO.read(is);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return img;
	}

	
}
