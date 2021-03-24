import java.awt.*;
import java.awt.event.*;

public class HelloExample extends Frame {// Using Frame
    Label contents;
    Button dispbutton;

    public HelloExample() { // Constructor
        setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
        contents = new Label(" "); // Create Label object
        add(contents); // Add the label to this Frame
        dispbutton = new Button("Show"); // Create Button object
        dispbutton.addActionListener(e -> contents.setText("Hellow World! - By Lambda Expression"));
        // Using Anonymous Class
        add(dispbutton); // Add the button object to this Frame
    }

    public static void main(String[] args) {
        HelloExample f = new HelloExample(); // Create Hello GUI f.setTitle("Hello!");
        f.setSize(400, 150);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
} // end of HelloExample.java