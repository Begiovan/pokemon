package gamestates;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import java.util.*;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import java.util.ArrayList;

import utilz.LoadSave;
import main.GameWindow;


public class CreationPvp {
    private BufferedImage creation_background;

    Scanner scanner;
    Random rand;

    private static String TrainerPokemon = "Mario";
    protected static String namePokemon;
    protected static String elementPokemon;
    protected static int level;
    protected static int healthPoint;
    protected static int attack;
    protected static int defence;
    protected static int attackSpeed = 1;
    protected String resultString;

    private static String TrainerPokemon_avversario = "Gigi";
    protected static String namePokemon_avversario;
    protected static String elementPokemon_avversario;
    protected static int level_avversario;
    protected static int healthPoint_avversario;
    protected static int attack_avversario;
    protected static int defence_avversario;
    protected static int attackSpeed_avversario = 1;
    protected static int k = 0;
    protected String resultString_avversario;
   
    protected ArrayList<String> nameMoves = new ArrayList<String>();
    protected ArrayList<String> nameMoves_avversario = new ArrayList<String>();
    protected ArrayList<String> listAcqua = new ArrayList<String>(); 
    protected ArrayList<String> listFuoco = new ArrayList<String>();
    protected ArrayList<String> listErba = new ArrayList<String>();
    protected ArrayList<String> listTerra = new ArrayList<String>();
    protected ArrayList<String> listElettro = new ArrayList<String>();
    protected ArrayList<String> listLotta = new ArrayList<String>();
    protected ArrayList<String> listPsicho = new ArrayList<String>();
    protected ArrayList<String> listRoccia = new ArrayList<String>();
    protected ArrayList<String> listBuio = new ArrayList<String>();
    protected ArrayList<String> listVolante = new ArrayList<String>();
    protected ArrayList<String> listGhiaccio = new ArrayList<String>();
        
    String elements;
    


    public CreationPvp(){
        initClasses();
        loadImgs();
    }

    public CreationPvp(String namePokemon, String elementPokemon, int level, int healthPoint, int attack, int defence, int attackSpeed){
        namePokemon = this.namePokemon;
        elementPokemon = this.elementPokemon;
        level = this.level;
        healthPoint = this.healthPoint;
        attack = this.attack;
        defence = this.defence;
        attackSpeed = this.attackSpeed;
    }

    public CreationPvp(String namePokemon_avversario, String elementPokemon_avversario, int level_avversario, int healthPoint_avversario, int attack_avversario, int defence_avversario, int attackSpeed_avversario, int k){
        namePokemon_avversario = this.namePokemon_avversario;
        elementPokemon_avversario = this.elementPokemon_avversario;
        level_avversario = this.level_avversario;
        healthPoint_avversario = this.healthPoint_avversario;
        attack_avversario = this.attack_avversario;
        defence_avversario = this.defence_avversario;
        attackSpeed_avversario = this.attackSpeed_avversario;
        k = this.k;
    }


    public void update(){
        squadCreationPvp();
    }


    private void initClasses(){
        scanner = new Scanner(System.in);
        rand = new Random();        
        elements = new String();
    }




    private void squadCreationPvp(){  
            
            resultString = new String();

            healthPoint = rand.nextInt((70 - 40) + 1) + 40;
            attack = rand.nextInt((70 - 40) + 1) + 40;
            defence = rand.nextInt((70 - 40) + 1) + 40;
            attackSpeed = rand.nextInt((70 - 40) + 1) + 40;

            System.out.print("Sorry we don't have Normale, Veleno, Coleottero, Spettro, Acciaio and Drago... ");

            System.out.print("inserisci nome pokemon" + "\n");
            namePokemon = scanner.nextLine();

            System.out.print("The element that we have are: Acqua, Fuoco, Erba, Terra, Elettro, Lotta, Psicho, Roccia, Buio, Volante and Ghiaccio... " + "\n");

            System.out.print("What is the element of your pokemon: ");
            String elementPokemon = scanner.nextLine();

            System.out.print("Enter the level of your pokemon: ");
            level = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Do you want to see the list of Moves: (Yes) or (No)... ");
            String messagge = scanner.nextLine();

            System.out.print("Do you want that does the system give the moves of Pokemon? (Yes) or (No)...  ");
            String messagge2 = scanner.nextLine();
            System.out.println();

            switch (elementPokemon){
                case "Acqua": 
                    listAcqua.add("Pistolacqua");
                    listAcqua.add("Idropompa");
                    listAcqua.add("Surf");
                    listAcqua.add("Bollaraggio");
                    listAcqua.add("Ritirata");
                    listAcqua.add("Cascata");
                    listAcqua.add("Tenaglia");
                    listAcqua.add("Bolla");
                    listAcqua.add("Martellata");
                    listAcqua.add("Octazooka");
                    listAcqua.add("Pioggiadanza");
                    listAcqua.add("Mulinello");
                    listAcqua.add("Sub");
                    listAcqua.add("Idrocannone");
                    listAcqua.add("Zampillo");
                    listAcqua.add("Fanghiglia");
                    listAcqua.add("Docciascudo");
                    listAcqua.add("Idropulsar");
                    listAcqua.add("Acquadisale");
                    listAcqua.add("Acquanello");
                    listAcqua.add("Idrondata");
                    listAcqua.add("Inondazione");
                    listAcqua.add("Idrovampata");
                    listAcqua.add("Acquapatto");
                    listAcqua.add("Conchilama");
                    listAcqua.add("Vaporscoppio");
                    listAcqua.add("Acqualame");
                    listAcqua.add("Primopulsar");
                    listAcqua.add("Idroraffica");
                    if (messagge.equalsIgnoreCase("Yes")){
                        Collections.sort(listAcqua);
                        System.out.println(listAcqua);
                        for (int i = 0; i < 4; i++) {
                            System.out.print("Enter name Moves that do you want use for your Pokemon: ");
                            String nameMove = scanner.nextLine();
                            nameMoves.add(nameMove);
                            resultString = String.join(", ", nameMoves);
                        }
                    }
                break;
                case "Fuoco":
                    listFuoco.add("Lanciafiamme");
                    listFuoco.add("Fuocobomba");
                    listFuoco.add("Ruotafuoco");
                    listFuoco.add("Magifuoco");
                    listFuoco.add("Giornodisole");
                    listFuoco.add("Ondacalda");
                    listFuoco.add("Fuocofatuo");
                    listFuoco.add("Eruzione");
                    listFuoco.add("Calciardente");
                    listFuoco.add("Incendio");
                    listFuoco.add("Vampata");
                    listFuoco.add("Fuococarica");
                    listFuoco.add("Rogodenti");
                    listFuoco.add("Turbofuoco");
                    listFuoco.add("Lavasbuffo");
                    listFuoco.add("Magmaclisma");
                    listFuoco.add("Pirolancio");
                    listFuoco.add("Nitrocarica");
                    listFuoco.add("Bruciatutto");
                    listFuoco.add("Marchiatura");
                    listFuoco.add("Fiammapatto");
                    listFuoco.add("Marchiafuoco");
                    listFuoco.add("Sparafuoco");
                    listFuoco.add("Fuocoblu");
                    listFuoco.add("Voldifuoco");
                    listFuoco.add("Generatore V");
                    listFuoco.add("Incrofiamma");
                    listFuoco.add("Magifiamma");
                    listFuoco.add("Palla Infuocata");
                    listFuoco.add("Frusta di Fuoco");
                    if (messagge.equalsIgnoreCase("Yes")){
                        Collections.sort(listFuoco);
                        System.out.println(listFuoco);
                        for (int i = 0; i < 4; i++) {
                            System.out.print("Enter name Moves that do you want use for your Pokemon: ");
                            String nameMove = scanner.nextLine();
                            nameMoves.add(nameMove);
                            resultString = String.join(", ", nameMoves);
                        }
                    }
                break;
                case "Erba":
                    listErba.add("Frustata");
                    listErba.add("Assorbimento");
                    listErba.add("Megassorbimento");
                    listErba.add("Parassiseme");
                    listErba.add("Foglielama");
                    listErba.add("Solarraggio");
                    listErba.add("Paralizzante");
                    listErba.add("Sonnifero");
                    listErba.add("Petalodanza");
                    listErba.add("Spora");
                    listErba.add("Cottonspora");
                    listErba.add("Gigassorbimento");
                    listErba.add("Sintesi Erba");
                    listErba.add("Radicamento");
                    listErba.add("Pugnospine");
                    listErba.add("Aromaterapia");
                    listErba.add("Meloderba");
                    listErba.add("Semitraglia");
                    listErba.add("Radicalbero");
                    listErba.add("Fendifoglia");
                    listErba.add("Fogliamagica");
                    listErba.add("Affannoseme");
                    listErba.add("Semebomba");
                    listErba.add("Energipalla");
                    listErba.add("Verdebufera");
                    listErba.add("Vigorcolpo");
                    listErba.add("Laccioerboso");
                    listErba.add("Fogliame");
                    listErba.add("Vorticerba");
                    listErba.add("Assorbirforza");
                    listErba.add("Tagliola");
                    if (messagge.equalsIgnoreCase("Yes")){
                        Collections.sort(listErba);
                        System.out.println(listErba);
                        for (int i = 0; i < 4; i++) {
                            System.out.print("Enter name Moves that do you want use for your Pokemon: ");
                            String nameMove = scanner.nextLine();
                            nameMoves.add(nameMove);
                            resultString = String.join(", ", nameMoves);
                        }
                    }
                break;
                case "Terra":
                    listTerra.add("Terremoto");
                    listTerra.add("Abisso");
                    listTerra.add("Fossa");
                    listTerra.add("Ossoclava");
                    listTerra.add("Ossomerang");
                    listTerra.add("Ossoraffica");
                    listTerra.add("Magnitudo");
                    listTerra.add("Sabbiotomba");
                    listTerra.add("Battiterra");
                    listTerra.add("Giravvita");
                    listTerra.add("Mille Frecce");
                    listTerra.add("Mille Onde");
                    listTerra.add("Forza Tellurica");
                    listTerra.add("Spade Telluriche");
                    listTerra.add("Furore della Terra");
                    listTerra.add("Forza Equina");
                    listTerra.add("Battipiedi");
                    listTerra.add("Dynasisma");
                    listTerra.add("Scontro Frontale");
                    listTerra.add("Fangosberla");
                    listTerra.add("Colpo di fango");
                    listTerra.add("Geoforza");
                    listTerra.add("Pantanobomba");
                    listTerra.add("Sabbiardente");
                    listTerra.add("Tempesta Ardente");
                    listTerra.add("Punte");
                    listTerra.add("Turbosabbia");
                    listTerra.add("Fangata");
                    listTerra.add("Sabbiaccumulo");
                    listTerra.add("Forza Equina");
                    if (messagge.equalsIgnoreCase("Yes")){
                        Collections.sort(listTerra);
                        System.out.println(listTerra);
                        for (int i = 0; i < 4; i++) {
                            System.out.print("Enter name Moves that do you want use for your Pokemon: ");
                            String nameMove = scanner.nextLine();
                            nameMoves.add(nameMove);
                            resultString = String.join(", ", nameMoves);
                        }
                    }
                break;
                case "Elettro":
                    listElettro.add("Tuonopugno");
                    listElettro.add("Tuonoshock");
                    listElettro.add("Fulmine");
                    listElettro.add("Tuononda");
                    listElettro.add("Tuono");
                    listElettro.add("Falcecannone");
                    listElettro.add("Scintilla");
                    listElettro.add("Sottocarica");
                    listElettro.add("Locomovolt");
                    listElettro.add("Ondashock");
                    listElettro.add("Magnetascesa");
                    listElettro.add("Fulmindenti");
                    listElettro.add("Scarica");
                    listElettro.add("Raggioscossa");
                    listElettro.add("Energisfera");
                    listElettro.add("Invertivolt");
                    listElettro.add("Elettrotela");
                    listElettro.add("Sprizzalampo");
                    listElettro.add("Lucesiluro");
                    listElettro.add("Incrotuono");
                    listElettro.add("Pioggiaplasma");
                    listElettro.add("Caricaparabola");
                    listElettro.add("Elettrocontagio");
                    listElettro.add("Elettromistero");
                    listElettro.add("Controllo Polare");
                    listElettro.add("Campo Elettrico");
                    listElettro.add("Elettrococcola");
                    listElettro.add("Gigascarica Folgorante");
                    listElettro.add("Super Pikaboom");
                    listElettro.add("Iperfulmine");
                    if (messagge.equalsIgnoreCase("Yes")){
                        Collections.sort(listElettro);
                        System.out.println(listElettro);
                        for (int i = 0; i < 4; i++) {
                            System.out.print("Enter name Moves that do you want use for your Pokemon: ");
                            String nameMove = scanner.nextLine();
                            nameMoves.add(nameMove);
                            resultString = String.join(", ", nameMoves);
                        }
                    }
                break;
                case "Lotta":
                    listLotta.add("Colpokarate");
                    listLotta.add("Doppiocalcio");
                    listLotta.add("Calciosalto");
                    listLotta.add("Calciorullo");
                    listLotta.add("Sottomissione");
                    listLotta.add("Colpo Basso");
                    listLotta.add("Contrattacco");
                    listLotta.add("Movimento Sismico");
                    listLotta.add("Calcinvolo");
                    listLotta.add("Triplocalcio");
                    listLotta.add("Contropiede");
                    listLotta.add("Pugnorapido");
                    listLotta.add("Individua");
                    listLotta.add("Dinamipugno");
                    listLotta.add("Vitaltiro");
                    listLotta.add("Incrocolpo");
                    listLotta.add("Spaccaroccia");
                    listLotta.add("Centripugno");
                    listLotta.add("Troppoforte");
                    listLotta.add("Vendetta");
                    listLotta.add("Sberletese");
                    listLotta.add("Stramontante");
                    listLotta.add("Granfisico");
                    listLotta.add("Svegliopacca");
                    listLotta.add("Martelpugno");
                    listLotta.add("Zuffa");
                    listLotta.add("Palmoforza");
                    listLotta.add("Forzasfera");
                    listLotta.add("Assorbipugno");
                    listLotta.add("Vuotonda");
                    if (messagge.equalsIgnoreCase("Yes")){
                        Collections.sort(listLotta);
                        System.out.println(listLotta);
                        for (int i = 0; i < 4; i++) {
                            System.out.print("Enter name Moves that do you want use for your Pokemon: ");
                            String nameMove = scanner.nextLine();
                            nameMoves.add(nameMove);
                            resultString = String.join(", ", nameMoves);
                        }
                    }
                break;
                case "Psicho":
                    listPsicho.add("Psicoraggio");
                    listPsicho.add("Confusione");
                    listPsicho.add("Psichico");
                    listPsicho.add("Ipnosi");
                    listPsicho.add("Meditazione");
                    listPsicho.add("Agilità");
                    listPsicho.add("Teletrasporto");
                    listPsicho.add("Barriera");
                    listPsicho.add("Schermoluce");
                    listPsicho.add("Riflesso");
                    listPsicho.add("Amnesia");
                    listPsicho.add("Cinèsi");
                    listPsicho.add("Mangiasogni");
                    listPsicho.add("Psiconda");
                    listPsicho.add("Riposo");
                    listPsicho.add("Specchiovelo");
                    listPsicho.add("Divinazione");
                    listPsicho.add("Raggiro");
                    listPsicho.add("Giocodiruolo");
                    listPsicho.add("Magivelo");
                    listPsicho.add("Baratto");
                    listPsicho.add("Esclusiva");
                    listPsicho.add("Abbagliante");
                    listPsicho.add("Foschisfera");
                    listPsicho.add("Cosmoforza");
                    listPsicho.add("Extrasenso");
                    listPsicho.add("Calmamente");
                    listPsicho.add("Psicoslancio");
                    listPsicho.add("Cozzata Zen");
                    listPsicho.add("Miracolvista");
                    if (messagge.equalsIgnoreCase("Yes")){
                        Collections.sort(listPsicho);
                        System.out.println(listPsicho);
                        for (int i = 0; i < 4; i++) {
                            System.out.print("Enter name Moves that do you want use for your Pokemon: ");
                            String nameMove = scanner.nextLine();
                            nameMoves.add(nameMove);
                            resultString = String.join(", ", nameMoves);
                        }
                    }
                break;
                case "Roccia":
                    listRoccia.add("Sassata");
                    listRoccia.add("Frana");
                    listRoccia.add("Terrempesta");
                    listRoccia.add("Rotolamento");
                    listRoccia.add("Forzantica");
                    listRoccia.add("Rocciotomba");
                    listRoccia.add("Cadutamassi");
                    listRoccia.add("Lucidatura");
                    listRoccia.add("Gemmoforza");
                    listRoccia.add("Devastomasso");
                    listRoccia.add("Pietrataglio");
                    listRoccia.add("Levitoroccia");
                    listRoccia.add("Zuccata");
                    listRoccia.add("Bodyguard");
                    listRoccia.add("Abbattimento");
                    listRoccia.add("Diamantempesta");
                    listRoccia.add("Gigamacigno Polverizzante");
                    listRoccia.add("Rocciarapida");
                    listRoccia.add("Litotempesta Radiale");
                    listRoccia.add("Colpocatrame");
                    listRoccia.add("Dynamacigno");
                    listRoccia.add("Raggiometeora");
                    listRoccia.add("Gigalapilli");
                    if (messagge.equalsIgnoreCase("Yes")){
                        Collections.sort(listRoccia);
                        System.out.println(listRoccia);
                        for (int i = 0; i < 4; i++) {
                            System.out.print("Enter name Moves that do you want use for your Pokemon: ");
                            String nameMove = scanner.nextLine();
                            nameMoves.add(nameMove);
                            resultString = String.join(", ", nameMoves);
                        }
                    }
                break;
                case "Buio":
                    listBuio.add("Morso");
                    listBuio.add("Furto");
                    listBuio.add("Finta");
                    listBuio.add("Inseguimento");
                    listBuio.add("Sgranocchio");
                    listBuio.add("Picchiaduro");
                    listBuio.add("Attaccalite");
                    listBuio.add("Adulazione");
                    listBuio.add("Memento");
                    listBuio.add("Provocazione");
                    listBuio.add("Privazione");
                    listBuio.add("Scippo");
                    listBuio.add("Falselacrime");
                    listBuio.add("Rivincita");
                    listBuio.add("Garanzia");
                    listBuio.add("Divieto");
                    listBuio.add("Lancio");
                    listBuio.add("Punizione");
                    listBuio.add("Neropulsar");
                    listBuio.add("Nottesferza");
                    listBuio.add("Rapidscambio");
                    listBuio.add("Congiura");
                    listBuio.add("Vuototetro");
                    listBuio.add("Unghiaguzze");
                    listBuio.add("Ripicca");
                    listBuio.add("Spintone");
                    listBuio.add("Urtoscuro");
                    listBuio.add("Urlorabbia");
                    listBuio.add("Monito");
                    if (messagge.equalsIgnoreCase("Yes")){
                        Collections.sort(listBuio);
                        System.out.println(listBuio);
                        for (int i = 0; i < 4; i++) {
                            System.out.print("Enter name Moves that do you want use for your Pokemon: ");
                            String nameMove = scanner.nextLine();
                            nameMoves.add(nameMove);
                            resultString = String.join(", ", nameMoves);
                        }
                    }
                break;
                case "Volante":
                    listVolante.add("Acrobazia");
                    listVolante.add("Aerasoio");
                    listVolante.add("Aeroassalto");
                    listVolante.add("Aeroattacco");
                    listVolante.add("Aerocolpo");
                    listVolante.add("Ali del Fato");
                    listVolante.add("Ascesa del Drago");
                    listVolante.add("Attacco d'Ala");
                    listVolante.add("Baldeali");
                    listVolante.add("Beccata");
                    listVolante.add("Cadutalibera");
                    listVolante.add("Cannonbecco");
                    listVolante.add("Danzadipiume");
                    listVolante.add("Doppia Ala");
                    listVolante.add("Dynajet");
                    listVolante.add("Eterelama");
                    listVolante.add("Gigaciclone");
                    listVolante.add("Perforbecco");
                    listVolante.add("Picchiata Devastante");
                    listVolante.add("Piombaflap");
                    listVolante.add("Raffica");
                    listVolante.add("Rimbalzo");
                    listVolante.add("Scacciabruma");
                    listVolante.add("Schiamazzo");
                    listVolante.add("Speculmossa");
                    listVolante.add("Tempesta Boreale");
                    listVolante.add("Tifone");
                    listVolante.add("Ventoincoda");
                    listVolante.add("Volo");
                    if (messagge.equalsIgnoreCase("Yes")){
                        Collections.sort(listVolante);
                        System.out.println(listVolante);
                        for (int i = 0; i < 4; i++) {
                            System.out.print("Enter name Moves that do you want use for your Pokemon: ");
                            String nameMove = scanner.nextLine();
                            nameMoves.add(nameMove);
                            resultString = String.join(", ", nameMoves);
                        }
                    }
                break;
                case "Ghiaccio":
                    listGhiaccio.add("Gelopugno");
                    listGhiaccio.add("Nebbia");
                    listGhiaccio.add("Geloraggio");
                    listGhiaccio.add("Bora");
                    listGhiaccio.add("Raggiaurora");
                    listGhiaccio.add("Nube");
                    listGhiaccio.add("Polneve");
                    listGhiaccio.add("Ventogelato");
                    listGhiaccio.add("Grandine");
                    listGhiaccio.add("Palla Gelo");
                    listGhiaccio.add("Purogelo");
                    listGhiaccio.add("Gelolancia");
                    listGhiaccio.add("Slavina");
                    listGhiaccio.add("Geloscheggia");
                    listGhiaccio.add("Gelodenti");
                    listGhiaccio.add("Alitogelido");
                    listGhiaccio.add("Gelamondo");
                    listGhiaccio.add("Elettrogelo");
                    listGhiaccio.add("Vampagelida");
                    listGhiaccio.add("Scagliagelo");
                    listGhiaccio.add("Liofilizzazione");
                    listGhiaccio.add("Criodistruzione Polare");
                    listGhiaccio.add("Martelgelo");
                    listGhiaccio.add("Velaurora");
                    listGhiaccio.add("Scricchiagelo");
                    listGhiaccio.add("Dynagelo");
                    listGhiaccio.add("Triplo Axel");
                    listGhiaccio.add("Lancia Glaciale");
                    listGhiaccio.add("Gigamelodia");
                    if (messagge.equalsIgnoreCase("Yes")){
                        Collections.sort(listGhiaccio);
                        System.out.println(listGhiaccio);
                        for (int i = 0; i < 4; i++) {
                            System.out.print("Enter name Moves that do you want use for your Pokemon: ");
                            String nameMove = scanner.nextLine();
                            nameMoves.add(nameMove);
                            resultString = String.join(", ", nameMoves);
                        }
                    }
                break;
            }

            if (messagge2.equalsIgnoreCase("Yes")){
                switch (elementPokemon){
                    case "Acqua":
                    nameMoves.add("Sub");
                    nameMoves.add("Cascata");
                    nameMoves.add("Surf");
                    nameMoves.add("Idropompa");
                    resultString = String.join(", ", nameMoves);
                    break;
                    case "Fuoco":
                    nameMoves.add("Lanciafiamme");
                    nameMoves.add("Fuocobomba");
                    nameMoves.add("Lavasbuffo");
                    nameMoves.add("Fuococarica");
                    resultString = String.join(", ", nameMoves);
                    break;
                    case "Erba":
                    nameMoves.add("Megassorbimento");
                    nameMoves.add("Energipalla");
                    nameMoves.add("Pugnospine");
                    nameMoves.add("Foglielama");
                    resultString = String.join(", ", nameMoves);
                    break;
                    case "Terra":
                    nameMoves.add("Turbosabbia");
                    nameMoves.add("Sabbiotomba");
                    nameMoves.add("Terremoto");
                    nameMoves.add("Pantanobomba");
                    resultString = String.join(", ", nameMoves);
                    break;
                    case "Elettro":
                    nameMoves.add("Tuono");
                    nameMoves.add("Energisfera");
                    nameMoves.add("Fulmine");
                    nameMoves.add("Ondashock");
                    resultString = String.join(", ", nameMoves);
                    break;
                    case "Lotta":
                    nameMoves.add("Movimento Sismico");
                    nameMoves.add("Centripugno");
                    nameMoves.add("Terremoto");
                    nameMoves.add("Sberletese");
                    resultString = String.join(", ", nameMoves);
                    break;
                    case "Psicho":
                    nameMoves.add("Psiconda");
                    nameMoves.add("Psicoraggio");
                    nameMoves.add("Ipnosi");
                    nameMoves.add("Cozzata Zen");
                    resultString = String.join(", ", nameMoves);
                    break;
                    case "Roccia":
                    nameMoves.add("Gemmoforza");
                    nameMoves.add("Frana");
                    nameMoves.add("Devastomasso");
                    nameMoves.add("Cadutamassi");
                    resultString = String.join(", ", nameMoves);
                    break;
                    case "Buio":
                    nameMoves.add("Neropulsar");
                    nameMoves.add("Nottesferza");
                    nameMoves.add("Picchiaduro");
                    nameMoves.add("Falselacrime");
                    resultString = String.join(", ", nameMoves);
                    break;
                    case "Volante":
                    nameMoves.add("Attacco d'Ala");
                    nameMoves.add("Baldeali");
                    nameMoves.add("Aerocolpo");
                    nameMoves.add("Aeroassalto");
                    resultString = String.join(", ", nameMoves);
                    break;
                    case "Ghiaccio":
                    nameMoves.add("Gelopugno");
                    nameMoves.add("Palla Gelo");
                    nameMoves.add("Elettrogelo");
                    nameMoves.add("Geloraggio");
                    resultString = String.join(", ", nameMoves);
                    break;
                    default:
                    System.out.print("Sorry don't have theese elements, please try again... ");
                    break;
                }
            }
        
            
            System.out.print("GIGI E' PRONTO ALLA BATTAGLIA");

            
            try {
                Thread.sleep(5000);
            } catch (Exception interruptedException) {
                System.out.print("GIGI non E' PRONTO ALLA BATTAGLIA");
            }

         
        

        
    
            
            resultString_avversario = new String();

            healthPoint_avversario = rand.nextInt((70 - 40) + 1) + 40;
            attack_avversario = rand.nextInt((70 - 40) + 1) + 40;
            defence_avversario = rand.nextInt((70 - 40) + 1) + 40;
            

            System.out.print("Sorry we don't have Normale, Veleno, Coleottero, Spettro, Acciaio and Drago... ");

            System.out.print("inserisci nome pokemon" + "\n");
            namePokemon_avversario = scanner.nextLine();

            System.out.print("The element that we have are: Acqua, Fuoco, Erba, Terra, Elettro, Lotta, Psicho, Roccia, Buio, Volante and Ghiaccio... " + "\n");

            System.out.print("What is the element of your pokemon: ");
            String elementPokemon_avversario = scanner.nextLine();

            System.out.print("Enter the level of your pokemon: ");
            level_avversario = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Do you want to see the list of Moves: (Yes) or (No)... ");
            String messagge_avversario = scanner.nextLine();

            System.out.print("Do you want that does the system give the moves of Pokemon? (Yes) or (No)...  ");
            String messagge2_avversario = scanner.nextLine();
            System.out.println();

            switch (elementPokemon){
                case "Acqua": 
                    listAcqua.add("Pistolacqua");
                    listAcqua.add("Idropompa");
                    listAcqua.add("Surf");
                    listAcqua.add("Bollaraggio");
                    listAcqua.add("Ritirata");
                    listAcqua.add("Cascata");
                    listAcqua.add("Tenaglia");
                    listAcqua.add("Bolla");
                    listAcqua.add("Martellata");
                    listAcqua.add("Octazooka");
                    listAcqua.add("Pioggiadanza");
                    listAcqua.add("Mulinello");
                    listAcqua.add("Sub");
                    listAcqua.add("Idrocannone");
                    listAcqua.add("Zampillo");
                    listAcqua.add("Fanghiglia");
                    listAcqua.add("Docciascudo");
                    listAcqua.add("Idropulsar");
                    listAcqua.add("Acquadisale");
                    listAcqua.add("Acquanello");
                    listAcqua.add("Idrondata");
                    listAcqua.add("Inondazione");
                    listAcqua.add("Idrovampata");
                    listAcqua.add("Acquapatto");
                    listAcqua.add("Conchilama");
                    listAcqua.add("Vaporscoppio");
                    listAcqua.add("Acqualame");
                    listAcqua.add("Primopulsar");
                    listAcqua.add("Idroraffica");
                    if (messagge_avversario.equalsIgnoreCase("Yes")){
                        Collections.sort(listAcqua);
                        System.out.println(listAcqua);
                        for (int i = 0; i < 4; i++) {
                            System.out.print("Enter name Moves that do you want use for your Pokemon: ");
                            String nameMove_avversario = scanner.nextLine();
                            nameMoves_avversario.add(nameMove_avversario);
                            resultString_avversario = String.join(", ", nameMoves_avversario);
                        }
                    }
                break;
                case "Fuoco":
                    listFuoco.add("Lanciafiamme");
                    listFuoco.add("Fuocobomba");
                    listFuoco.add("Ruotafuoco");
                    listFuoco.add("Magifuoco");
                    listFuoco.add("Giornodisole");
                    listFuoco.add("Ondacalda");
                    listFuoco.add("Fuocofatuo");
                    listFuoco.add("Eruzione");
                    listFuoco.add("Calciardente");
                    listFuoco.add("Incendio");
                    listFuoco.add("Vampata");
                    listFuoco.add("Fuococarica");
                    listFuoco.add("Rogodenti");
                    listFuoco.add("Turbofuoco");
                    listFuoco.add("Lavasbuffo");
                    listFuoco.add("Magmaclisma");
                    listFuoco.add("Pirolancio");
                    listFuoco.add("Nitrocarica");
                    listFuoco.add("Bruciatutto");
                    listFuoco.add("Marchiatura");
                    listFuoco.add("Fiammapatto");
                    listFuoco.add("Marchiafuoco");
                    listFuoco.add("Sparafuoco");
                    listFuoco.add("Fuocoblu");
                    listFuoco.add("Voldifuoco");
                    listFuoco.add("Generatore V");
                    listFuoco.add("Incrofiamma");
                    listFuoco.add("Magifiamma");
                    listFuoco.add("Palla Infuocata");
                    listFuoco.add("Frusta di Fuoco");
                    if (messagge_avversario.equalsIgnoreCase("Yes")){
                        Collections.sort(listFuoco);
                        System.out.println(listFuoco);
                        for (int i = 0; i < 4; i++) {
                            System.out.print("Enter name Moves that do you want use for your Pokemon: ");
                            String nameMove_avversario = scanner.nextLine();
                            nameMoves_avversario.add(nameMove_avversario);
                            resultString_avversario = String.join(", ", nameMoves_avversario);
                        }
                    }
                break;
                case "Erba":
                    listErba.add("Frustata");
                    listErba.add("Assorbimento");
                    listErba.add("Megassorbimento");
                    listErba.add("Parassiseme");
                    listErba.add("Foglielama");
                    listErba.add("Solarraggio");
                    listErba.add("Paralizzante");
                    listErba.add("Sonnifero");
                    listErba.add("Petalodanza");
                    listErba.add("Spora");
                    listErba.add("Cottonspora");
                    listErba.add("Gigassorbimento");
                    listErba.add("Sintesi Erba");
                    listErba.add("Radicamento");
                    listErba.add("Pugnospine");
                    listErba.add("Aromaterapia");
                    listErba.add("Meloderba");
                    listErba.add("Semitraglia");
                    listErba.add("Radicalbero");
                    listErba.add("Fendifoglia");
                    listErba.add("Fogliamagica");
                    listErba.add("Affannoseme");
                    listErba.add("Semebomba");
                    listErba.add("Energipalla");
                    listErba.add("Verdebufera");
                    listErba.add("Vigorcolpo");
                    listErba.add("Laccioerboso");
                    listErba.add("Fogliame");
                    listErba.add("Vorticerba");
                    listErba.add("Assorbirforza");
                    listErba.add("Tagliola");
                    if (messagge_avversario.equalsIgnoreCase("Yes")){
                        Collections.sort(listErba);
                        System.out.println(listErba);
                        for (int i = 0; i < 4; i++) {
                            System.out.print("Enter name Moves that do you want use for your Pokemon: ");
                            String nameMove_avversario = scanner.nextLine();
                            nameMoves_avversario.add(nameMove_avversario);
                            resultString_avversario = String.join(", ", nameMoves_avversario);
                        }
                    }
                break;
                case "Terra":
                    listTerra.add("Terremoto");
                    listTerra.add("Abisso");
                    listTerra.add("Fossa");
                    listTerra.add("Ossoclava");
                    listTerra.add("Ossomerang");
                    listTerra.add("Ossoraffica");
                    listTerra.add("Magnitudo");
                    listTerra.add("Sabbiotomba");
                    listTerra.add("Battiterra");
                    listTerra.add("Giravvita");
                    listTerra.add("Mille Frecce");
                    listTerra.add("Mille Onde");
                    listTerra.add("Forza Tellurica");
                    listTerra.add("Spade Telluriche");
                    listTerra.add("Furore della Terra");
                    listTerra.add("Forza Equina");
                    listTerra.add("Battipiedi");
                    listTerra.add("Dynasisma");
                    listTerra.add("Scontro Frontale");
                    listTerra.add("Fangosberla");
                    listTerra.add("Colpo di fango");
                    listTerra.add("Geoforza");
                    listTerra.add("Pantanobomba");
                    listTerra.add("Sabbiardente");
                    listTerra.add("Tempesta Ardente");
                    listTerra.add("Punte");
                    listTerra.add("Turbosabbia");
                    listTerra.add("Fangata");
                    listTerra.add("Sabbiaccumulo");
                    listTerra.add("Forza Equina");
                    if (messagge_avversario.equalsIgnoreCase("Yes")){
                        Collections.sort(listTerra);
                        System.out.println(listTerra);
                        for (int i = 0; i < 4; i++) {
                            System.out.print("Enter name Moves that do you want use for your Pokemon: ");
                            String nameMove_avversario = scanner.nextLine();
                            nameMoves_avversario.add(nameMove_avversario);
                            resultString_avversario = String.join(", ", nameMoves_avversario);
                        }
                    }
                break;
                case "Elettro":
                    listElettro.add("Tuonopugno");
                    listElettro.add("Tuonoshock");
                    listElettro.add("Fulmine");
                    listElettro.add("Tuononda");
                    listElettro.add("Tuono");
                    listElettro.add("Falcecannone");
                    listElettro.add("Scintilla");
                    listElettro.add("Sottocarica");
                    listElettro.add("Locomovolt");
                    listElettro.add("Ondashock");
                    listElettro.add("Magnetascesa");
                    listElettro.add("Fulmindenti");
                    listElettro.add("Scarica");
                    listElettro.add("Raggioscossa");
                    listElettro.add("Energisfera");
                    listElettro.add("Invertivolt");
                    listElettro.add("Elettrotela");
                    listElettro.add("Sprizzalampo");
                    listElettro.add("Lucesiluro");
                    listElettro.add("Incrotuono");
                    listElettro.add("Pioggiaplasma");
                    listElettro.add("Caricaparabola");
                    listElettro.add("Elettrocontagio");
                    listElettro.add("Elettromistero");
                    listElettro.add("Controllo Polare");
                    listElettro.add("Campo Elettrico");
                    listElettro.add("Elettrococcola");
                    listElettro.add("Gigascarica Folgorante");
                    listElettro.add("Super Pikaboom");
                    listElettro.add("Iperfulmine");
                    if (messagge_avversario.equalsIgnoreCase("Yes")){
                        Collections.sort(listElettro);
                        System.out.println(listElettro);
                        for (int i = 0; i < 4; i++) {
                            System.out.print("Enter name Moves that do you want use for your Pokemon: ");
                            String nameMove_avversario = scanner.nextLine();
                            nameMoves_avversario.add(nameMove_avversario);
                            resultString_avversario = String.join(", ", nameMoves_avversario);
                        }
                    }
                break;
                case "Lotta":
                    listLotta.add("Colpokarate");
                    listLotta.add("Doppiocalcio");
                    listLotta.add("Calciosalto");
                    listLotta.add("Calciorullo");
                    listLotta.add("Sottomissione");
                    listLotta.add("Colpo Basso");
                    listLotta.add("Contrattacco");
                    listLotta.add("Movimento Sismico");
                    listLotta.add("Calcinvolo");
                    listLotta.add("Triplocalcio");
                    listLotta.add("Contropiede");
                    listLotta.add("Pugnorapido");
                    listLotta.add("Individua");
                    listLotta.add("Dinamipugno");
                    listLotta.add("Vitaltiro");
                    listLotta.add("Incrocolpo");
                    listLotta.add("Spaccaroccia");
                    listLotta.add("Centripugno");
                    listLotta.add("Troppoforte");
                    listLotta.add("Vendetta");
                    listLotta.add("Sberletese");
                    listLotta.add("Stramontante");
                    listLotta.add("Granfisico");
                    listLotta.add("Svegliopacca");
                    listLotta.add("Martelpugno");
                    listLotta.add("Zuffa");
                    listLotta.add("Palmoforza");
                    listLotta.add("Forzasfera");
                    listLotta.add("Assorbipugno");
                    listLotta.add("Vuotonda");
                    if (messagge_avversario.equalsIgnoreCase("Yes")){
                        Collections.sort(listLotta);
                        System.out.println(listLotta);
                        for (int i = 0; i < 4; i++) {
                            System.out.print("Enter name Moves that do you want use for your Pokemon: ");
                            String nameMove_avversario = scanner.nextLine();
                            nameMoves_avversario.add(nameMove_avversario);
                            resultString_avversario = String.join(", ", nameMoves_avversario);
                        }
                    }
                break;
                case "Psicho":
                    listPsicho.add("Psicoraggio");
                    listPsicho.add("Confusione");
                    listPsicho.add("Psichico");
                    listPsicho.add("Ipnosi");
                    listPsicho.add("Meditazione");
                    listPsicho.add("Agilità");
                    listPsicho.add("Teletrasporto");
                    listPsicho.add("Barriera");
                    listPsicho.add("Schermoluce");
                    listPsicho.add("Riflesso");
                    listPsicho.add("Amnesia");
                    listPsicho.add("Cinèsi");
                    listPsicho.add("Mangiasogni");
                    listPsicho.add("Psiconda");
                    listPsicho.add("Riposo");
                    listPsicho.add("Specchiovelo");
                    listPsicho.add("Divinazione");
                    listPsicho.add("Raggiro");
                    listPsicho.add("Giocodiruolo");
                    listPsicho.add("Magivelo");
                    listPsicho.add("Baratto");
                    listPsicho.add("Esclusiva");
                    listPsicho.add("Abbagliante");
                    listPsicho.add("Foschisfera");
                    listPsicho.add("Cosmoforza");
                    listPsicho.add("Extrasenso");
                    listPsicho.add("Calmamente");
                    listPsicho.add("Psicoslancio");
                    listPsicho.add("Cozzata Zen");
                    listPsicho.add("Miracolvista");
                    if (messagge_avversario.equalsIgnoreCase("Yes")){
                        Collections.sort(listPsicho);
                        System.out.println(listPsicho);
                        for (int i = 0; i < 4; i++) {
                            System.out.print("Enter name Moves that do you want use for your Pokemon: ");
                            String nameMove_avversario = scanner.nextLine();
                            nameMoves_avversario.add(nameMove_avversario);
                            resultString_avversario = String.join(", ", nameMoves_avversario);
                        }
                    }
                break;
                case "Roccia":
                    listRoccia.add("Sassata");
                    listRoccia.add("Frana");
                    listRoccia.add("Terrempesta");
                    listRoccia.add("Rotolamento");
                    listRoccia.add("Forzantica");
                    listRoccia.add("Rocciotomba");
                    listRoccia.add("Cadutamassi");
                    listRoccia.add("Lucidatura");
                    listRoccia.add("Gemmoforza");
                    listRoccia.add("Devastomasso");
                    listRoccia.add("Pietrataglio");
                    listRoccia.add("Levitoroccia");
                    listRoccia.add("Zuccata");
                    listRoccia.add("Bodyguard");
                    listRoccia.add("Abbattimento");
                    listRoccia.add("Diamantempesta");
                    listRoccia.add("Gigamacigno Polverizzante");
                    listRoccia.add("Rocciarapida");
                    listRoccia.add("Litotempesta Radiale");
                    listRoccia.add("Colpocatrame");
                    listRoccia.add("Dynamacigno");
                    listRoccia.add("Raggiometeora");
                    listRoccia.add("Gigalapilli");
                    if (messagge_avversario.equalsIgnoreCase("Yes")){
                        Collections.sort(listRoccia);
                        System.out.println(listRoccia);
                        for (int i = 0; i < 4; i++) {
                            System.out.print("Enter name Moves that do you want use for your Pokemon: ");
                            String nameMove_avversario = scanner.nextLine();
                            nameMoves_avversario.add(nameMove_avversario);
                            resultString_avversario = String.join(", ", nameMoves_avversario);
                        }
                    }
                break;
                case "Buio":
                    listBuio.add("Morso");
                    listBuio.add("Furto");
                    listBuio.add("Finta");
                    listBuio.add("Inseguimento");
                    listBuio.add("Sgranocchio");
                    listBuio.add("Picchiaduro");
                    listBuio.add("Attaccalite");
                    listBuio.add("Adulazione");
                    listBuio.add("Memento");
                    listBuio.add("Provocazione");
                    listBuio.add("Privazione");
                    listBuio.add("Scippo");
                    listBuio.add("Falselacrime");
                    listBuio.add("Rivincita");
                    listBuio.add("Garanzia");
                    listBuio.add("Divieto");
                    listBuio.add("Lancio");
                    listBuio.add("Punizione");
                    listBuio.add("Neropulsar");
                    listBuio.add("Nottesferza");
                    listBuio.add("Rapidscambio");
                    listBuio.add("Congiura");
                    listBuio.add("Vuototetro");
                    listBuio.add("Unghiaguzze");
                    listBuio.add("Ripicca");
                    listBuio.add("Spintone");
                    listBuio.add("Urtoscuro");
                    listBuio.add("Urlorabbia");
                    listBuio.add("Monito");
                    if (messagge_avversario.equalsIgnoreCase("Yes")){
                        Collections.sort(listBuio);
                        System.out.println(listBuio);
                        for (int i = 0; i < 4; i++) {
                            System.out.print("Enter name Moves that do you want use for your Pokemon: ");
                            String nameMove_avversario = scanner.nextLine();
                            nameMoves_avversario.add(nameMove_avversario);
                            resultString_avversario = String.join(", ", nameMoves_avversario);
                        }
                    }
                break;
                case "Volante":
                    listVolante.add("Acrobazia");
                    listVolante.add("Aerasoio");
                    listVolante.add("Aeroassalto");
                    listVolante.add("Aeroattacco");
                    listVolante.add("Aerocolpo");
                    listVolante.add("Ali del Fato");
                    listVolante.add("Ascesa del Drago");
                    listVolante.add("Attacco d'Ala");
                    listVolante.add("Baldeali");
                    listVolante.add("Beccata");
                    listVolante.add("Cadutalibera");
                    listVolante.add("Cannonbecco");
                    listVolante.add("Danzadipiume");
                    listVolante.add("Doppia Ala");
                    listVolante.add("Dynajet");
                    listVolante.add("Eterelama");
                    listVolante.add("Gigaciclone");
                    listVolante.add("Perforbecco");
                    listVolante.add("Picchiata Devastante");
                    listVolante.add("Piombaflap");
                    listVolante.add("Raffica");
                    listVolante.add("Rimbalzo");
                    listVolante.add("Scacciabruma");
                    listVolante.add("Schiamazzo");
                    listVolante.add("Speculmossa");
                    listVolante.add("Tempesta Boreale");
                    listVolante.add("Tifone");
                    listVolante.add("Ventoincoda");
                    listVolante.add("Volo");
                    if (messagge_avversario.equalsIgnoreCase("Yes")){
                        Collections.sort(listVolante);
                        System.out.println(listVolante);
                        for (int i = 0; i < 4; i++) {
                            System.out.print("Enter name Moves that do you want use for your Pokemon: ");
                            String nameMove_avversario = scanner.nextLine();
                            nameMoves_avversario.add(nameMove_avversario);
                            resultString_avversario = String.join(", ", nameMoves_avversario);
                        }
                    }
                break;
                case "Ghiaccio":
                    listGhiaccio.add("Gelopugno");
                    listGhiaccio.add("Nebbia");
                    listGhiaccio.add("Geloraggio");
                    listGhiaccio.add("Bora");
                    listGhiaccio.add("Raggiaurora");
                    listGhiaccio.add("Nube");
                    listGhiaccio.add("Polneve");
                    listGhiaccio.add("Ventogelato");
                    listGhiaccio.add("Grandine");
                    listGhiaccio.add("Palla Gelo");
                    listGhiaccio.add("Purogelo");
                    listGhiaccio.add("Gelolancia");
                    listGhiaccio.add("Slavina");
                    listGhiaccio.add("Geloscheggia");
                    listGhiaccio.add("Gelodenti");
                    listGhiaccio.add("Alitogelido");
                    listGhiaccio.add("Gelamondo");
                    listGhiaccio.add("Elettrogelo");
                    listGhiaccio.add("Vampagelida");
                    listGhiaccio.add("Scagliagelo");
                    listGhiaccio.add("Liofilizzazione");
                    listGhiaccio.add("Criodistruzione Polare");
                    listGhiaccio.add("Martelgelo");
                    listGhiaccio.add("Velaurora");
                    listGhiaccio.add("Scricchiagelo");
                    listGhiaccio.add("Dynagelo");
                    listGhiaccio.add("Triplo Axel");
                    listGhiaccio.add("Lancia Glaciale");
                    listGhiaccio.add("Gigamelodia");
                    if (messagge_avversario.equalsIgnoreCase("Yes")){
                        Collections.sort(listGhiaccio);
                        System.out.println(listGhiaccio);
                        for (int i = 0; i < 4; i++) {
                            System.out.print("Enter name Moves that do you want use for your Pokemon: ");
                            String nameMove_avversario = scanner.nextLine();
                            nameMoves_avversario.add(nameMove_avversario);
                            resultString_avversario = String.join(", ", nameMoves_avversario);
                        }
                    }
                break;
            }

            if (messagge2_avversario.equalsIgnoreCase("Yes")){
                switch (elementPokemon_avversario){
                    case "Acqua":
                    nameMoves_avversario.add("Sub");
                    nameMoves_avversario.add("Cascata");
                    nameMoves_avversario.add("Surf");
                    nameMoves_avversario.add("Idropompa");
                    resultString_avversario = String.join(", ", nameMoves_avversario);
                    break;
                    case "Fuoco":
                    nameMoves_avversario.add("Lanciafiamme");
                    nameMoves_avversario.add("Fuocobomba");
                    nameMoves_avversario.add("Lavasbuffo");
                    nameMoves_avversario.add("Fuococarica");
                    resultString = String.join(", ", nameMoves_avversario);
                    break;
                    case "Erba":
                    nameMoves_avversario.add("Megassorbimento");
                    nameMoves_avversario.add("Energipalla");
                    nameMoves_avversario.add("Pugnospine");
                    nameMoves_avversario.add("Foglielama");
                    resultString_avversario = String.join(", ", nameMoves_avversario);
                    break;
                    case "Terra":
                    nameMoves_avversario.add("Turbosabbia");
                    nameMoves_avversario.add("Sabbiotomba");
                    nameMoves_avversario.add("Terremoto");
                    nameMoves_avversario.add("Pantanobomba");
                    resultString = String.join(", ", nameMoves_avversario);
                    break;
                    case "Elettro":
                    nameMoves_avversario.add("Tuono");
                    nameMoves_avversario.add("Energisfera");
                    nameMoves_avversario.add("Fulmine");
                    nameMoves_avversario.add("Ondashock");
                    resultString_avversario = String.join(", ", nameMoves_avversario);
                    break;
                    case "Lotta":
                    nameMoves_avversario.add("Movimento Sismico");
                    nameMoves_avversario.add("Centripugno");
                    nameMoves_avversario.add("Terremoto");
                    nameMoves_avversario.add("Sberletese");
                    resultString_avversario = String.join(", ", nameMoves_avversario);
                    break;
                    case "Psicho":
                    nameMoves_avversario.add("Psiconda");
                    nameMoves_avversario.add("Psicoraggio");
                    nameMoves_avversario.add("Ipnosi");
                    nameMoves_avversario.add("Cozzata Zen");
                    resultString_avversario = String.join(", ", nameMoves_avversario);
                    break;
                    case "Roccia":
                    nameMoves_avversario.add("Gemmoforza");
                    nameMoves_avversario.add("Frana");
                    nameMoves_avversario.add("Devastomasso");
                    nameMoves_avversario.add("Cadutamassi");
                    resultString_avversario = String.join(", ", nameMoves_avversario);
                    break;
                    case "Buio":
                    nameMoves_avversario.add("Neropulsar");
                    nameMoves_avversario.add("Nottesferza");
                    nameMoves_avversario.add("Picchiaduro");
                    nameMoves_avversario.add("Falselacrime");
                    resultString_avversario = String.join(", ", nameMoves_avversario);
                    break;
                    case "Volante":
                    nameMoves_avversario.add("Attacco d'Ala");
                    nameMoves_avversario.add("Baldeali");
                    nameMoves_avversario.add("Aerocolpo");
                    nameMoves_avversario.add("Aeroassalto");
                    resultString_avversario = String.join(", ", nameMoves_avversario);
                    break;
                    case "Ghiaccio":
                    nameMoves_avversario.add("Gelopugno");
                    nameMoves_avversario.add("Palla Gelo");
                    nameMoves_avversario.add("Elettrogelo");
                    nameMoves_avversario.add("Geloraggio");
                    resultString_avversario = String.join(", ", nameMoves_avversario);
                    break;
                    default:
                    System.out.print("Sorry don't have theese elements, please try again... ");
                    break;
                }
            }
        
            
            System.out.print("GIGI E' PRONTO ALLA BATTAGLIA");

            
            try {
                Thread.sleep(5000);
            } catch (Exception interruptedException) {
                System.out.print("GIGI non E' PRONTO ALLA BATTAGLIA");
            }

        
        
        Gamestate.state = Gamestate.PVP;
    }







    private void loadImgs() {
     creation_background = LoadSave.GetSpriteAtlas(LoadSave.BATTLE_BACKGROUND);
    }

    public void draw(Graphics g) {
        creation_background = LoadSave.GetSpriteAtlas(LoadSave.CREATION_BACKGROUND);
        g.drawImage(creation_background, 0, 0, null);
    }

  



    

    public static String getTrainerPokemon() {
        return TrainerPokemon;
    }

    public static String getNamePokemon() {
        return namePokemon;
    }

    public static String getElementPokemon() {
        return elementPokemon;
    }

    public static int getLevel() {
        return level;
    }

    public static int getHealthPoint() {
        return healthPoint;
    }

    public static int getAttack() {
        return attack;
    }

    public static int getDefence() {
        return defence;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public String getResultString() {
        return resultString;
    }






    public static String getTrainerPokemon_avversario() {
        return TrainerPokemon_avversario;
    }

    public static String getNamePokemon_avversario() {
        return namePokemon_avversario;
    }

    public static String getElementPokemon_avversario() {
        return elementPokemon_avversario;
    }

    public static int getLevel_avversario() {
        return level_avversario;
    }

    public static int getHealthPoint_avversario() {
        return healthPoint_avversario;
    }

    public static int getAttack_avversario() {
        return attack_avversario;
    }

    public static int getDefence_avversario() {
        return defence_avversario;
    }

    public int getAttackSpeed_avversario() {
        return attackSpeed_avversario;
    }

    public String getResultString_avversario() {
        return resultString_avversario;
    }






    public ArrayList<String> getNameMoves() {
        return nameMoves;
    }

    public ArrayList<String> getListAcqua() {
        return listAcqua;
    }

    public ArrayList<String> getListFuoco() {
        return listFuoco;
    }

    public ArrayList<String> getListErba() {
        return listErba;
    }

    public ArrayList<String> getListTerra() {
        return listTerra;
    }

    public ArrayList<String> getListElettro() {
        return listElettro;
    }

    public ArrayList<String> getListLotta() {
        return listLotta;
    }

    public ArrayList<String> getListPsicho() {
        return listPsicho;
    }

    public ArrayList<String> getListRoccia() {
        return listRoccia;
    }

    public ArrayList<String> getListBuio() {
        return listBuio;
    }

    public ArrayList<String> getListVolante() {
        return listVolante;
    }

    public ArrayList<String> getListGhiaccio() {
        return listGhiaccio;
    }

    public String getElements() {
        return elements;
    }
}
