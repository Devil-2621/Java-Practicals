import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class TextFileWriterApplet extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JTextField fileName;
    private JButton saveButton;

    public TextFileWriterApplet() {
        setLayout(new BorderLayout(5, 5));
        setTitle("Simple Text Writer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Using modern looking fonts and colors
        UIManager.put("Button.background", new Color(70, 130, 180));
        UIManager.put("Button.foreground", Color.WHITE);

        textArea = new JTextArea(8, 30);
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        textArea.setMargin(new Insets(5, 5, 5, 5));

        fileName = new JTextField(15);
        fileName.setFont(new Font("Arial", Font.PLAIN, 14));

        saveButton = new JButton("Save");
        saveButton.setFocusPainted(false);

        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        inputPanel.add(new JLabel("File Name:"));
        inputPanel.add(fileName);
        inputPanel.add(saveButton);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        saveButton.addActionListener(this);

        // Make window smaller
        pack();
        setLocationRelativeTo(null); // Center on screen
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String content = textArea.getText();
            String name = fileName.getText();

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please enter a file name",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            FileWriter fw = new FileWriter(name);
            fw.write(content);
            fw.close();

            JOptionPane.showMessageDialog(this,
                    "File saved successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Error saving file: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TextFileWriterApplet());
    }
}