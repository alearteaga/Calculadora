import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultadoListener implements ActionListener {

    private JLabel display;
    private double operando1;
    private String operacion;

    public ResultadoListener(JLabel display) {
        this.display = display;
        this.operando1 = 0;
        this.operacion = "";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double operando2 = Double.parseDouble(display.getText());
        double resultado = 0;

        switch (operacion) {
            case "+":
                resultado = operando1 + operando2;
                break;
            case "-":
                resultado = operando1 - operando2;
                break;
            case "*":
                resultado = operando1 * operando2;
                break;
            case "/":
                resultado = operando1 / operando2;
                break;
        }

        display.setText(String.valueOf(resultado));
        operando1 = resultado;
        operacion = "";
    }
}
