package OOP.LEP4;

import java.awt.*;

import java.util.Random;

public class F01 {
    public static void main(String[] args) {
   
        Frame frame = new Frame("is button");
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        
        
        for (int i = 1; i <= 50; i++) {
           Button button = new Button("Button"+ (i));
           Random random = new Random();
           int y = random.nextInt(500);
           int x = random.nextInt(500);

           int r = random.nextInt(256);
           int g = random.nextInt(256);
           int b = random.nextInt(256);
           Color color = new Color(r,g,b);
          
           button.setBackground(color);
           button.setBounds(x, y, 40, 40);
           frame.add(button);
           
        }
       

        frame.setVisible(true);
        
    }
}
