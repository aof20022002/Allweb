package LEP5;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;


public class gui5 {
    public static void main(String[] args) {
        frame f = new frame();
        f.setVisible(true);
    }
}
/**
 * Innergui5
 */
class frame extends JFrame {
    public frame(){
        setSize(200,50);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 1));
    }
}