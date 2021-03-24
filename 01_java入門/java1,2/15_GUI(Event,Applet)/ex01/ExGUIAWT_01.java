import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/*
<applet code = "ExGUIAWT_01" width=400 height=400></applet> 
*/

public class ExGUIAWT_01 extends Applet {

    public void init() {
        this.resize(400, 300);
    }

    public void paint(Graphics g) {
        String messageText = "April 13 2020";
        g.drawString(messageText, 150, 150);
        Color selctedColor = Color.red;
        g.setColor(selctedColor);
        g.drawOval(100, 50, 200, 200);
    }
}