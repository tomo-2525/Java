import java.awt.*;
import java.awt.event.*;

public class HelloAWT extends Frame {
    Label contents;
    Button dispbutton;

    // Using Frame
    public HelloAWT() { // Constructor
        setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
        contents = new Label("           "); // CreateLabelobject add(contents); // Add the label to this Frame
        dispbutton = new Button("Show"); // Create Button object
        dispbutton.addActionListener(new DispButtonListener()); // Add Event Listener
        add(dispbutton); // Add the button object to this Frame
    }

    class DispButtonListener implements ActionListener { // Event Listener
        public void actionPerformed(ActionEvent e) { // What to do when the button is clicked
            contents.setText("Hello World!");
        }
    }

    public static void main(String[] args) {
        HelloAWT f = new HelloAWT(); // CreateHelloGUI
        f.setTitle("Hello!");
        f.setSize(400, 150);
        f.setVisible(true);
    }
} // end of “HelloAWT.java”
