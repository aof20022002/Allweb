
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ThreadMine {

    public static void main(String[] args)  {
        ThreadFrame td = new ThreadFrame();
        Mypanel Myp = new Mypanel();
        td.add(Myp);
        td.setVisible(true);
    }
}

class ThreadFrame extends JFrame {
   
    public ThreadFrame()  {
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
    }
}
class Mypanel extends JPanel{
    JLabel []jll = new JLabel[4];
    MyThread []Myt = new MyThread[4];
    int time[] = {5, 10, new Random().nextInt(5) + 1, new Random().nextInt(6) + 5};
    Random rand = new Random();
    
    public Mypanel(){
        setSize(600, 600);
        setLayout(new GridLayout(2, 2));

        for (int i = 0; i < jll.length; i++) {
            jll[i] = new JLabel("Change Color in " + time[i] + " sec", JLabel.CENTER);
            Myt[i] = new  MyThread(jll[i],time[i]);
            Myt[i].start();
            add(jll[i]);
        }
    }

    private MyT MyT(JLabel jLabel) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
class MyThread extends Thread{
    JLabel Jlb ;
    int time;
    Random rand = new Random();
    public MyThread(JLabel Jlb,int time) {
        this.Jlb = Jlb;
        this.time = time;
    }

    @Override
    public void run() {
        while (true) { 
            try {
                Thread.sleep(time*1000);
            } catch (Exception e) {
            }
            Jlb.setForeground(new Color(rand.nextInt(0xffffff)));
        }
    }
    
}
