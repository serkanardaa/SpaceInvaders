//Serkan Arda Yilal S005044 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Game { 

    //Score that is defined in the begining of the game.When we move and use our ammo, it decreases.
    static int SCORE = 1000;

    protected static int speed = 1;
    static int w = 750;
    static int h = 700;
   // static Music music = new Music("Imperial");

    public static void main(String args[]) throws InterruptedException, IOException {

        JFrame project = new JFrame("Space Invaders");
        project.setSize(w, h);
        project.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        project.setResizable(false);

        SpacePanel space = new SpacePanel();

        DifficultyPanel difpanel = new DifficultyPanel(project, space);

        project.add(difpanel);
        project.setVisible(true);

        Timer timer = new Timer(30, new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                project.repaint();
                if (difpanel.GameStarted) {
                    space.run();

                }

            }
        });

        //music.startBGMusic();
        timer.start();

    }

}
