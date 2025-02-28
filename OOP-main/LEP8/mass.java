
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class mass {

    public static void main(String[] args) {
        Myframe myframe = new Myframe();
        myframe.setVisible(true);
    }
}

class Myframe extends JFrame {

    public Myframe() {
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        PanelM Plm = new PanelM();
        PanelS Pls = new PanelS();
        add(Pls, BorderLayout.WEST);
        add(Plm, BorderLayout.EAST);
    }
}
class PanelM extends JPanel{
    JTextField address = new JTextField("");
    JTextField message = new JTextField("");
    JButton jbtM = new JButton("sen");
    public PanelM() {
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400,0));
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(3, 1)); // 3 แถว: 2 text fields + 1 button
        bottomPanel.add(address);
        bottomPanel.add(message);
        bottomPanel.add(jbtM);

        
        jbtM.setPreferredSize(new Dimension(0, 40));

        add(bottomPanel, BorderLayout.SOUTH);

        jbtM.
    }
}
class PanelS extends JPanel {

    public PanelS() {
        setBackground(Color.CYAN);
        setLayout(null);
        setPreferredSize(new Dimension(586, 0));
    }
}

class setMessenger {
    private static final long serialVersionUID = 485755;
    private String name;
    private String message;
    private Date date;

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getMessage() {
        return message;
    }

    void setMessage(String message) {
        this.message = message;
    }

    Date getDate() {
        return date;
    }

    void setDate(Date date) {
        this.date = date;
    }
}
