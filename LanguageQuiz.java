import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LanguageQuiz extends JFrame {
    private JRadioButton cppButton, javaButton, pascalButton;
    private JLabel resultLabel;
    private Color primaryColor = new Color(70, 130, 180); // Steel blue
    private Color backgroundColor = new Color(240, 248, 255); // Alice blue

    public LanguageQuiz() {
        setTitle("Programming Language Quiz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(backgroundColor);

        // Create main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(20, 20));
        mainPanel.setBackground(backgroundColor);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Create header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(primaryColor);
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Create title label with styled text
        JLabel titleLabel = new JLabel("Programming Language Quiz");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        headerPanel.add(titleLabel);

        // Create question panel
        JPanel questionPanel = new JPanel();
        questionPanel.setLayout(new BorderLayout(10, 10));
        questionPanel.setBackground(backgroundColor);
        questionPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEtchedBorder(),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)));

        // Create question label
        JLabel questionLabel = new JLabel("Which of these is NOT an OOP language?");
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        questionPanel.add(questionLabel, BorderLayout.NORTH);

        // Create options panel
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(3, 1, 10, 10));
        optionsPanel.setBackground(backgroundColor);

        // Create styled radio buttons
        ButtonGroup group = new ButtonGroup();
        cppButton = createStyledRadioButton("C++");
        javaButton = createStyledRadioButton("Java");
        pascalButton = createStyledRadioButton("Pascal");

        group.add(cppButton);
        group.add(javaButton);
        group.add(pascalButton);

        optionsPanel.add(cppButton);
        optionsPanel.add(javaButton);
        optionsPanel.add(pascalButton);

        questionPanel.add(optionsPanel, BorderLayout.CENTER);

        // Create result panel
        JPanel resultPanel = new JPanel();
        resultPanel.setBackground(backgroundColor);
        resultLabel = new JLabel("");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        resultPanel.add(resultLabel);

        // Add action listeners
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JRadioButton button = (JRadioButton) e.getSource();
                if (button == pascalButton) {
                    showResult("Correct! Pascal is not primarily an OOP language.", true);
                } else {
                    showResult("Wrong! " + button.getText() + " is an OOP language.", false);
                }
            }
        };

        cppButton.addActionListener(listener);
        javaButton.addActionListener(listener);
        pascalButton.addActionListener(listener);

        // Add components to main panel
        mainPanel.add(questionPanel, BorderLayout.CENTER);
        mainPanel.add(resultPanel, BorderLayout.SOUTH);

        // Add panels to frame
        add(headerPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

        // Set frame size and make visible
        setSize(500, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JRadioButton createStyledRadioButton(String text) {
        JRadioButton button = new JRadioButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setBackground(backgroundColor);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    private void showResult(String message, boolean correct) {
        resultLabel.setText(message);
        resultLabel.setForeground(correct ? new Color(0, 128, 0) : new Color(178, 34, 34));
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> new LanguageQuiz());
    }
}

class Quiz {
    String question;
    String[] options;
    int correctAnswer;
    String correctMessage;
    String incorrectMessage;

    public Quiz(String question, String[] options, int correctAnswer,
            String correctMessage, String incorrectMessage) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.correctMessage = correctMessage;
        this.incorrectMessage = incorrectMessage;
    }
}