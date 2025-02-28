import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class rain {
    public static void main(String[] args) {
        ThreadFrame td = new ThreadFrame();
        Mypanel Myp = new Mypanel();
        td.add(Myp);
        td.setVisible(true);
    }
}

class ThreadFrame extends JFrame {

    public ThreadFrame() {
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class Mypanel extends JPanel implements ActionListener{

    JLabel jlb[] = new JLabel[26];
    MyT Myt[] = new MyT[26]; 
    JButton jbt = new JButton("Start");
    boolean isRunning = false;
    public Mypanel() {
        setSize(800, 600);
        setLayout(null);

        for (int i = 0; i < jlb.length; i++) {
            jlb[i] = new JLabel((char)(65+i) +"");
            jlb[i].setBounds(19+i*30, 10, 20, 30);
            Myt[i] = new MyT(jlb[i]);
            add(jlb[i]);
            
        }
        jbt.setBounds(350, 460, 70, 50);
        add(jbt);

        jbt.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!isRunning) {
            for (int i = 0; i < Myt.length; i++) {
                if (!Myt[i].isAlive()) { // เริ่ม Thread ถ้ายังไม่เริ่ม
                    Myt[i].start();
                    
                }
                Myt[i].setisRunning(true);
            }
            jbt.setText("Stop");
        }else{
            for (int i = 0; i < Myt.length; i++) {
                Myt[i].setisRunning(false);
            }
            jbt.setText("Start");
        }
        isRunning = !isRunning;
        System.out.println(isRunning);
    }
}

class MyT extends Thread {
    JLabel letter;
    Random rand = new Random();

    private boolean isRunning;
    public MyT(JLabel letter) {
        this.letter = letter;
        letter.setForeground(new Color(new Random().nextInt(0xffffff)));
    }

    public void setisRunning (boolean isRunning){
        this.isRunning = isRunning;
    }


    @Override
    public void run() {
        while (true) {
            int delay = new Random().nextInt(500);

            if (isRunning == true) {
                letter.setBounds(letter.getX(), letter.getY() + 10, letter.getWidth(), letter.getHeight());
            }
            
            if (letter.getY() > 400) {
                letter.setBounds(letter.getX(), letter.getY() - 400, letter.getWidth(), letter.getHeight());
                letter.setForeground(new Color(new Random().nextInt(0xffffff)));
                delay = new Random().nextInt(500);
            }
            try {
                Thread.sleep(delay);
            } catch (Exception e) {
            }
           
        }
    }

}
