import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperacionesListener implements ActionListener {

    private JLabel display;
    private String operacion;
    private double operando1;
    private boolean nuevoNumero;
    private boolean puntoDecimal;

    public OperacionesListener(JLabel display) {
        this.display = display;
        this.operacion = "";
        this.operando1 = 0;
        this.nuevoNumero = true;
        this.puntoDecimal = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        String textoBoton = boton.getText();
        double operando2 = Double.parseDouble(display.getText());

        if (!operacion.equals("")) {
            switch (operacion) {
                case "+":
                    operando1 += operando2;
                    break;
                case "-":
                    operando1 -= operando2;
                    break;
                case "*":
                    operando1 *= operando2;
                    break;
                case "/":
                    operando1 /= operando2;
                    break;
            }
            display.setText(String.valueOf(operando1));
        } else {
            operando1 = operando2;
        }
        operacion = textoBoton;
        nuevoNumero = true;
        puntoDecimal = false;
    }
}
