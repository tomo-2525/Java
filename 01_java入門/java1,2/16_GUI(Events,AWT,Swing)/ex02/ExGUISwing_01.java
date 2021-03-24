import javax.swing.*;

public class ExGUISwing_01 extends JFrame {

    ExGUISwing_01(String title) {
        super.setTitle(title);
        super.setSize(400, 400);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String argv[]) {
        ExGUISwing_01 frame = new ExGUISwing_01("ExGUISwing_01");
        frame.setVisible(true);
    }
}