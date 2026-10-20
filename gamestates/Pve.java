package gamestates;


import java.awt.Color;
import java.awt.Font;

import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Scanner;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;
import java.awt.Graphics;


import ui.BattleButtons;
import utilz.LoadSave;
import utilz.Constants.UI.BattleButton.*;
import gamestates.Creation;
import entities.BotAllenatore;


public class Pve {

 private BattleButtons[] buttons = new BattleButtons[4];
 private BufferedImage battle_background;

 


  public Pve() {
    loadButtons();   
    loadImgs();
  }
    

  public void update(){
    for (BattleButtons bb : buttons)
			bb.update();
    
    battleVSbot();
  }






  private void loadButtons() {
		buttons[0] = new BattleButtons(430, 620, 0);
		buttons[1] = new BattleButtons(430, 745, 1);
		buttons[2] = new BattleButtons(634, 620, 2);
    buttons[3] = new BattleButtons(634, 745, 3);
	}

  private void loadImgs() {
    battle_background = LoadSave.GetSpriteAtlas(LoadSave.BATTLE_BACKGROUND);
	}


  public void draw(Graphics g) {
	  //g.setColor(new Color(0, 0, 0, 150));
    

    g.drawImage(battle_background, 0, 0, null);
		for (BattleButtons bb : buttons){
      bb.draw(g);

    }
	}

  



  
  public static void battleVSbot(){
    
    Creation pokemon = new Creation(Creation.namePokemon, Creation.elementPokemon, Creation.level, Creation.healthPoint, Creation.attack, Creation.defence);
    BotAllenatore bot_avversario = new BotAllenatore("Gigi", "Malabruzzi", "Acqua", 1, 40, 40, 40, 40, "Bolla", "Surf", "Bollaraggio", "Sub");

  
    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();

    int random = rand.nextInt(1, 2);




    System.out.print(pokemon.getTrainerPokemon() + " has " + pokemon.getNamePokemon() + " like pokemon, " + "his level is " + pokemon.getLevel() + ". \n" +
    "The caratteristics of " + pokemon.getNamePokemon() + " are: " + "The healthPoint is " + pokemon.getHealthPoint() + ", the attack is " + pokemon.getAttack() + ", " +
    "the defence is " + pokemon.getDefence() + ", " + "and then the attackSpeed is " + pokemon.getAttackSpeed() + ". \n" + "The moves of " + pokemon.getNamePokemon() + " are: " + pokemon.getResultString() + "." + "\n");

    System.out.print("\n" + bot_avversario.getTrainerBotPokemon() + " has " + bot_avversario.getNamePokemon() + " like pokemon, " + "his level is " + bot_avversario.getLevel() + ". \n" +
    "The caratteristics of " + bot_avversario.getNamePokemon() + " are: " + "The healthPoint is " + bot_avversario.getHealthPoint() + ", the attack is " + bot_avversario.getAttack() + ", " +
    "the defence is " + bot_avversario.getDefence() + ", " + "and then the attackSpeed is " + bot_avversario.getAttackSpeed());/*+ ". \n" + "The moves of " + bot_avversario.getNamePokemon() + " are: " + bot_avversario.getResultString() + ". \n");*/ 

    System.out.print("\n"+ "Hi, Trainers " + pokemon.getTrainerPokemon() + ", " + bot_avversario.getTrainerBotPokemon() + " now you will compete in 1 vs 1... " + " I hope you enjoy this fight \n");

    System.out.print("Now it's start the battle!" + "\n");




    do{ 
        System.out.print("\n"+ pokemon.getResultString() + "." + "\n");

        System.out.print(pokemon.getTrainerPokemon() + " which of theese moves of your Pokemon " + pokemon.getNamePokemon() + " do you want using for attack: ");
        System.out.println("Please choose the move like a number for example: Sub(1), Cozzata Zen(2), Lanciafiamme(3), OndaEnergetica(4)");
        String move = scanner.nextLine();

        int danno_pokemon = Integer.parseInt(move);// forse se il danno viene messo in un metodo a parte si può integrare ai tasti
        danno_pokemon = (2 * pokemon.getLevel() / 5 + 2 * 20 * pokemon.getAttack() / bot_avversario.getDefence() / 50 + 2) * 2 * random;

        
        int bot_healthpoint = bot_avversario.getHealthPoint();
        int vita_bot = bot_healthpoint - danno_pokemon; 

        System.out.println(pokemon.getNamePokemon() + " does " + danno_pokemon + " damage to " + 
        bot_avversario.getNamePokemon() + " has " + vita_bot + " left.");

        //System.out.print("\n"+ bot_avversario.getResultString() + "." + "\n");

        String res = "";
        for (int i = 0; i < 1; i++){
            res = String.valueOf(rand.nextInt(4));
        }
        System.out.println(res);

        int danno_pokemon_bot = Integer.parseInt(res);

        danno_pokemon_bot = (2 * bot_avversario.getLevel() / 5 + 2 * 20 * bot_avversario.getAttack() / pokemon.getDefence() / 50 + 2) * 2 * random;
        int pokemon_healthpoint = pokemon.getHealthPoint();
        int vita_pokemon = pokemon_healthpoint - danno_pokemon_bot; 

        System.out.println(bot_avversario.getNamePokemon() + " does " + danno_pokemon_bot + " damage to " + 
        pokemon.getNamePokemon() + " has " + vita_pokemon + " left.");

    }while(pokemon.healthPoint > 0 || bot_avversario.getHealthPoint() > 0);

    if(pokemon.healthPoint == 0) System.out.println(pokemon.getTrainerPokemon() + " has lost the fight");
    else System.out.println(bot_avversario.getTrainerBotPokemon() + " has lost the fight");
  }







  public boolean isIn(MouseEvent e, BattleButtons bb) {
		return bb.getBounds().contains( e.getX(), e.getY());
	}

  public void mousePressed(MouseEvent e) {
		for (BattleButtons bb : buttons) {
			if (isIn(e, bb)) {
				bb.setMousePressed(true);
			}
		}
	}







  public void mouseReleased(MouseEvent e) {
    for (BattleButtons bb : buttons) {
			if (isIn(e, bb)) {
				if (bb.isMousePressed())
          System.out.print("CIAO"); // Se questa riga viene cancellata Graphics non funziona più, non ho idea del perché 
          Graphics g1 = battle_background.getGraphics(); // ho scoperto che posso ricavarmi g da varie cose, ad esempio le BufferedImage ne hanno uno, però non so perché
          g1.setFont(new Font("Bauhaus 93", Font.PLAIN, 30));
          g1.setColor(Color.WHITE);
          g1.drawString("Nome Pokemon + usa + mossa", 34, 660);
				break;
			}
		}
    resetButtons();
	}

  private void resetButtons() {
		for (BattleButtons bb : buttons)
			bb.resetBools();
	}

}
