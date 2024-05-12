import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Calculadora extends JFrame {

    private JLabel display;

    public Calculadora() {
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
            button.addActionListener(this::actionPerformed);
            panelBotones.add(button);
        }

        add(panelBotones, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String buttonText = button.getText();

        switch (buttonText) {
            case "+":
            case "-":
            case "*":
            case "/":
                new OperacionesListener(display).actionPerformed(e);
                break;
            case "Resultado":
                new ResultadoListener(display).actionPerformed(e);
                break;
            case "C":
                new LimpiarListener(display).actionPerformed(e);
                break;
            case ".":
                new DecimalListener(display).actionPerformed(e);
                break;
            default:
                new NumerosListener(display).actionPerformed(e);
                break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculadora::new);
    }
}
