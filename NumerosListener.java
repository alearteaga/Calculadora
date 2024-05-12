import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumerosListener implements ActionListener {

    private JLabel display;
    private boolean nuevoNumero;
    private boolean puntoDecimal;

    public NumerosListener(JLabel display) {
        this.display = display;
        this.nuevoNumero = true;
        this.puntoDecimal = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        String textoBoton = boton.getText();

        if (nuevoNumero) {
            if (textoBoton.equals(".")) {
                display.setText("0.");
                puntoDecimal = true;
            } else {
                display.setText(textoBoton);
            }
            nuevoNumero = false;
        } else {
            if (!textoBoton.equals(".") || !puntoDecimal) {
                display.setText(display.getText() + textoBoton);
                if (textoBoton.equals(".")) puntoDecimal = true;
            }
        }
    }
}
