//Serkan Arda Yilal S005044 

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class SpacePanel extends JPanel {
//arraylists for my enemy army 1 2 and 3

    public static ArrayList<Enemy> enemylist = new ArrayList();
    public static ArrayList<Enemy> enemylist2 = new ArrayList();
    public static ArrayList<Enemy> enemylist3 = new ArrayList();

    public static ArrayList<SpaceElement> elements = new ArrayList<>();
//arraylist of my fireballs    
    public static ArrayList<MyFireBall> fireballs = new ArrayList<>();
//arraylist of enemy fireballs    
    public static ArrayList<EnemyFireBall> efireballs = new ArrayList<>();
//a label for my health bar    
    JLabel healthbar = new JLabel("HEALTH: " + MyShip.myship.Health);

//Some required variables for positions of enemy armies and also random numbers for adding the stars randomly
    int position1 = 40;
    int position2 = 100;
    static Random r1 = new Random();
    static Random r2 = new Random();
    int positioner = 80;

    public SpacePanel() {
// adds key listener for my ship
        addKeyListener(new MyShipHandler());

        this.setBackground(Color.black);
        this.setLayout(null);
//sets configrations of health bar        
        healthbar.setBounds(0, 600, 100, 100);
        healthbar.setForeground(Color.white);
        healthbar.setFont(healthbar.getFont().deriveFont(15.0f));
        add(healthbar);

//creates stars for my panel
        for (int i = 0; i < 350; i++) {
            Star s = new Star(r1.nextInt(Game.w), r2.nextInt(Game.h), 4, 4);

            addSpaceElement(s);

        }
//adds my ship to elements array
        addSpaceElement(MyShip.myship);

//creating my first enemy army
        for (int i = 0; i < 9; i++) {
            if (i % 2 == 0) {
                Enemy e1 = new Enemy(5, 1, 20 + positioner * i, position1, Color.green);
                enemylist.add(e1);

            } else {
                Enemy e2 = new Enemy(5, 1, 20 + positioner * i, position2, Color.green);
                enemylist.add(e2);

            }

        }
//creating my second army     
        for (int i = 0; i < 9; i++) {
            if (i % 2 == 0) {
                Enemy e1 = new Enemy(10, 2, 20 + positioner * i, position1, Color.blue);
                enemylist2.add(e1);

            } else {
                Enemy e2 = new Enemy(10, 2, 20 + positioner * i, position2, Color.blue);
                enemylist2.add(e2);

            }

        }
//creating my third army       
        for (int i = 0; i < 9; i++) {
            if (i % 2 == 0) {
                Enemy e1 = new Enemy(15, 3, 20 + positioner * i, position1, Color.LIGHT_GRAY);
                enemylist3.add(e1);

            } else {
                Enemy e2 = new Enemy(15, 3, 20 + positioner * i, position2, Color.LIGHT_GRAY);
                enemylist3.add(e2);

            }

        }

    }
//a method for adding some elements to my elements arraylist easily

    public void addSpaceElement(SpaceElement s) {
        elements.add(s);
    }
//this paint method will call all elements draw methods and draw these shapes 

    public void paint(Graphics g) {
        super.paint(g);
//draws elements in elements arraylist
        for (int i = 0; i < elements.size(); i++) {
            elements.get(i).draw(g);
        }
//draws my fireballs when fireballs array has fireballs when my ship creates them.       
        setBorder(new EtchedBorder());
        for (int i = 0; i < fireballs.size(); i++) {
            fireballs.get(i).draw(g);
        }
//draws enemy fireballs when efireballs arraylist has fireball        
        for (int i = 0; i < efireballs.size(); i++) {
            efireballs.get(i).draw(g);
        }
//draws first enemy army        
        for (int i = 0; i < enemylist.size(); i++) {
            enemylist.get(i).draw(g);
        }
//draws second enemy army if first enemy army is dead        
        if (enemylist.isEmpty()) {
            for (int i = 0; i < enemylist2.size(); i++) {
                enemylist2.get(i).draw(g);
                Enemy.exist = true;
            }
        }
//draws third enemy army if second enemy army is dead        
        if (enemylist2.isEmpty()) {
            for (int i = 0; i < enemylist3.size(); i++) {
                enemylist3.get(i).draw(g);
                Enemy.exist2 = true;
            }

        }
//draws the boss if third enemy army is dead        
        if (enemylist3.isEmpty()) {
            Boss.boss.draw(g);
            Boss.bossExist = true;
        }
    }

    public void run() {
//runs myship
        MyShip.myship.run();
        if (MyShip.myship.mover == Color.red) {
            MyShip.myship.mover = Color.orange;
        } else if (MyShip.myship.mover == Color.orange) {
            MyShip.myship.mover = Color.red;
        }

//runs first enemy army and changes their mover color       
        for (int i = 0; i < enemylist.size(); i++) {
            enemylist.get(i).run();
            if (enemylist.get(i).enemymover == Color.red) {
                enemylist.get(i).enemymover = Color.orange;
            } else if (enemylist.get(i).enemymover == Color.orange) {
                enemylist.get(i).enemymover = Color.red;
            }

        }
//runs second enemy army if first army is dead and changes their mover color       
        if (enemylist.isEmpty()) {
            for (int i = 0; i < enemylist2.size(); i++) {
                enemylist2.get(i).run();
                if (enemylist2.get(i).enemymover == Color.red) {
                    enemylist2.get(i).enemymover = Color.orange;
                } else if (enemylist2.get(i).enemymover == Color.orange) {
                    enemylist2.get(i).enemymover = Color.red;
                }
            }
        }
//runs third enemy army if second army is dead and changes their mover color       
        if (enemylist2.isEmpty()) {
            for (int i = 0; i < enemylist3.size(); i++) {
                enemylist3.get(i).run();
                if (enemylist3.get(i).enemymover == Color.red) {
                    enemylist3.get(i).enemymover = Color.orange;
                } else if (enemylist3.get(i).enemymover == Color.orange) {
                    enemylist3.get(i).enemymover = Color.red;
                }
            }
        }
//runs the boss if third enemy army is dead and changes its mover color        
        if (enemylist3.isEmpty()) {
            Boss.boss.run();
            if (Boss.boss.bossmover == Color.red) {
                Boss.boss.bossmover = Color.orange;
            } else if (Boss.boss.bossmover == Color.orange) {
                Boss.boss.bossmover = Color.red;
            }
        }
//runs my fireballs and make them damage first enemy army or make them disappear        
        for (int i = 0; i < fireballs.size(); i++) {
            fireballs.get(i).run();
            if (fireballs.get(i).y + fireballs.get(i).h < 0) {
                fireballs.remove(i);
            }

            for (int j = 0; (j < enemylist.size() && !fireballs.isEmpty()); j++) {
                if ((enemylist.get(j).y - 3 * enemylist.get(j).h / 2 <= fireballs.get(i).y) && (fireballs.get(i).y <= enemylist.get(j).y + enemylist.get(j).h) && (enemylist.get(j).x <= fireballs.get(i).x + fireballs.get(i).w / 2) && (fireballs.get(i).x + fireballs.get(i).w / 2 <= enemylist.get(j).x + enemylist.get(j).w)) {
                    fireballs.remove(i);
                    enemylist.get(j).Health -= MyShip.myship.FirePower;
                    if (enemylist.get(j).Health <= 0) {
                        enemylist.remove(j);

                    }
                    break;

                }

            }

        }
//runs my fireballs and make them damage second enemy army or make them disappear             
        for (int i = 0; i < fireballs.size(); i++) {
            fireballs.get(i).run();
            if (fireballs.get(i).y + fireballs.get(i).h < 0) {
                fireballs.remove(i);
            }

            for (int j = 0; (j < enemylist2.size() && !fireballs.isEmpty()); j++) {
                if (Enemy.exist && (enemylist2.get(j).y - 3 * enemylist2.get(j).h / 2 <= fireballs.get(i).y) && (fireballs.get(i).y <= enemylist2.get(j).y + enemylist2.get(j).h) && (enemylist2.get(j).x <= fireballs.get(i).x + fireballs.get(i).w / 2) && (fireballs.get(i).x + fireballs.get(i).w / 2 <= enemylist2.get(j).x + enemylist2.get(j).w)) {
                    fireballs.remove(i);
                    enemylist2.get(j).Health -= MyShip.myship.FirePower;
                    if (enemylist2.get(j).Health <= 0) {
                        enemylist2.remove(j);

                    }
                    break;

                }

            }

        }
//runs my fireballs and make them damage third enemy army or make them disappear             
        for (int i = 0; i < fireballs.size(); i++) {
            fireballs.get(i).run();
            if (fireballs.get(i).y + fireballs.get(i).h < 0) {
                fireballs.remove(i);
            }

            for (int j = 0; (j < enemylist3.size() && !fireballs.isEmpty()); j++) {
                if (Enemy.exist2 && (enemylist3.get(j).y - 3 * enemylist3.get(j).h / 2 <= fireballs.get(i).y) && (fireballs.get(i).y <= enemylist3.get(j).y + enemylist3.get(j).h) && (enemylist3.get(j).x <= fireballs.get(i).x + fireballs.get(i).w / 2) && (fireballs.get(i).x + fireballs.get(i).w / 2 <= enemylist3.get(j).x + enemylist3.get(j).w)) {
                    fireballs.remove(i);
                    enemylist3.get(j).Health -= MyShip.myship.FirePower;
                    if (enemylist3.get(j).Health <= 0) {
                        enemylist3.remove(j);

                    }
                    break;

                }

            }

        }
//runs my fireballs and damages the boss if one of them touch it        
        for (int i = 0; i < fireballs.size(); i++) {
            fireballs.get(i).run();
            if (fireballs.get(i).y + fireballs.get(i).h < 0) {
                fireballs.remove(i);
            }

            if (!fireballs.isEmpty() && Boss.bossExist && (Boss.boss.y - Boss.boss.h <= fireballs.get(i).y) && (fireballs.get(i).y <= Boss.boss.y + Boss.boss.h) && (Boss.boss.x <= fireballs.get(i).x + fireballs.get(i).w / 2) && (fireballs.get(i).x + fireballs.get(i).w / 2 <= Boss.boss.x + Boss.boss.w)) {
                fireballs.remove(i);
                Boss.boss.Health -= MyShip.myship.FirePower;
                if (140 <= Boss.boss.Health && Boss.boss.Health <= 180) {
                    Boss.boss.bosscolor = Color.LIGHT_GRAY;
                }
                if (80 <= Boss.boss.Health && Boss.boss.Health <= 140) {
                    Boss.boss.bosscolor = Color.yellow;

                }
                if (20 <= Boss.boss.Health && Boss.boss.Health <= 80) {
                    Boss.boss.bosscolor = Color.red;

                }

            }

        }
//runs enemy fireballs and damages myship if enemy fireballs touch it        
        for (int j = 0; j < efireballs.size(); j++) {
            efireballs.get(j).run();
        }

        for (int j = 0; j < efireballs.size(); j++) {

            if (!efireballs.isEmpty() && efireballs.get(j).y + efireballs.get(j).h <= (MyShip.myship.y + MyShip.myship.h) && MyShip.myship.y <= efireballs.get(j).y + efireballs.get(j).h && MyShip.myship.x <= efireballs.get(j).x + efireballs.get(j).w / 2 && efireballs.get(j).x + efireballs.get(j).w / 2 <= MyShip.myship.x + MyShip.myship.w) {
                efireballs.remove(j);
                if (!enemylist.isEmpty()) {
                    MyShip.myship.Health -= 1;
                } else if (enemylist.isEmpty() && !enemylist2.isEmpty()) {
                    MyShip.myship.Health -= 2;

                } else if (enemylist2.isEmpty()) {
                    MyShip.myship.Health -= 3;
                } else if (enemylist3.isEmpty()) {
                    MyShip.myship.Health -= Boss.boss.FirePower;
                }
            } else if (!efireballs.isEmpty() && efireballs.get(j).y > Game.h) {
                efireballs.remove(j);
            }
        }
//creates enemy fireballs if first enemy army see my ship        
        for (int i = 0; i < enemylist.size(); i++) {
            if ((MyShip.myship.x <= enemylist.get(i).x + 2 * enemylist.get(i).w / 5 && enemylist.get(i).x + 2 * enemylist.get(i).w / 5 <= (MyShip.myship.x + MyShip.myship.w)) || (MyShip.myship.x <= enemylist.get(i).x + 3 * enemylist.get(i).w / 5 && enemylist.get(i).x + 3 * enemylist.get(i).w / 5 <= (MyShip.myship.x + MyShip.myship.w))) {
                EnemyFireBall eball = new EnemyFireBall(enemylist.get(i).x + 2 * enemylist.get(i).w / 5, enemylist.get(i).y + enemylist.get(i).h + enemylist.get(i).h / 5);
                efireballs.add(eball);
            }
//creates enemy fireballs if second enemy army see my ship         
        }
        for (int i = 0; i < enemylist2.size(); i++) {
            if (enemylist.isEmpty() && ((MyShip.myship.x <= enemylist2.get(i).x + 2 * enemylist2.get(i).w / 5 && enemylist2.get(i).x + 2 * enemylist2.get(i).w / 5 <= (MyShip.myship.x + MyShip.myship.w)) || (MyShip.myship.x <= enemylist2.get(i).x + 3 * enemylist2.get(i).w / 5 && enemylist2.get(i).x + 3 * enemylist2.get(i).w / 5 <= (MyShip.myship.x + MyShip.myship.w)))) {
                EnemyFireBall eball2 = new EnemyFireBall(enemylist2.get(i).x + 2 * enemylist2.get(i).w / 5, enemylist2.get(i).y + enemylist2.get(i).h + enemylist2.get(i).h / 5);
                efireballs.add(eball2);
            }
        }
//creates enemy fireballs if third enemy army see my ship        
        for (int i = 0; i < enemylist3.size(); i++) {
            if (enemylist2.isEmpty() && ((MyShip.myship.x <= enemylist3.get(i).x + 2 * enemylist3.get(i).w / 5 && enemylist3.get(i).x + 2 * enemylist3.get(i).w / 5 <= (MyShip.myship.x + MyShip.myship.w)) || (MyShip.myship.x <= enemylist3.get(i).x + 3 * enemylist3.get(i).w / 5 && enemylist3.get(i).x + 3 * enemylist3.get(i).w / 5 <= (MyShip.myship.x + MyShip.myship.w)))) {
                EnemyFireBall eball3 = new EnemyFireBall(enemylist3.get(i).x + 2 * enemylist3.get(i).w / 5, enemylist3.get(i).y + enemylist3.get(i).h + enemylist3.get(i).h / 5);
                efireballs.add(eball3);
            }
        }
//creates enemy fireballs if the boss see my ship
        if (enemylist3.isEmpty() && ((MyShip.myship.x <= Boss.boss.x + 23 * Boss.boss.w / 25 && Boss.boss.x + 2 * Boss.boss.w / 25 <= MyShip.myship.x) || (MyShip.myship.x + MyShip.myship.w <= Boss.boss.x + 23 * Boss.boss.w / 25 && Boss.boss.x + 2 * Boss.boss.w / 25 <= MyShip.myship.x + MyShip.myship.w))) {
            EnemyFireBall bossball1 = new EnemyFireBall(Boss.boss.x + 2 * Boss.boss.w / 25, Boss.boss.y + Boss.boss.h);
            EnemyFireBall bossball2 = new EnemyFireBall(Boss.boss.x + 7 * Boss.boss.w / 25, Boss.boss.y + Boss.boss.h);
            EnemyFireBall bossball3 = new EnemyFireBall(Boss.boss.x + 12 * Boss.boss.w / 25, Boss.boss.y + Boss.boss.h);
            EnemyFireBall bossball4 = new EnemyFireBall(Boss.boss.x + 17 * Boss.boss.w / 25, Boss.boss.y + Boss.boss.h);
            EnemyFireBall bossball5 = new EnemyFireBall(Boss.boss.x + 22 * Boss.boss.w / 25, Boss.boss.y + Boss.boss.h);
            efireballs.add(bossball1);
            efireballs.add(bossball2);
            efireballs.add(bossball3);
            efireballs.add(bossball4);
            efireballs.add(bossball5);

        }
        //refreshes my current health
        healthbar.setText("HEALTH: " + MyShip.myship.Health);
        repaint();
//if one of first enemy army gets back of myship then game over
        for (int i = 0; i < enemylist.size(); i++) {
            if (enemylist.get(i).invaded()) {
                JOptionPane.showMessageDialog(null, "  YOU ARE INVADED\n    GAME OVER ");
                System.exit(0);
            }
        }
//if one of second enemy army gets back of myship then game over        
        for (int i = 0; i < enemylist2.size(); i++) {
            if (enemylist2.get(i).invaded2()) {
                JOptionPane.showMessageDialog(null, "  YOU ARE INVADED\n    GAME OVER ");
                System.exit(0);
            }
        }
//if one of third enemy army gets back of myship then game over        
        for (int i = 0; i < enemylist3.size(); i++) {
            if (enemylist3.get(i).invaded3()) {
                JOptionPane.showMessageDialog(null, "  YOU ARE INVADED\n    GAME OVER ");
                System.exit(0);
            }
        }
//if boss gets back of myship then game over        
        if (Boss.boss.bossInvaded()) {
            JOptionPane.showMessageDialog(null, "  YOU ARE INVADED\n    GAME OVER ");
            System.exit(0);

        }
//if you die then game over        
        if (MyShip.myship.Health <= 0) {
            JOptionPane.showMessageDialog(null, "       YOU ARE DEAD\n         GAME OVER ");
            System.exit(0);
        }
//if you kill the boss and also have full health then you win and you are untouchable,otherwise you just win        
        if (Boss.boss.Health <= 0 && MyShip.myship.Health == 100) {
            JOptionPane.showMessageDialog(null, "    YOU ARE UNTOUCHABLE!\n YOU WIN!  \n YOUR SCORE IS: " + Game.SCORE);
            System.exit(0);
        } else if (Boss.boss.Health <= 0) {
            JOptionPane.showMessageDialog(null, "            YOU WIN!  \n YOUR SCORE IS: " + Game.SCORE);
            System.exit(0);
        }

    }
//keyadapter for movements and firing of my ship

    class MyShipHandler extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT && MyShip.myship.x > 0) {
                MyShip.myship.moveLeft();
                Game.SCORE -= 1;
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT && Game.w > MyShip.myship.x + MyShip.myship.w) {
                MyShip.myship.moveRight();
                Game.SCORE -= 1;
            }
            if (e.getKeyCode() == KeyEvent.VK_UP && MyShip.myship.y - (MyShip.myship.h) / 5 > 0) {
                MyShip.myship.moveUp();
                Game.SCORE -= 1;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN && Game.h > MyShip.myship.y + MyShip.myship.h + 16 * (MyShip.myship.h) / 5) {
                MyShip.myship.moveDown();
                Game.SCORE -= 1;
            }

            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                MyFireBall myball = new MyFireBall();
                fireballs.add(myball);
                Game.SCORE -= 1;

            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            super.keyReleased(ke);
            if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                MyShip.myship.stop();
                Game.SCORE -= 1;
            }
            if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
                MyShip.myship.stop();
                Game.SCORE -= 1;
            }
            if (ke.getKeyCode() == KeyEvent.VK_UP) {
                MyShip.myship.stop();
                Game.SCORE -= 1;
            }
            if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
                MyShip.myship.stop();
                Game.SCORE -= 1;
            }
        }

    }

}
