package edu.plotter.classic;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;
/**
 * A Swing panel observing generated values and delegating drawing to a Worker.
 * <p>Original CSC308 implementation, preserved for comparison.</p>
 */
public class PlotPanel extends JPanel implements Observer {
    protected static final int MAX_NUMBER_OF_VALUES = 20;
    protected LinkedList<Integer> values = new LinkedList<>();
    Worker worker;
    public void addValue(int v){
        values.add(v);
        if(values.size() >MAX_NUMBER_OF_VALUES){
            values.removeFirst();
        }
    }
    public PlotPanel(Worker worker){
        this.worker = worker;
    }
    @Override
    public void update(Observable o, Object arg) {
        addValue(((Source) o).getValue());
        repaint();
    }
    public static int getMaxNumberOfValues(){
        return MAX_NUMBER_OF_VALUES;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(worker!=null)
            worker.draw(g, values);
    }
}