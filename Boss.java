//Serkan Arda Yilal S005044 

import java.awt.Color;
import static java.awt.Color.red;
import java.awt.Graphics;

public class Boss extends SpaceElement {

    static boolean bossExist = false;
    Color bosscolor = Color.black;
    Color bossmover = red;
    static int dirX = 1;

    public static Boss boss = new Boss(200, 3, 225, 50);

    public Boss(int Health, int FirePower, int x, int y) {
        super(Health, FirePower, x, y, 300, 50);
    }

    @Override
    void draw(Graphics g) {
        //main part of boss
        g.setColor(bosscolor);
        g.fillRect(x, y, w, h);
        //fire parts of boss
        g.fillRect(x + 2 * w / 25, y + h, w / 25, h / 5);
        g.fillRect(x + 7 * w / 25, y + h, w / 25, h / 5);
        g.fillRect(x + 12 * w / 25, y + h, w / 25, h / 5);
        g.fillRect(x + 17 * w / 25, y + h, w / 25, h / 5);
        g.fillRect(x + 22 * w / 25, y + h, w / 25, h / 5);
        //back parts of boss
        g.fillRect(x, y - h / 2, w / 15, h / 2);
        g.fillRect(x + 2 * w / 15, y - h / 2, w / 15, h / 2);
        g.fillRect(x + 4 * w / 15, y - h / 2, w / 15, h / 2);
        g.fillRect(x + 6 * w / 15, y - h / 2, w / 15, h / 2);
        g.fillRect(x + 8 * w / 15, y - h / 2, w / 15, h / 2);
        g.fillRect(x + 10 * w / 15, y - h / 2, w / 15, h / 2);
        g.fillRect(x + 12 * w / 15, y - h / 2, w / 15, h / 2);
        g.fillRect(x + 14 * w / 15, y - h / 2, w / 15, h / 2);
        //mover parts of boss
        g.setColor(bossmover);
        g.fillOval(x, y - h, w / 15, h / 2);
        g.fillOval(x + 2 * w / 15, y - h, w / 15, h / 2);
        g.fillOval(x + 4 * w / 15, y - h, w / 15, h / 2);
        g.fillOval(x + 6 * w / 15, y - h, w / 15, h / 2);
        g.fillOval(x + 8 * w / 15, y - h, w / 15, h / 2);
        g.fillOval(x + 10 * w / 15, y - h, w / 15, h / 2);
        g.fillOval(x + 12 * w / 15, y - h, w / 15, h / 2);
        g.fillOval(x + 14 * w / 15, y - h, w / 15, h / 2);

    }

    @Override
    public void run() {
        //if the boss any border of screen, it starts to move opposite side and move forward in y axis.
        x += 2 * dirX * Game.speed;

        if (Game.w <= boss.x + boss.w) {
            dirX = -1;
            y += 50;

        }
        if (boss.x <= 0) {
            dirX = 1;
            y += 50;

        }

    }
//If the boss passes my ship, then the condition is true
    public boolean bossInvaded() {
        if (boss.y + boss.h > MyShip.myship.y) {
            return true;
        }
        return false;
    }

}
