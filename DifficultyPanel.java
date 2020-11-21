//Serkan Arda Yilal S005044 

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class DifficultyPanel extends JPanel {

    public boolean GameStarted = false;

    public DifficultyPanel(JFrame frame, SpacePanel space) {
        //specialities of this panel

        setBackground(Color.black);
        setLayout(new GridLayout(4, 3));

        //panels that will include all required materials
        JPanel title = new JPanel();
        JPanel dif = new JPanel();
        JPanel options = new JPanel();
        JPanel startexit = new JPanel();

        title.setBackground(Color.black);
        dif.setBackground(Color.black);
        options.setBackground(Color.black);
        startexit.setBackground(Color.black);

        title.setLayout(new FlowLayout());
        dif.setLayout(new FlowLayout());
        options.setLayout(new FlowLayout());
        startexit.setLayout(new FlowLayout());
        //Creates Space invaders label for title panel
        JLabel SpaceInvader = new JLabel("SPACE INVADERS");
        SpaceInvader.setFont(SpaceInvader.getFont().deriveFont(50.0f));
        SpaceInvader.setForeground(Color.blue);
        SpaceInvader.setBackground(Color.black);
        //Creates difficulties label for dif panel
        JLabel Dif = new JLabel("DIFFICULTIES");
        Dif.setFont(SpaceInvader.getFont().deriveFont(25.0f));
        Dif.setForeground(Color.red);
        Dif.setBackground(Color.black);
        //Creates radio buttons for options panel
        JRadioButton easy = new JRadioButton("Easy");
        JRadioButton medium = new JRadioButton("Medium");
        JRadioButton hard = new JRadioButton("Hard");
        easy.setSelected(true);

        ButtonGroup Options = new ButtonGroup();
        Options.add(easy);
        Options.add(medium);
        Options.add(hard);
        //Creates start and exit buttons for startexit panel
        JButton start = new JButton("Start");
        JButton exit = new JButton("Exit");
        start.setBackground(Color.green);
        exit.setBackground(Color.red);

        //According to difficulties ,enemies` speed change.After that it adds the space panel instead of difficulties panel
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        });
        start.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (easy.isSelected()) {
                    Game.speed = 1;
                } else if (medium.isSelected()) {
                    Game.speed = 2;
                } else if (hard.isSelected()) {
                    Game.speed = 3;
                }
                frame.setLayout(null);
                setVisible(false);
                frame.add(space);
                frame.repaint();
                space.setBounds(0, 0, frame.getWidth(), frame.getHeight());
                space.setBackground(Color.BLACK);
                space.requestFocusInWindow();

                GameStarted = true;

            }
        });

        // adds all labels, radio buttons and buttons to required panels.
        title.add(SpaceInvader);
        dif.add(Dif);
        options.add(easy);
        options.add(medium);
        options.add(hard);
        startexit.add(start);
        startexit.add(exit);
        //adds these panels to our difficulties panel
        this.add(title);
        this.add(dif);
        this.add(options);
        this.add(startexit);

    }

}
