package game.core.drinkers;

import java.util.Random;

public class Player {
    public boolean passed;
    private int alcohol;
    private String name;
    private boolean isAbleToSeePrediction=true;


    static Random random=new Random();
    private int alcoholPower=100;

    public Player(String name) {
        this.name=name;
        this.alcohol = 0;
    }

    public void becomeAbleToSeePrediction() {
        isAbleToSeePrediction=true;
    }

    public void becomeUnableToSeePrediction(){
        isAbleToSeePrediction=false;
    }

    public int getAlcohol() {
        return alcohol;
    }

    public boolean isAbleToSeePrediction() {
        return isAbleToSeePrediction;
    }

    public void setAlcohol(int alcohol) {
        this.alcohol = alcohol;
    }

    public void pass(){

    }

    public void drink(){
            this.alcohol += 40+random.nextInt(alcoholPower);
            alcoholPower+=40;
    }

    public void npcDrink(){
        if (getAlcohol()<850){
            drink();
        }
    }
}
