package game.core.drinkers;

import java.util.Random;

public class Player {
    public boolean passed;
    private int alcohol;
    private String name;
    private boolean isAbleToSeePrediction=false;


    static Random random=new Random();
    private int alcoholPower=100;

    public Player(String name) {
        this.name=name;
        this.alcohol = 0;
    }

    public void becomeAbleToSeePrediction() {
        isAbleToSeePrediction=!isAbleToSeePrediction;
    }

    public int getAlcohol() {
        return alcohol;
    }

    public String showIntoxication(){
        return "Intoxication :"+alcohol;
    }

    public boolean isAbleToSeePrediction() {
        return isAbleToSeePrediction;
    }

    public void showPlayer() {
        System.out.println("Player{" + "alcohol=" + alcohol + ", name='" + name + '\'' + '}');
    }

    public void pass(){
        passed=true;
    }

    public void drink(){
        if (!passed) {
            this.alcohol += 40+random.nextInt(alcoholPower);
            alcoholPower+=40;
        }else{
            System.out.println("You have passed");
        }
    }

    public void npcDrink(){
        if (getAlcohol()<940){
            drink();
        }
    }
}
