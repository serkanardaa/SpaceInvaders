//Serkan Arda Yilal S005044 
import java.awt.Color;
import java.awt.Graphics;


public class Star extends SpaceElement {

    public Star(int x, int y, int w, int h) {
        super(0, 0, x, y, w, h);
    }

//Creates white oval as stars    
    @Override
    void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillOval(x,y,w,h);
        
    }
    
}
