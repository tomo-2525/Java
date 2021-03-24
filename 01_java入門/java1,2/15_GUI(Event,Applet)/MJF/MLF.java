import java.awt.*;
import java.awt.event.*;

class MLF extends Frame implements MouseListener {
    MLF() {
        super("Example: MouseListener");
        addMouseListener(this);
        setSize(250, 100);
    }

    public void mouseClicked(MouseEvent me) {
    }

    public void mouseEntered(MouseEvent me) {
    }

    public void mouseExited(MouseEvent me) {
    }

    public void mousePressed(MouseEvent me) {
    }

    public void mouseReleased(MouseEvent me) {
        System.out.println(me);
    }

    public static void main(String[] args) {
        new MLF().setVisible(true);
    }
}