//Serkan Arda Yilal S005044 
import java.awt.Graphics;
//This class is super class for all elements that are used in game

abstract class SpaceElement {

    int Health;
    int FirePower;
    int x;
    int y;
    int w;
    int h;

    SpaceElement(int Health, int FirePower, int x, int y, int w, int h) {
        this.Health = Health;
        this.FirePower = FirePower;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
//This method is for giving orders to all elements in game

    public void run() {

    }
//This method is for drawing all elements in game

    abstract void draw(Graphics g);

}
