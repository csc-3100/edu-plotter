package edu.plotter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/** Application with three decorated views of one observable model. */
public final class Main extends JFrame implements ActionListener {
    public Main() {
        super("Decorated Chart");
        PlotPanel[] panels = {
            new PlotPanel(new BarGray(new SquareBlue(new Plot()))),
            new PlotPanel(new SquareBlue(new Plot())),
            new PlotPanel(new Plot())
        };
        Color[] colors = {Color.LIGHT_GRAY, Color.GRAY, Color.DARK_GRAY};
        setLayout(new GridLayout(4, 1));
        for (int i = 0; i < panels.length; i++) {
            panels[i].setBackground(colors[i]);
            add(panels[i]);
            Repository.getInstance().addPropertyChangeListener(panels[i]);
        }
        JButton button = new JButton("Run");
        button.addActionListener(this);
        add(button);
    }
    @Override public void actionPerformed(ActionEvent event) { Repository.getInstance().create(); }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main window = new Main();
            window.setSize(501, 800);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setVisible(true);
        });
    }
}
