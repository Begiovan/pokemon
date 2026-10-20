package entities;

public class BotAllenatore {

    protected String trainerBotPokemon;
    protected String namePokemon;
    protected String elementPokemon;
    protected int level;
    protected int healthPoint;
    protected int attack;
    protected int defence;
    protected int attackSpeed;
    protected String nameMoves;
    protected String nameMoves_1;
    protected String nameMoves_2;
    protected String nameMoves_3;

    public BotAllenatore(String trainerBotPokemon, String namePokemon, String elementPokemon, int level, int healthPoint, int attack, int defence, int attackSpeed, 
    String nameMoves, String nameMoves_1, String nameMoves_2, String nameMoves_3){
        this. trainerBotPokemon = trainerBotPokemon;
        this.namePokemon = namePokemon;
        this.elementPokemon = elementPokemon;
        this.level = level;
        this.healthPoint = healthPoint;
        this.attack = attack;
        this.defence = defence;
        this.attackSpeed = attackSpeed;
        this.nameMoves = nameMoves;
        this.nameMoves_1 = nameMoves_1;
        this.nameMoves_2 = nameMoves_2;
        this.nameMoves_3 = nameMoves_3;
    }

    public String getTrainerBotPokemon() {return trainerBotPokemon;}
    public void setTrainerBotPokemon(String trainerBotPokemon) {this.trainerBotPokemon = trainerBotPokemon;}

    public String getNamePokemon() {return namePokemon;}
    public void setNamePokemon(String namePokemon) {this.namePokemon = namePokemon;}

    public String getElementPokemon() {return elementPokemon;}
    public void setElementPokemon(String elementPokemon) {this.elementPokemon = elementPokemon;}

    public int getLevel() {return level;}
    public void setLevel(int level) {this.level = level;}

    public int getHealthPoint() {return healthPoint;}
    public void setHealthPoint(int healthPoint) {this.healthPoint = healthPoint;}

    public int getAttack() {return attack;}
    public void setAttack(int attack) {this.attack = attack;}

    public int getDefence() {return defence;}
    public void setDefence(int defence) {this.defence = defence;}
    
    public int getAttackSpeed() {return attackSpeed;}
    public void setAttackSpeed(int attackSpeed) {this.attackSpeed = attackSpeed;}

    public String getNameMoves() {return nameMoves;}
    public void setNameMoves(String nameMoves) {this.nameMoves = nameMoves;}

    public String getNameMoves_1() {return nameMoves_1;}
    public void setNameMoves_1(String nameMoves_1) {this.nameMoves_1 = nameMoves_1;}

    public String getNameMoves_2() {return nameMoves_2;}
    public void setNameMoves_2(String nameMoves_2) {this.nameMoves_2 = nameMoves_2;}

    public String getNameMoves_3() {return nameMoves_3;}
    public void setNameMoves_3(String nameMoves_3) {this.nameMoves_3 = nameMoves_3;}


    public String toString() {
        String bot = "\n" + "The trainer name is " + this.trainerBotPokemon + " and your Pokemon that you want using is: " + this.namePokemon +
        " and the element is " + this.elementPokemon + "\n" +
        "The healthPoint of " + this.namePokemon + " is " + this.healthPoint + ", " + "the Attack of " + this.namePokemon + " is " + this.attack + ", " 
        + "the Defence of " + this.namePokemon + " is " + this.defence + ", " + "the Attack Speed of " + this.namePokemon + " is " + this.attackSpeed + "\n";
        bot = bot + "The Moves that you want using for your Pokemon " + this.namePokemon + " are: " + this.nameMoves + ", " + this.nameMoves_1 + ", " + this.nameMoves_2 + ", " + 
        this.nameMoves_3 + "." + "\n";

        return bot;
    }

}
