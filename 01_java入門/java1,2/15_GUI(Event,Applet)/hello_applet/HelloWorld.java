import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

public class HelloWorld extends Applet {// [1]  
    public void paint(Graphics g) { // [2]
        Dimension size = getSize();// [3]
        g.setColor(Color.blue);// [4]
        g.drawOval(10, 10, size.width - 20, size.height - 20);// [5]
        g.drawString("Hello World!", size.width / 2 - 30, size.height / 2 + 5);// [6]
    }
}