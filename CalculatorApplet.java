import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorApplet extends JFrame implements ActionListener {
    private JTextField display;
    private String operator = "";
    private double firstNumber = 0;
    private boolean isNewCalculation = true;

    public CalculatorApplet() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));
        setResizable(false);

        // Display
        display = new JTextField("0");
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setPreferredSize(new Dimension(200, 50));
        display.setFont(new Font("Arial", Font.BOLD, 20));
        display.setEditable(false);
        display.setBackground(Color.WHITE);

        // Button panel
        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 5, 5));

        // Add buttons
        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C", "←", "(", ")"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(this);
            if (label.equals("=")) {
                button.setBackground(new Color(98, 168, 234));
            } else if ("+-*/".contains(label)) {
                button.setBackground(new Color(220, 220, 220));
            }
            buttonPanel.add(button);
        }

        // Add components to frame
        add(display, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        // Set window properties
        setBackground(Color.WHITE);
        setBounds(300, 300, 300, 400);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        try {
            if ("0123456789.".contains(command)) {
                if (isNewCalculation) {
                    display.setText(command);
                    isNewCalculation = false;
                } else {
                    display.setText(display.getText() + command);
                }
            } else if ("+-*/".contains(command)) {
                firstNumber = Double.parseDouble(display.getText());
                operator = command;
                isNewCalculation = true;
            } else if ("=".equals(command)) {
                if (!operator.isEmpty()) {
                    double secondNumber = Double.parseDouble(display.getText());
                    double result = calculateResult(firstNumber, secondNumber, operator);
                    display.setText(String.valueOf(result));
                    operator = "";
                    isNewCalculation = true;
                }
            } else if ("C".equals(command)) {
                display.setText("0");
                firstNumber = 0;
                isNewCalculation = true;
            } else if ("←".equals(command)) {
                String currentText = display.getText();
                if (currentText.length() > 0) {
                    display.setText(currentText.substring(0, currentText.length() - 1));
                    if (display.getText().isEmpty()) {
                        display.setText("0");
                        isNewCalculation = true;
                    }
                }
            }
        } catch (NumberFormatException ex) {
            display.setText("Error");
            isNewCalculation = true;
        }
    }

    private double calculateResult(double a, double b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return b != 0 ? a / b : Double.POSITIVE_INFINITY;
            default:
                return b;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorApplet calc = new CalculatorApplet();
            calc.setVisible(true);
        });
    }
}