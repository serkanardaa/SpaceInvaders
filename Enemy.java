//Serkan Arda Yilal S005044 

import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends SpaceElement {

    static boolean exist = false;
    static boolean exist2 = false;

    Color c;
    Color enemymover;

    public Enemy(int h, int f, int x, int y, Color color) {
        super(h, f, x, y, 60, 20);
        c = color;
        enemymover = Color.red;
    }

    @Override
    void draw(Graphics g) {
        g.setColor(c);
        //enemy main part
        g.fillRect(x, y, w, h);
        //enemy firing part
        g.fillRect(x + (2 * w) / 5, y + h, w / 5, h / 5);
        //enemy back parts
        g.fillRect(x, y - (h / 2), w / 3, h / 2);
        g.fillRect(x + (2 * w) / 3, y - (h / 2), w / 3, h / 2);

        g.setColor(enemymover);
        //enemy mover parts
        g.fillOval(x + (w / 10), y - h - h / 2, w / 6, h);
        g.fillOval(x + w / 2 + w / 4, y - h - h / 2, w / 6, h);

    }
//If first enemy army passes my ship, then the condition is true

    public boolean invaded() {
        for (int i = 0; i < SpacePanel.enemylist.size(); i++) {
            if (SpacePanel.enemylist.get(i).y + SpacePanel.enemylist.get(i).h > MyShip.myship.y) {
                return true;
            }

        }
        return false;
    }
//If second enemy army passes my ship, then the condition is true

    public boolean invaded2() {
        for (int i = 0; i < SpacePanel.enemylist2.size(); i++) {
            if (SpacePanel.enemylist2.get(i).y + SpacePanel.enemylist2.get(i).h > MyShip.myship.y) {
                return true;
            }

        }
        return false;
    }
//If third enemy army passes my ship, then the condition is true

    public boolean invaded3() {
        for (int i = 0; i < SpacePanel.enemylist3.size(); i++) {
            if (SpacePanel.enemylist3.get(i).y + SpacePanel.enemylist3.get(i).h > MyShip.myship.y) {
                return true;
            }

        }
        return false;
    }
//Moves enemies forward in y axis according to chosen difficulty speed

    @Override
    public void run() {
        this.y += Game.speed;

    }

}
