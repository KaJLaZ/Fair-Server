package game.core.chooseFate;

public class PointOfHit {


    public double x;
    public double y;

    public PointOfHit(double x, double y){
        this.x = x;
        this.y = y;
    }
    public PointOfHit(){
        x = 10;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}