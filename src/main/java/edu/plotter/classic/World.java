package edu.plotter.classic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Creates four decorated charts and a Run button.
 * <p>Original CSC308 implementation, preserved for comparison.</p>
 */
public class World extends JFrame implements ActionListener{
    private PlotPanel top, mid1, mid2, bot;
    private Source source;
    public World(){
        super("Decorated Chart");

        WorkerStandard worker1 = new WorkerStandard();
        WorkerToolSquare toolSquare1 = new WorkerToolSquare();
        WorkerToolLine toolLine1 = new WorkerToolLine();
        WorkerToolAvg toolAvg1 = new WorkerToolAvg();
        toolAvg1.add(worker1);
        toolLine1.add(toolSquare1);
        toolSquare1.add(toolAvg1);
        top = new PlotPanel(toolLine1);
        top.setBackground(Color.WHITE);

        WorkerStandard worker2 = new WorkerStandard();
        WorkerToolSquare toolSquare2 = new WorkerToolSquare();
        WorkerToolLine toolLine2 = new WorkerToolLine();
        toolLine2.add(toolSquare2);
        toolSquare2.add(worker2);
        mid1 = new PlotPanel(toolLine2);
        mid1.setBackground(Color.LIGHT_GRAY);

        WorkerStandard worker3 = new WorkerStandard();
        WorkerToolSquare toolSquare3 = new WorkerToolSquare();
        toolSquare3.add(worker3);
        mid2 = new PlotPanel(toolSquare3);
        mid2.setBackground(Color.GRAY);

        WorkerStandard worker4 = new WorkerStandard();
        bot = new PlotPanel(worker4);
        bot.setBackground(Color.DARK_GRAY);

        JButton button = new JButton("Run");
        button.addActionListener(this);

        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.add(top);
        panel.add(mid1);
        panel.add(mid2);
        panel.add(bot);
        add(button, BorderLayout.SOUTH);
        add(panel, BorderLayout.CENTER);

        source = new Source();
        source.addObserver(top);
        source.addObserver(mid1);
        source.addObserver(mid2);
        source.addObserver(bot);
    }
    public static void main(String[] args){
        World world = new World();
        world.setSize(501, 800);
        world.setVisible(true);
        world.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        source.create();
    }
}
