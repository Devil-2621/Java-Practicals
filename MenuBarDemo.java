import javax.swing.*;

public class MenuBarDemo extends JFrame {
    public MenuBarDemo() {
        setTitle("MenuBar Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create MenuBar
        JMenuBar menuBar = new JMenuBar();

        // Create File Menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem closeItem = new JMenuItem("Close");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem saveAsItem = new JMenuItem("Save As");
        JMenuItem printItem = new JMenuItem("Print");

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(closeItem);
        fileMenu.addSeparator();
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
        fileMenu.addSeparator();
        fileMenu.add(printItem);

        // Create Edit Menu
        JMenu editMenu = new JMenu("Edit");

        // Radio Button Menu Items
        ButtonGroup shapeGroup = new ButtonGroup();
        JRadioButtonMenuItem lineItem = new JRadioButtonMenuItem("Line");
        JRadioButtonMenuItem rectangleItem = new JRadioButtonMenuItem("Rectangle");
        JRadioButtonMenuItem circleItem = new JRadioButtonMenuItem("Circle");

        shapeGroup.add(lineItem);
        shapeGroup.add(rectangleItem);
        shapeGroup.add(circleItem);

        editMenu.add(lineItem);
        editMenu.add(rectangleItem);
        editMenu.add(circleItem);
        editMenu.addSeparator();

        // Checkbox Menu Items
        JCheckBoxMenuItem redItem = new JCheckBoxMenuItem("Red");
        JCheckBoxMenuItem greenItem = new JCheckBoxMenuItem("Green");
        JCheckBoxMenuItem blueItem = new JCheckBoxMenuItem("Blue");

        editMenu.add(redItem);
        editMenu.add(greenItem);
        editMenu.add(blueItem);

        // Add menus to MenuBar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        // Set MenuBar
        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MenuBarDemo().setVisible(true);
        });
    }
}