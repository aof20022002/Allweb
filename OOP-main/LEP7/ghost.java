import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;

class ghost {
    public static void main(String[] args) {
        frame gg = new frame();
        Myp Myp = new Myp();
        gg.add(Myp);
        gg.setVisible(true);
    }
}
class frame extends JFrame{   
    public frame(){
        setSize(1000, 563);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class Myp extends JPanel implements MouseMotionListener,MouseListener{
    Image img = Toolkit.getDefaultToolkit().createImage("dataghost/background.jpg");;
    Image ghost = Toolkit.getDefaultToolkit().createImage("dataghost/ghost.png");
    Image sight = Toolkit.getDefaultToolkit().createImage("dataghost/sight.gif");

    Random rand = new Random();
    int xs = 0;
    int ys = 0;

    boolean gun = false;

    Timer time;
    double startTime;
    double Seconds = 0 ;
    boolean gameEnded = false;

    int numghost = 10;
    int []x = new int[numghost];
    int []y = new int[numghost];

    int []hp = new int[numghost];
    boolean killghost[] = new boolean[numghost];
    public Myp(){
        
        startTime = System.currentTimeMillis();

        setSize(1000,563);

        for (int i = 0; i < numghost; i++) {
            x[i] = rand.nextInt(900);
            y[i] = rand.nextInt(400);
            hp[i] = 3;
            System.out.println(" "+killghost[i]);
        }

        Timer time = new Timer();
        time.scheduleAtFixedRate(new time(this),0,100);

        addMouseListener(this);
        addMouseMotionListener(this);
        System.out.println(" " + getWidth()+" "+getHeight());
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, this);
        Font f = new Font("Tahoma",Font.BOLD,40);
        g.setColor(Color.WHITE);
        g.setFont(f);
        g.drawString("Ghost Hunter", 670, 80);

        g.drawRect(657, 36, 300, 60);

        for (int i = 0; i < numghost; i++) {
            if (killghost[i] == false) {
                if (x[i] < 0) {
                    x[i] = x[i] + 10;
                } else if (x[i] + ghost.getWidth(this) >= getWidth()) {
                    x[i] =  x[i] - 20;
                }
                if (y[i] < 0) {
                    y[i] = y[i]+10;
                } else if (y[i] + ghost.getHeight(this) > getHeight()) {
                    y[i] = y[i] - 20;
                }
                if (hp[i] == 3) {
                    g.setColor(Color.GREEN);
                    g.fillRect(x[i], y[i] - 10, ghost.getWidth(this), 5);
                }else if (hp[i] == 2) {
                    g.setColor(Color.YELLOW);
                    g.fillRect(x[i], y[i] - 10, ghost.getWidth(this)/2, 5);
                }else if (hp[i] == 1) {
                    g.setColor(Color.RED);
                    g.fillRect(x[i], y[i] - 10, ghost.getWidth(this)/70  , 5);
                }
                
                g.drawImage(ghost, x[i], y[i], this);
            }
        }
        g.drawImage(sight, xs-50, ys-50, this);

        g.setColor(Color.RED);
        if (gun) {
            g.drawLine(500,500, xs, ys);
            gun = false;
        }
        if (!gameEnded) {
            Seconds = System.currentTimeMillis() - startTime;
            Seconds = Seconds / 1000;
        }
        
        if (gameEnded) {
            g.setFont(new Font("Tahoma", Font.BOLD, 50));
            g.setColor(Color.YELLOW);
            g.drawString("You Win!", 400, 200);
            g.drawString("Time: " + Seconds + " seconds", 350, 300);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {
        xs = e.getX();
        ys = e.getY();
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Playsound Ps = new Playsound();
        Ps.start();
        gun = true;
        int killedGhosts = 0;
        for (int i = 0; i < numghost; i++) {
            if (xs >= x[i] && xs <= x[i] + ghost.getWidth(this) && ys >= y[i] && ys <= y[i] + ghost.getHeight(this)) {
                hp[i] = hp[i]-1;
                if(hp[i] == 0){
                    killghost[i] = true;
                }
            }
            if (killghost[i]) {
                killedGhosts++;
            }
        }
        if (killedGhosts == numghost) {
            gameEnded = true;
        }
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    
}

class time extends TimerTask{
    Myp myp;
    public time(Myp myp){
        this.myp = myp;
    }
    @Override
    public void run() {
        for (int i = 0; i < myp.numghost; i++) {
            int randX = new Random().nextInt(40)-20;
            int randY = new Random().nextInt(40)-20;
            myp.x[i] = myp.x[i] + randX;
            myp.y[i] = myp.y[i] + randY;
        }
        myp.repaint();
    }
}
class Playsound extends Thread{

    @Override
    public void run() {
        String filePath = "dataghost/gun.wav";
        AudioInputStream sound;
        try {
            File soundFile = new File(filePath);
            sound = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(sound);
            clip.start();
            
            
        } catch (Exception e) {
        }
    }
}