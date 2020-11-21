//Serkan Arda Yilal S005044 

import java.awt.Color;
import java.awt.Graphics;

public class EnemyFireBall extends SpaceElement {

    public EnemyFireBall(int x, int y) {
        super(0, 0, x, y, 12, 12);

    }

    // moves enemy fire balls forward in y axis

    @Override
    public void run() {
        this.y += 5;

    }

    //draws a red oval

    @Override
    void draw(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(x, y, w, h);

    }

}
