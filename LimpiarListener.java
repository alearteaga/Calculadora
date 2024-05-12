import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LimpiarListener implements ActionListener {

    private JLabel display;

    public LimpiarListener(JLabel display) {
        this.display = display;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        display.setText("0");
    }
}
