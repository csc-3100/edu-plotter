package edu.plotter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Launches the Swing plotter and assembles three views of shared data.
 *
 * <p>The three panels demonstrate different Decorator chains. Clicking Run asks the shared Repository to generate a value; registered panels repaint through the Observer mechanism.</p>
 */
public class Main extends JFrame implements ActionListener {

    private PlotPanel[] panels = new PlotPanel[3];

    /** Creates the window, three decorated plots, and their observers. */
    public Main() {
        super("Decorated Chart");

        Plot plot = new Plot();
        SquareBlue squareBlue = new SquareBlue();
        BarGray barGray = new BarGray();
        barGray.add(squareBlue);
        squareBlue.add(plot);
        panels[0] = new PlotPanel(barGray);
        panels[0].setBackground(Color.LIGHT_GRAY);

        Plot worker3 = new Plot();
        SquareBlue toolSquare3 = new SquareBlue();
        toolSquare3.add(worker3);
        panels[1] = new PlotPanel(toolSquare3);
        panels[1].setBackground(Color.GRAY);

        Plot worker4 = new Plot();
        panels[2] = new PlotPanel(worker4);
        panels[2].setBackground(Color.DARK_GRAY);

        JButton button = new JButton("Run");
        button.addActionListener(this);

        setLayout(new GridLayout(4,1));

        for (int i = 0; i < panels.length; i++){
            add(panels[i]);
        }

        add(button);

        for (int i = 0; i < panels.length; i++){
            Repository.getInstance().addPropertyChangeListener(panels[i]);
        }

    }

    /** Generates one new value when the Run button is clicked. */
    @Override
    public void actionPerformed(ActionEvent e) {
        Repository.getInstance().create();
    }

    /** Starts the Swing application on the event-dispatch thread. */
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            Main main = new Main();
            main.setSize(501, 800);
            main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            main.setVisible(true);
        });
    }

}
