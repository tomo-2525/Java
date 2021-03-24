import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class ExGUISwing_03 extends ExGUISwing_02 implements ActionListener {
    protected JLabel label_coner = new JLabel("AM");
    protected String FMChannels[] = { "76.1", "80.0", "81.3", "82.5" };
    protected String AMChannels[] = { "594", "954", "1134", "1242" };
    protected boolean powerOff = true;
    protected boolean CD = true;
    protected boolean FM = false;
    protected int FMIndex = 0;
    protected int AMIndex = 0;
    protected int CDIndex = 0;

    public ExGUISwing_03(String tittle) {
        super(tittle);
        label_coner.setBounds(10, 10, 25, 20);
        super.panel.add(label_coner);
        super.btn_CD.addActionListener(this);
        super.btn_AM.addActionListener(this);
        super.btn_FM.addActionListener(this);
        super.btn_Up.addActionListener(this);
        super.btn_Down.addActionListener(this);
        super.btn_PW.addActionListener(this);
        Reshow();
    }

    public void actionPerformed(ActionEvent actionevent) {
        // System.out.println("pushed");
        Object obj = actionevent.getSource();
        if (obj == super.btn_PW)
            powerOff = true;
        if (obj == super.btn_CD) {
            powerOff = false;
            CD = true;
        }
        if (obj == super.btn_AM) {
            powerOff = false;
            CD = false;
            FM = false;
        }
        if (obj == super.btn_FM) {
            powerOff = false;
            CD = false;
            FM = true;
        }
        if (obj == super.btn_Up)
            if (CD)
                CDIndex++;
            else if (FM)
                FMIndex++;
            else
                AMIndex++;
        if (obj == super.btn_Down)
            if (CD)
                CDIndex--;
            else if (FM)
                FMIndex--;
            else
                AMIndex--;
        Reshow();
    }

    private void Reshow() {
        if (powerOff) {
            label_coner.setVisible(false);
            super.label.setText("Power off");
            btn_PW.setEnabled(false);
            super.btn_Up.setEnabled(false);
            super.btn_Down.setEnabled(false);
            return;
        }

        btn_PW.setEnabled(true);
        super.btn_Up.setEnabled(true);
        super.btn_Down.setEnabled(true);
        if (CD) {
            label_coner.setVisible(false);
            if (CDIndex <= 0)
                super.btn_Down.setEnabled(false);
            super.label.setText("Track" + (CDIndex + 1) + "/20");
            if (CDIndex >= 19)
                super.btn_Up.setEnabled(false);
            return;
        }
        label_coner.setVisible(true);
        if (FM) {

            label_coner.setText("FM");

            if (FMIndex <= 0)
                super.btn_Down.setEnabled(false);
            super.label.setText(FMChannels[FMIndex] + "MHz");
            if (FMIndex >= FMChannels.length - 1)
                super.btn_Up.setEnabled(false);
            return;
        }

        label_coner.setText("AM");
        if (AMIndex <= 0)
            super.btn_Down.setEnabled(false);
        super.label.setText(AMChannels[AMIndex] + "kHz");

        if (AMIndex >= AMChannels.length - 1)
            super.btn_Up.setEnabled(false);

    }

    public static void main(String[] args) {
        JFrame frame = new ExGUISwing_03("ExGUISwing-03");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
