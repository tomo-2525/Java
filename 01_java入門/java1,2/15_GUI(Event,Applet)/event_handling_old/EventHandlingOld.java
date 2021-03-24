import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*
<APPLET CODE=EventHandlingOld.class WIDTH=400 HEIGHT=200>
</APPLET> */

public class EventHandlingOld extends Applet {
    String message = "";
    Button button1 = new Button("Label Set"), button2 = new Button("OK");

    public void init() {
        add(button1);
        add(button2);
    }

    public void paint(Graphics g) {
        g.drawString(message, 20, 70);
    }

    /* Old Model for Event Handling */
    public boolean action(Event e, Object arg) {
        if (e.target instanceof Button) {
            if (e.target.equals(button1)) {
                message = "Label Set Button Clicked!";
            } else if (e.target.equals(button2)) {
                message = "OK Button Clicked!";
            }
            repaint();
        }
        return true;
    }
    /* end of code for event handling */
} // End of the EventHandlingOld Class