import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Calculadora extends JFrame {

    private JLabel display;
    private double operando1;
    private String operacion;
    private boolean nuevoNumero;
    private boolean puntoDecimal;

    public Calculadora() {
        operando1 = 0;
        operacion = "";
        nuevoNumero = true;
        puntoDecimal = false;
        initUI();
    }

    private void initUI() {
        setTitle("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Display
        display = new JLabel("0", SwingConstants.RIGHT);
        display.setPreferredSize(new Dimension(300, 50));
        display.setBorder(new LineBorder(Color.BLACK));
        add(display, BorderLayout.NORTH);

        // Botones
        JPanel panelBotones = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] buttonTexts = {
            "Resultado", "7", "8", "9",
            "/", "4", "5", "6",
            "*", "1", "2", "3",
            "-", "C", "0", ".",
            "+"
        };

        for (String text : buttonTexts) {
            JButton button = new JButton(text);
            switch (text) {
                case "+" -> button.addActionListener(new OperacionesListener(display, this));
                case "-" -> button.addActionListener(new OperacionesListener(display, this));
                case "*" -> button.addActionListener(new OperacionesListener(display, this));
                case "/" -> button.addActionListener(new OperacionesListener(display, this));
                case "Resultado" -> button.addActionListener(new ResultadoListener(display, this));
                case "C" -> button.addActionListener(new LimpiarListener(display, this));
                case "." -> button.addActionListener(new DecimalListener(display, this));
                default -> button.addActionListener(new NumerosListener(display, this));
            }
            panelBotones.add(button);
        }

        add(panelBotones, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Getters y Setters
    public boolean isNuevoNumero() {
        return nuevoNumero;
    }

    public void setNuevoNumero(boolean nuevoNumero) {
        this.nuevoNumero = nuevoNumero;
    }

    public boolean isPuntoDecimal() {
        return puntoDecimal;
    }

    public void setPuntoDecimal(boolean puntoDecimal) {
        this.puntoDecimal = puntoDecimal;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public double getOperando1() {
        return operando1;
    }

    public void setOperando1(double operando1) {
        this.operando1 = operando1;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculadora::new);
    }
}
