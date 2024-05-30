import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DecimalListener implements ActionListener {

    private final JLabel display;
    private final Calculadora calculadora;

    public DecimalListener(JLabel display, Calculadora calculadora) {
        this.display = display;
        this.calculadora = calculadora;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!calculadora.isPuntoDecimal()) {
            display.setText(display.getText() + ".");
            calculadora.setPuntoDecimal(true);
        }
    }
}
