package gamestates;

import java.util.Random;
import java.util.Scanner;

public class Pvp {
   
    


    
    public Pvp() {

    }

    public void update(){
        battlePvp();
    }


    public static void battlePvp(){
        CreationPvp pokemon = new CreationPvp(CreationPvp.namePokemon, CreationPvp.elementPokemon, CreationPvp.level, CreationPvp.healthPoint, CreationPvp.attack, CreationPvp.defence, CreationPvp.attackSpeed);
        CreationPvp pokemon_avversario = new CreationPvp(CreationPvp.namePokemon_avversario, CreationPvp.elementPokemon_avversario, CreationPvp.level_avversario, CreationPvp.healthPoint_avversario, CreationPvp.attack_avversario, CreationPvp.defence_avversario, CreationPvp.attackSpeed_avversario, CreationPvp.k=0);
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        int random = rand.nextInt(1, 2);

        System.out.print(pokemon.getTrainerPokemon() + " has " + pokemon.getNamePokemon() + " like pokemon, " + "his level is " + pokemon.getLevel() + ". \n" +
        "The caratteristics of " + pokemon.getNamePokemon() + " are: " + "The healthPoint is " + pokemon.getHealthPoint() + ", the attack is " + pokemon.getAttack() + ", " +
        "the defence is " + pokemon.getDefence() + ", " + "and then the attackSpeed is " + pokemon.getAttackSpeed() + ". \n" + "The moves of " + pokemon.getNamePokemon() + " are: " + pokemon.getResultString() + "." + "\n");

        System.out.print("\n" + pokemon_avversario.getTrainerPokemon_avversario() + " has " + pokemon_avversario.getNamePokemon_avversario() + " like pokemon, " + "his level is " + pokemon_avversario.getLevel_avversario() + ". \n" +
        "The caratteristics of " + pokemon_avversario.getNamePokemon_avversario() + " are: " + "The healthPoint is " + pokemon_avversario.getHealthPoint_avversario() + ", the attack is " + pokemon_avversario.getAttack_avversario() + ", " +
        "the defence is " + pokemon_avversario.getDefence_avversario() + ", " + "and then the attackSpeed is " + pokemon_avversario.getAttackSpeed_avversario() + ". \n" + "The moves of " + pokemon_avversario.getNamePokemon_avversario() + " are: " + pokemon_avversario.getResultString_avversario() + ". \n");

        System.out.print("\n"+ "Hi, Trainers " + pokemon.getTrainerPokemon() + ", " + pokemon_avversario.getTrainerPokemon_avversario() + " now you will compete in 1 vs 1... " + " I hope you enjoy this fight \n");

        if(pokemon.getAttackSpeed() > pokemon_avversario.getAttackSpeed_avversario()){
            System.out.print("Now it's start the battle!" + "\n");

            do{ 
                System.out.print("\n"+ pokemon.getResultString() + "." + "\n");

                System.out.print(pokemon.getTrainerPokemon() + " which of theese moves of your Pokemon " + pokemon.getNamePokemon() + " do you want using for attack: ");
                System.out.println("Please choose the move like a number for example: Sub(1), Cozzata Zen(2), Lanciafiamme(3), OndaEnergetica(4)");
                String move = scanner.nextLine();// forse move_avversario

                int danno_pokemon_avversario = Integer.parseInt(move);// forse move_avversario

                danno_pokemon_avversario = (2 * pokemon.getLevel() / 5 + 2 * 20 * pokemon.getAttack() / pokemon_avversario.getDefence_avversario() / 50 + 2) * 2 * random;
                pokemon_avversario.healthPoint_avversario = pokemon_avversario.getHealthPoint_avversario() - danno_pokemon_avversario;

                System.out.println(pokemon.getNamePokemon() + " does " + danno_pokemon_avversario + " damage to " + 
                pokemon_avversario.getNamePokemon_avversario() + " has " + pokemon_avversario.healthPoint_avversario + " left.");

                System.out.print("\n"+ pokemon_avversario.getResultString_avversario() + "." + "\n");

                System.out.print(pokemon.getTrainerPokemon() + " which of theese moves of your Pokemon " + pokemon.getNamePokemon() + " do you want using for attack: ");
                System.out.println("Please choose the move like a number for example: Sub(1), Cozzata Zen(2), Lanciafiamme(3), OndaEnergetica(4)");
                String move_avversario = scanner.nextLine(); 

                int danno_pokemon = Integer.parseInt(move_avversario);

                danno_pokemon = (2 * pokemon_avversario.getLevel_avversario() / 5 + 2 * 20 * pokemon_avversario.getAttack_avversario() / pokemon.getDefence() / 50 + 2) * 2 * random;
                pokemon.healthPoint = pokemon.getHealthPoint() - danno_pokemon;

                System.out.println(pokemon_avversario.getNamePokemon_avversario() + " does " + danno_pokemon + " damage to " + 
                pokemon.getNamePokemon() + " has " + pokemon.healthPoint + " left.");
                
            }while(pokemon.healthPoint > 0 || pokemon_avversario.healthPoint_avversario > 0);
        }

        if(pokemon.healthPoint == 0) System.out.println(pokemon.getTrainerPokemon() + " has lost the fight");
        else System.out.println(pokemon_avversario.getTrainerPokemon_avversario() + " has lost the fight");
    }
}
