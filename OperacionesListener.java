import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class OperacionesListener implements ActionListener {

    private final JLabel display;
    private final Calculadora calculadora;

    public OperacionesListener(JLabel display, Calculadora calculadora) {
        this.display = display;
        this.calculadora = calculadora;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        String textoBoton = boton.getText();
        double operando2 = Double.parseDouble(display.getText());

        if (!calculadora.getOperacion().isEmpty()) {
            switch (calculadora.getOperacion()) {
                case "+" -> calculadora.setOperando1(calculadora.getOperando1() + operando2);
                case "-" -> calculadora.setOperando1(calculadora.getOperando1() - operando2);
                case "*" -> calculadora.setOperando1(calculadora.getOperando1() * operando2);
                case "/" -> calculadora.setOperando1(calculadora.getOperando1() / operando2);
            }
            display.setText(String.valueOf(calculadora.getOperando1()));
        } else {
            calculadora.setOperando1(operando2);
        }
        calculadora.setOperacion(textoBoton);
        calculadora.setNuevoNumero(true);
        calculadora.setPuntoDecimal(false);
    }
}
