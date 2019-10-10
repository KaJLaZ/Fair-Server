package game.core.drinkers;

import java.util.Random;

public class Game {
    public static Random random = new Random();

    private Player player;
    private Player npc;
    private boolean isEnd=false;
    private boolean isWon=false;
    private String winner;


    public Game() {
        this.player = new Player("Player");
        this.npc = new Player("NPC");
    }

    public String whoIsWinner(){
        winner=chooseWinner();
        return winner;
    }

    public String chooseWinner(){
       if (player.getAlcohol()>1000){
           if (npc.getAlcohol()>1000){
               return "Draw";
           }else if (npc.getAlcohol()<1000){
               return "You have lost";
           }
       }else if (player.getAlcohol()<=1000){
           player.becomeAbleToSeePrediction();
           if (npc.getAlcohol()>1000){
               return "You have won";
           }
           if (player.getAlcohol()>npc.getAlcohol()){
               return "You have won";
           }else if (player.getAlcohol()<npc.getAlcohol()&&npc.getAlcohol()<1000){
               return "You have lost";
           }
       }
        return null;
    }

    public boolean getWinner(){
        return isWon;
    }

    public Player getPlayer() { return player; }

    public Player getNpc() { return npc; }

}
