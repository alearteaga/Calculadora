import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LimpiarListener implements ActionListener {

    private final JLabel display;
    private final Calculadora calculadora;

    public LimpiarListener(JLabel display, Calculadora calculadora) {
        this.display = display;
        this.calculadora = calculadora;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        display.setText("0");
        calculadora.setNuevoNumero(true);
        calculadora.setPuntoDecimal(false);
        calculadora.setOperacion("");
        calculadora.setOperando1(0);
    }
}
