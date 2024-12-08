import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RectangleDrawApplet extends JPanel implements MouseListener, MouseMotionListener {
    private int startX, startY, currentX, currentY;
    private boolean drawing = false;
    private Color drawColor = Color.blue;
    private int strokeWidth = 2;

    public RectangleDrawApplet() {
        setLayout(new BorderLayout());
        addMouseListener(this);
        addMouseMotionListener(this);
        setBackground(Color.white);

        // Create toolbar panel
        JPanel toolBar = new JPanel();
        toolBar.setBackground(new Color(240, 240, 240));

        // Color buttons
        JButton blueBtn = createColorButton("Blue", Color.blue);
        JButton redBtn = createColorButton("Red", Color.red);
        JButton greenBtn = createColorButton("Green", Color.green);
        JButton blackBtn = createColorButton("Black", Color.black);
        JButton purpleBtn = createColorButton("Purple", new Color(128, 0, 128));

        // Stroke width control
        JLabel strokeLabel = new JLabel("Line Width: ");
        JSpinner strokeSpinner = new JSpinner(new SpinnerNumberModel(2, 1, 10, 1));
        strokeSpinner.addChangeListener(_ -> {
            strokeWidth = (Integer) strokeSpinner.getValue();
        });

        // Clear button
        JButton clearBtn = new JButton("Clear");
        clearBtn.addActionListener(_ -> {
            drawing = false;
            repaint();
        });

        // Add components to toolbar
        toolBar.add(strokeLabel);
        toolBar.add(strokeSpinner);
        toolBar.add(blueBtn);
        toolBar.add(redBtn);
        toolBar.add(greenBtn);
        toolBar.add(blackBtn);
        toolBar.add(purpleBtn);
        toolBar.add(clearBtn);

        // Add toolbar to the panel
        add(toolBar, BorderLayout.NORTH);
    }

    private JButton createColorButton(String name, Color color) {
        JButton button = new JButton(name);
        button.setBackground(color);
        button.setForeground(color.equals(Color.black) ? Color.white : Color.black);
        button.addActionListener(_ -> {
            drawColor = color;
        });
        return button;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(strokeWidth));
        g2d.setColor(drawColor);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (drawing) {
            g2d.drawRect(Math.min(startX, currentX),
                    Math.min(startY, currentY),
                    Math.abs(currentX - startX),
                    Math.abs(currentY - startY));
        }
    }

    // Mouse event handlers remain the same
    public void mousePressed(MouseEvent me) {
        startX = me.getX();
        startY = me.getY();
        drawing = true;
        currentX = startX;
        currentY = startY;
    }

    public void mouseDragged(MouseEvent me) {
        currentX = me.getX();
        currentY = me.getY();
        repaint();
    }

    public void mouseReleased(MouseEvent me) {
        drawing = false;
    }

    public void mouseClicked(MouseEvent me) {
    }

    public void mouseEntered(MouseEvent me) {
    }

    public void mouseExited(MouseEvent me) {
    }

    public void mouseMoved(MouseEvent me) {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Rectangle Drawing App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new RectangleDrawApplet());
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}