import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DecimalListener implements ActionListener {

    private JLabel display;
    private boolean puntoDecimal;

    public DecimalListener(JLabel display) {
        this.display = display;
        this.puntoDecimal = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!puntoDecimal) {
            display.setText(display.getText() + ".");
            puntoDecimal = true;
        }
    }
}
