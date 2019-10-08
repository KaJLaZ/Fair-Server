package game.core.drinkers;

import java.util.Random;

public class Game {
    public static Random random = new Random();

    private Player player;
    private Player npc;
    private boolean isEnd=false;
    private boolean isWon=false;


    public Game() {
        this.player = new Player("Player");
        this.npc = new Player("NPC");
    }

    public String chooseWinner(){
        if (isEnd&&player.getAlcohol()<=1000&&player.getAlcohol()>npc.getAlcohol()&&npc.getAlcohol()<1000){
            isWon=!isWon;
            player.becomeAbleToSeePrediction();
            return "You have won";
        }else if(player.getAlcohol()>1000&&npc.getAlcohol()>1000){
            return "Draw";
        }
        else if(isEnd&&player.getAlcohol()<=1000&&npc.getAlcohol()>1000){
            player.becomeAbleToSeePrediction();
            return "You have won";
        }else {
            if(player.getAlcohol()<=1000){
                player.becomeAbleToSeePrediction();
            }
            return "You have lost";
        }
    }

    public boolean getWinner(){
        return isWon;
    }

    public Player getPlayer() { return player; }

    public Player getNpc() { return npc; }

}
