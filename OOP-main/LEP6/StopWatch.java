import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StopWatch extends JFrame{
    public static void main(String[] args) {
        StopWatch Spw = new StopWatch();
        MyWatch  Myw = new MyWatch();
        Spw.add(Myw);
        Spw.setVisible(true);
    }

    public StopWatch() {
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
class MyWatch extends JPanel{
    JLabel jlb = new JLabel();
    JButton jbt = new JButton();
    MyWatchthread mwt;
    boolean isSP = false;
    public MyWatch() {

        setLayout(new BorderLayout());
        jlb = new JLabel("00:00:00:000", JLabel.CENTER);

        jbt.setText("Start");
        jbt.setPreferredSize(new Dimension(jbt.getWidth(),50));

        add(jlb, BorderLayout.CENTER);
        add(jbt, BorderLayout.SOUTH);

        mwt = new MyWatchthread(jlb);

        jbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isSP) {
                    if (!mwt.isAlive()) {
                        mwt.start();
                    }
                    mwt.setscoreTime(true);
                    jbt.setText("Stop");
                } else {
                    mwt.setscoreTime(false);
                    jbt.setText("Start");
                }
                isSP = !isSP;
            }
        });
    }
}
class MyWatchthread extends Thread{
    JLabel scoreTime ;
    private boolean isSP;
    int millisecond = 0;
    int seccond = 0;
    int minute = 0;
    int hour = 0;

    public MyWatchthread(JLabel scoreTime){
        this.scoreTime = scoreTime;
    }
    public void setscoreTime(boolean isSP){
        this.isSP = isSP;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1);
            } catch (Exception e) {
            }
            if (isSP) {
                millisecond++;
                if (millisecond == 1000) {
                    millisecond = 0;
                    seccond++;
                }else if (seccond == 60) {
                    seccond = 0;
                    minute++;
                }else if (minute == 60) {
                    minute = 0;
                    hour++;
                }
                scoreTime.setText(String.format("%02d:%02d:%02d:%03d", hour, minute, seccond, millisecond));
            }
     
        }
    }
}

