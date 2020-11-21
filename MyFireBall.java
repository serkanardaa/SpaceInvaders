//Serkan Arda Yilal S005044 

import java.awt.Color;
import java.awt.Graphics;

public class MyFireBall extends SpaceElement {

//Initially coordinates of my fire ball are defined according to my ships positions
    public MyFireBall() {
        super(0, 0, MyShip.myship.x + (2 * MyShip.myship.w) / 5, MyShip.myship.y - MyShip.myship.h / 5 - MyShip.myship.w / 5, MyShip.myship.w / 5, MyShip.myship.w / 5);

    }
//my fire ball moves backward in y axis 

    @Override
    public void run() {
        this.y -= 15;

    }
//draws a oval in color orange    

    @Override
    void draw(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillOval(x, y, w, h);

    }

}
