import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/*
<applet code = "ExGUIAWT_03" width=400 height=400></applet> 
*/

public class ExGUIAWT_03 extends ExGUIAWT_02 implements MouseListener, MouseMotionListener {

    int x1, x2;

    public void init() {
        super.init();
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
    }

    public void mouseMoved(MouseEvent me) {
    }

    public void mouseClicked(MouseEvent me) {
    }

    public void mouseEntered(MouseEvent me) {
    }

    public void mouseExited(MouseEvent me) {
    }

    public void mousePressed(MouseEvent me) {
        x1 = me.getX();
    }

    public void mouseReleased(MouseEvent me) {
    }

    public void mouseDragged(MouseEvent me) {
        x2 = me.getX();
        if ((x2 - x1) > 0)
            super.num++;
        else
            super.num--;

        super.L.setText(String.valueOf(num));
    }
}