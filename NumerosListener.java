import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class NumerosListener implements ActionListener {

    private final JLabel display;
    private final Calculadora calculadora;

    public NumerosListener(JLabel display, Calculadora calculadora) {
        this.display = display;
        this.calculadora = calculadora;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        String textoBoton = boton.getText();

        if (calculadora.isNuevoNumero()) {
            if (textoBoton.equals(".")) {
                display.setText("0.");
                calculadora.setPuntoDecimal(true);
            } else {
                display.setText(textoBoton);
            }
            calculadora.setNuevoNumero(false);
        } else {
            if (!textoBoton.equals(".") || !calculadora.isPuntoDecimal()) {
                display.setText(display.getText() + textoBoton);
                if (textoBoton.equals(".")) {
                    calculadora.setPuntoDecimal(true);
                }
            }
        }
    }
}
