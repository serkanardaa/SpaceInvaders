//Serkan Arda Yilal S005044 
import java.awt.Color;
import java.awt.Graphics;

public class MyShip extends SpaceElement {

    Color ReactorColor = Color.white;
    Color mover = Color.red;

    public static MyShip myship = new MyShip(100, 5, 330, 550);
    private int speedRightX, speedLeftX, speedUpY, speedDownY;

    public MyShip(int Health, int FirePower, int x, int y) {
        super(Health, FirePower, x, y, 80, 30);

    }
//These are methods that will be required for keylistener in game to move my ship
    public void moveLeft() {

        speedLeftX = 8;
    }

    public void moveRight() {

        speedRightX = 8;
    }

    public void moveUp() {

        speedUpY = 8;
    }

    public void moveDown() {

        speedDownY = 8;
    }

    void draw(Graphics g) {
        g.setColor(Color.darkGray);
        //main part of myship
        g.fillRect(x, y, w, h);
        //firing part of myship
        g.fillRect(x + (2 * w) / 5, y - h / 5, w / 5, h / 5);
        //back parts of myship
        g.fillRect(x, y + h, w / 4, 4 * h / 5);
        g.fillRect(x + (3 * w) / 4, y + h, w / 4, 4 * h / 5);
        //reactor of myship
        g.setColor(ReactorColor);
        g.fillOval(x + w / 4, y + h + 3 * h / 10, w / 2, h / 5);
        //movers of myship
        g.setColor(mover);
        g.fillOval(x + w / 16, y + h + 4 * h / 5, w / 8, 4 * h / 5);
        g.fillOval(x + (3 * w) / 4 + w / 16, y + h + 4 * h / 5, w / 8, 4 * h / 5);

    }

    public void run() {
        //these are restricting the area of the ship can go
        if (Game.w > MyShip.myship.x + MyShip.myship.w) {
            x += speedRightX;
        }
        if (MyShip.myship.x > 0) {
            x -= speedLeftX;
        }
        if (MyShip.myship.y - (MyShip.myship.h) / 5 > 0) {
            y -= speedUpY;
        }
        if (Game.h > MyShip.myship.y + MyShip.myship.h + 16 * (MyShip.myship.h) / 5) {
            y += speedDownY;
        }
    }

    void stop() {

        speedRightX = 0;
        speedLeftX = 0;
        speedUpY = 0;
        speedDownY = 0;
    }

}
