import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;

public class ExGUISwing_02 extends ExGUISwing_01 {

    protected JButton btn_PW;
    protected JButton btn_AM;
    protected JButton btn_FM;
    protected JButton btn_CD;
    protected JButton btn_Up;
    protected JButton btn_Down;
    protected JPanel panel = new JPanel();
    protected BevelBorder border = new BevelBorder(BevelBorder.LOWERED, Color.white, Color.gray);
    protected JLabel label;

    ExGUISwing_02(String title) {
        super(title);
        this.setSize(355, 145);

        Container cnt = this.getContentPane();
        panel.setLayout(null);
        cnt.setLayout(null);

        btn_PW = new JButton("PW");
        btn_AM = new JButton("AM");
        btn_FM = new JButton("FM");
        btn_CD = new JButton("CD");
        btn_Up = new JButton("Up");
        btn_Down = new JButton("Down");

        btn_PW.setSize(70, 30);
        btn_PW.setLocation(2, 5);
        add(btn_PW);

        btn_AM.setSize(70, 30);
        btn_AM.setLocation(2, 45);
        add(btn_AM);

        btn_FM.setSize(70, 30);
        btn_FM.setLocation(2, 85);
        add(btn_FM);

        btn_CD.setSize(70, 30);
        btn_CD.setLocation(280, 5);
        add(btn_CD);

        btn_Up.setSize(70, 30);
        btn_Up.setLocation(280, 45);
        add(btn_Up);

        btn_Down.setSize(70, 30);
        btn_Down.setLocation(280, 85);
        add(btn_Down);

        panel.setBorder(border);
        panel.setLocation(75, 2);
        panel.setSize(200, 105);
        cnt.add(panel);

        label = new JLabel("Power off");
        label.setFont(new Font("Arial", Font.BOLD, 32));
        label.setForeground(new Color(0, 128, 0));
        label.setSize(170, 40);
        label.setLocation(25, 50);
        panel.add(label, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        ExGUISwing_02 frame = new ExGUISwing_02("ExGUISwing_02");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}