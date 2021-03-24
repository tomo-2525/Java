import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/*
<applet code = "ExGUIAWT_02" width=400 height=400></applet> 
*/

public class ExGUIAWT_02 extends ExGUIAWT_01 implements ActionListener {

    private Button btn_plus;
    private Button btn_mainasu;
    protected int num = 0;
    protected Label L = new Label(String.valueOf(num));

    public void init() {
        super.init();
        btn_plus = new Button("+");
        btn_mainasu = new Button("-");
        btn_plus.addActionListener(this);
        btn_mainasu.addActionListener(this);
        add(btn_mainasu);
        add(L);
        add(btn_plus);
    }

    public void actionPerformed(ActionEvent e) {

        Object o = e.getSource();

        if (o == btn_plus) {
            num++;
        }
        if (o == btn_mainasu) {
            num--;
        }
        L.setText(String.valueOf(num));
    }

}